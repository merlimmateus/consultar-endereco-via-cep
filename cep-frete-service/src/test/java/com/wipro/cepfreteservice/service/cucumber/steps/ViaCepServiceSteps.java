package com.wipro.cepfreteservice.service.cucumber.steps;

import com.wipro.cepfreteservice.exception.CepNotFoundException;
import com.wipro.cepfreteservice.model.Endereco;
import com.wipro.cepfreteservice.service.ViaCepService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration
public class ViaCepServiceSteps {

    @Autowired
    private ViaCepService viaCepService;

    private String cep;
    private Endereco endereco;
    private Exception exception;

    @Given("Um CEP válido")
    public void umCepValido() {
        cep = "01001-000";
    }

    @Given("Um CEP inválido")
    public void umCepInvalido() {
        cep = "00000-000";
    }

    @Given("Uma URL inválida")
    public void umaUrlInvalida() {
        viaCepService.setViaCepUrl("http://nonexistent-domain.com/");
        System.out.println("URL inválida definida: " + viaCepService.getViaCepUrl());

    }

    @When("O usuário busca o endereço pelo CEP")
    public void oUsuarioBuscaOEnderecoPeloCep() {
        try {
            endereco = viaCepService.buscaEnderecoPorCep(cep);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("O endereço é retornado com sucesso")
    public void oEnderecoERetornadoComSucesso() {
        Assertions.assertNotNull(endereco, "Endereço não foi retornado");
    }

    @Then("Uma exceção é lançada informando que o CEP não foi encontrado")
    public void umaExcecaoELancadaInformandoQueOCepNaoFoiEncontrado() {
        Assertions.assertNotNull(exception, "Exceção não foi lançada");
        Assertions.assertTrue(exception instanceof CepNotFoundException, "Exceção não é do tipo esperado");
        Assertions.assertEquals("CEP não encontrado", exception.getMessage(), "Mensagem de erro não é a esperada");
    }

    @Then("uma exceção é lançada informando que ocorreu um erro na requisição")
    public void umaExcecaoELancadaInformandoQueOcorreuUmErroNaRequisicao() {
        Assertions.assertNotNull(exception, "Exceção não foi lançada");
        Assertions.assertTrue(exception instanceof RuntimeException, "Exceção não é do tipo esperado");
    }
}
