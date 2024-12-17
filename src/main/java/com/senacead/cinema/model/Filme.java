package com.senacead.cinema.model;

import lombok.Data;

@Data
public class Filme {
    private Long id;
    private String titulo;
    private String sinopse;
    private String genero;
    private int anoLancamento;
}
