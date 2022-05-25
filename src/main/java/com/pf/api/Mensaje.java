package com.pf.api;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
@Container(containerName = "mensajes")
public class Mensaje {
    @Id
    @GeneratedValue
    private String id;
    private String title;
    private String body;
    private String author;
    private String postedAt;

    public Mensaje() {
    }

    public Mensaje(String id, String title, String author, String body, String postedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.body = body;
        this.postedAt = postedAt;
    }
}
