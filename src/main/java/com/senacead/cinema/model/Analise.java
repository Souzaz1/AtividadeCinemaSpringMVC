package com.senacead.cinema.model;

import lombok.Data;

@Data
public class Analise {
    private Long id;
    private Filme filme;
    private String analise;
    private int nota;
}
