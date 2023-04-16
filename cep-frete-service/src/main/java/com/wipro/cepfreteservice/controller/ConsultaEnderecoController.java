package com.wipro.cepfreteservice.controller;


import com.wipro.cepfreteservice.model.Endereco;
import com.wipro.cepfreteservice.service.FreteService;
import com.wipro.cepfreteservice.service.ViaCepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/consulta-endereco")
public class ConsultaEnderecoController {
    private final ViaCepService viaCepService;
    private final FreteService freteService;

    public ConsultaEnderecoController(ViaCepService viaCepService, FreteService freteService) {
        this.viaCepService = viaCepService;
        this.freteService = freteService;
    }

    @PostMapping("/{cep}")
    public ResponseEntity<Endereco> consultaEndereco(@PathVariable String cep) {
        Endereco endereco = viaCepService.buscaEnderecoPorCep(cep);
        if (endereco != null) {
            endereco.setFrete(freteService.calculaFrete(endereco.getEstado()));
            return ResponseEntity.ok(endereco);
        } else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}