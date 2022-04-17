package com.pf.api;

import java.io.Serializable;

import lombok.Data;

@Data
public class Entrada implements Serializable {
    String titulo;
    String contenido;

    public Entrada(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }
}
