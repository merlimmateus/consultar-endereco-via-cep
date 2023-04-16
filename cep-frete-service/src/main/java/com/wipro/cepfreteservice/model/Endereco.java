package com.wipro.cepfreteservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @JsonProperty("cep")
    private String cep;
    @JsonProperty("logradouro")
    private String rua;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("localidade")
    private String cidade;
    @JsonProperty("uf")
    private String estado;
    private Double frete;
}