package com.pf.api;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Container(containerName = "docus")
public class Doc {

    @Id
    private String id;
    @PartitionKey
    private String tema;

    private String titulo;
    private String autor;
    private String texto;

    public Doc() {
    }

    public Doc(String id, String tema, String titulo, String autor, String texto) {
        this.id = id;
        this.tema = tema;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
    }

    public Doc(String tema, String titulo, String autor, String texto) {
        this.tema = tema;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", titulo, tema, autor);
    }
}
