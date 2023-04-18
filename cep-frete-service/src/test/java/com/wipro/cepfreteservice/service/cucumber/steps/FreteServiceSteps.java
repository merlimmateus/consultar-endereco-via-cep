package com.wipro.cepfreteservice.service.cucumber.steps;

import com.wipro.cepfreteservice.service.FreteService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class FreteServiceSteps {

    private String estado;
    private double valorFrete;
    private Exception exception;
    private final FreteService freteService;

    @Autowired
    public FreteServiceSteps(FreteService freteService) {
        this.freteService = freteService;
    }

    @Given("Um estado {string}")
    public void umEstado(String estado) {
        this.estado = estado;
    }

    @When("Calcular o frete")
    public void calcularOFrete() {
        try {
            valorFrete = freteService.calculaFrete(estado);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("O valor do frete deve ser de {double}")
    public void oValorDoFreteDeveSerDe(double valorEsperado) {
        Assertions.assertEquals(valorEsperado, valorFrete);
    }

    @Then("Deve lançar uma exceção informando que o estado é inválido")
    public void deveLançarUmaExceçãoInformandoQueOEstadoÉInválido() {
        Assertions.assertNotNull(exception);
        Assertions.assertTrue(exception instanceof IllegalArgumentException);
        Assertions.assertEquals("Estado inválido", exception.getMessage());
    }
}
