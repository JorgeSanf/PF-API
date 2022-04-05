package com.pf.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class DocService {
    private DocRepository docRepository;

    public DocService(DocRepository docRepository) {
        this.docRepository = docRepository;
    }

    List<Doc> findByTema(String tema) {
        List<Doc> lista = new ArrayList<Doc>();
        Iterable<Doc> it = docRepository.findByTema(tema);
        for (Doc doc : it) {
            lista.add(doc);
        }
        return lista;
    };

    long countByAutor(String autor) {
        return docRepository.countByAutor(autor);
    }

    public List<Doc> findAll() {
        List<Doc> lista = new ArrayList<Doc>();
        Iterable<Doc> it = docRepository.findAll();
        for (Doc doc : it) {
            lista.add(doc);
        }
        return lista;
    }

    public Optional<Doc> findById(String id) {
        return docRepository.findById(id);
    }

    public List<String> findTemas() {
        List<String> lista = new ArrayList<String>();
        Iterable<Doc> it = docRepository.findAll();

        for (Doc doc : it) {

            lista.add(doc.getTema());

            boolean repetido = false;
            for (String tema : lista) {
                if (doc.getTema().equalsIgnoreCase(tema)) {
                    repetido = true;
                }
            }

            if (!repetido) {
                lista.add(doc.getTema());
            }
        }
        return lista;
    }

}

/*
 * Doc findOne(String titulo, String autor) {
 * return docRepository.findOne(titulo, autor);
 * }
 */