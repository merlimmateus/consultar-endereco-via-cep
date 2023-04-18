package com.wipro.cepfreteservice.service.junit;

import com.wipro.cepfreteservice.exception.CepNotFoundException;
import com.wipro.cepfreteservice.model.Endereco;
import com.wipro.cepfreteservice.service.ViaCepService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ViaCepServiceTest {

    private ViaCepService viaCepService;

    private static final String jsonEnderecoValido = "{" +
            "\"cep\": \"01001-000\"," +
            "\"logradouro\": \"Praça da Sé\"," +
            "\"localidade\": \"São Paulo\"," +
            "\"uf\": \"SP\"" +
            "}";

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private RestTemplateBuilder restTemplateBuilder;

    private String viaCepUrl;

    private void setViaCepUrl(String viaCepUrl) {
        ReflectionTestUtils.setField(viaCepService, "viaCepUrl", viaCepUrl);
    }

    @BeforeEach
    void setUp() {
        viaCepUrl = "https://viacep.com.br/ws/";
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        viaCepService = new ViaCepService(restTemplateBuilder);
        setViaCepUrl(viaCepUrl);
    }

    @Test
    void testBuscaEnderecoPorCepValido() {
        String cep = "01001-000";
        String cepSemHifen = "01001000";

        when(restTemplate.getForEntity(eq(viaCepUrl + cepSemHifen + "/json"), eq(String.class)))
                .thenReturn(new ResponseEntity<>(jsonEnderecoValido, HttpStatus.OK));

        Endereco endereco = viaCepService.buscaEnderecoPorCep(cep);

        assertEquals("01001-000", endereco.getCep());
        assertEquals("Praça da Sé", endereco.getRua());
        assertEquals("São Paulo", endereco.getCidade());
        assertEquals("SP", endereco.getEstado());
    }

    @Test
    void testBuscaEnderecoPorCepInvalido() {
        String cepInvalido = "00000000";
        String jsonResponse = "{\"erro\": true}";
        when(restTemplate.getForEntity(eq(viaCepUrl + cepInvalido + "/json"), eq(String.class)))
                .thenReturn(new ResponseEntity<>(jsonResponse, HttpStatus.OK));

        assertThrows(CepNotFoundException.class, () -> viaCepService.buscaEnderecoPorCep(cepInvalido));
    }

    @Test
    void testBuscaEnderecoPorCepRequestError() {
        String cep = "12345678";
        when(restTemplate.getForEntity(eq(viaCepUrl + cep + "/json"), eq(String.class)))
                .thenReturn(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

        assertThrows(RuntimeException.class, () -> viaCepService.buscaEnderecoPorCep(cep));
    }
}
