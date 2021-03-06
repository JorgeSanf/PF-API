package com.pf.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class DocService {
    private DocRepository docRepository;
    private MensajeRepository msgRepository;

    public DocService(DocRepository docRepository, MensajeRepository msgRepository) {
        this.docRepository = docRepository;
        this.msgRepository = msgRepository;
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

    public List<Mensaje> findAllM() {
        List<Mensaje> lista = new ArrayList<Mensaje>();
        Iterable<Mensaje> it = msgRepository.findAll();
        for (Mensaje msg : it) {
            lista.add(msg);
        }
        return lista;
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

    public List<Doc> findByAutor(String autor) {
        return docRepository.findByAutor(autor);
    }

    public List<String> findTemas() {
        List<String> lista = new ArrayList<String>();

        Iterable<Doc> it = docRepository.findAll();

        for (Doc doc : it) {

            boolean repetido = false;

            for (String tema : lista) {
                if (doc.getTema().contains(tema)) {
                    repetido = true;
                }
            }

            if (!repetido) {
                lista.add(doc.getTema());
            }
        }

        /*
         * List<Object> temasObj = docRepository.findTemas();
         * for (Object temaObj : temasObj) {
         * lista.add(temaObj.tema.value);
         * }
         */

        return lista;
    }

    public Doc save(Doc doc) {

        /*
         * if (doc.getId() == null) {
         * int random = (int) (Math.random() * 1000);
         * String id = String.valueOf(random);
         * doc.setId(id);
         * }
         */
        docRepository.save(doc);
        return doc;
    }

    public String delete(String id) {

        Optional<Doc> doc = docRepository.findById(id);
        if (doc.isPresent()) {
            Doc docBorrar = doc.get();
            docRepository.delete(docBorrar);
            return "Documento borrado";
        } else {
            return "Documento no encontrado";
        }
    }

}

/*
 * Doc findOne(String titulo, String autor) {
 * return docRepository.findOne(titulo, autor);
 * }
 */