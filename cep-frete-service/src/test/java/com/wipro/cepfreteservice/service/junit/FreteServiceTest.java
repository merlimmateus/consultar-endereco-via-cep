package com.wipro.cepfreteservice.service.junit;

import com.wipro.cepfreteservice.service.FreteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FreteServiceTest {

    private FreteService freteService;

    @BeforeEach
    public void setUp() {
        freteService = new FreteService();
    }

    @Test
    public void testCalculaFreteSudeste() {
        String estado = "SP";
        double expectedFrete = 7.85;
        double actualFrete = freteService.calculaFrete(estado);
        assertEquals(expectedFrete, actualFrete, 0.01, "O frete calculado para o estado Sudeste deve ser igual ao esperado");
    }

    @Test
    public void testCalculaFreteSul() {
        String estado = "RS";
        double expectedFrete = 17.30;
        double actualFrete = freteService.calculaFrete(estado);
        assertEquals(expectedFrete, actualFrete, 0.01, "O frete calculado para o estado Sul deve ser igual ao esperado");
    }

    @Test
    public void testCalculaFreteNorte() {
        String estado = "AM";
        double expectedFrete = 20.83;
        double actualFrete = freteService.calculaFrete(estado);
        assertEquals(expectedFrete, actualFrete, 0.01, "O frete calculado para o estado Norte deve ser igual ao esperado");
    }

    @Test
    public void testCalculaFreteNordeste() {
        String estado = "BA";
        double expectedFrete = 15.98;
        double actualFrete = freteService.calculaFrete(estado);
        assertEquals(expectedFrete, actualFrete, 0.01, "O frete calculado para o estado Nordeste deve ser igual ao esperado");
    }

    @Test
    public void testCalculaFreteCentroOeste() {
        String estado = "GO";
        double expectedFrete = 12.50;
        double actualFrete = freteService.calculaFrete(estado);
        assertEquals(expectedFrete, actualFrete, 0.01, "O frete calculado para o estado Centro-Oeste deve ser igual ao esperado");
    }

    @Test
    public void testCalculaFreteEstadoInvalido() {
        String estado = "XX";
        assertThrows(IllegalArgumentException.class, () -> freteService.calculaFrete(estado), "Deve lançar uma exceção para estados inválidos");
    }

}