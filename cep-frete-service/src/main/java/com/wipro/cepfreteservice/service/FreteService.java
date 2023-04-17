package com.wipro.cepfreteservice.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FreteService {

    public double calculaFrete(String estado) {

        final double freteSudeste = 7.85;
        final double freteCentroOeste = 12.50;
        final double freteNordeste = 15.98;
        final double freteSul = 17.30;
        final double freteNorte = 20.83;

        String[] estadosSudeste = {"SP", "RJ", "MG", "ES"};
        String[] estadosCentroOeste = {"MT", "MS", "GO", "DF"};
        String[] estadosNordeste = {"AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE"};
        String[] estadosSul = {"PR", "RS", "SC"};
        String[] estadosNorte = {"AC", "AP", "AM", "PA", "RO", "RR", "TO"};

        if (Arrays.asList(estadosSudeste).contains(estado)) {
            return freteSudeste;
        } else if (Arrays.asList(estadosCentroOeste).contains(estado)) {
            return freteCentroOeste;
        } else if (Arrays.asList(estadosNordeste).contains(estado)) {
            return freteNordeste;
        } else if (Arrays.asList(estadosSul).contains(estado)) {
            return freteSul;
        } else if (Arrays.asList(estadosNorte).contains(estado)) {
            return freteNorte;
        } else {
            throw new IllegalArgumentException("Estado inválido");
        }
    }
}