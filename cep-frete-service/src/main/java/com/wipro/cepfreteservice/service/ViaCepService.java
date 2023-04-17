package com.wipro.cepfreteservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.cepfreteservice.exception.CepNotFoundException;
import com.wipro.cepfreteservice.model.Endereco;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ViaCepService {

    @Value("${viacep.url}")
    private String viaCepUrl;

    private final RestTemplate restTemplate;

    public ViaCepService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Endereco buscaEnderecoPorCep(String cep) {
        String cepSemHifen = cep.replaceAll("-", "");
        String url = viaCepUrl + cepSemHifen + "/json";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonNode = objectMapper.readTree(response.getBody());
                if (jsonNode.has("erro") && jsonNode.get("erro").asBoolean()) {
                    throw new CepNotFoundException("CEP não encontrado");
                } else {
                    return objectMapper.convertValue(jsonNode, Endereco.class);
                }
            } catch (IOException e) {
                throw new RuntimeException("Erro ao processar a resposta da API ViaCEP", e);
            }
        } else {
            throw new RuntimeException("Erro na requisição para a API ViaCEP, status code: " + response.getStatusCode());
        }
    }
}