package com.wipro.cepfreteservice.service;

import com.wipro.cepfreteservice.model.Endereco;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        return restTemplate.getForObject(url, Endereco.class);
    }
}