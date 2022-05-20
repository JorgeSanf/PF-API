package com.pf.api;

import java.util.List;
import java.util.Optional;

import com.azure.core.annotation.Get;

//import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docus")
public class DocsController {
    private DocService docService;

    public DocsController(DocService docService) {
        this.docService = docService;
    }

    @GetMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Doc> getAllDocs() {
        return docService.findAll();
    }

    @GetMapping(value = "/api/tema/{tema}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Doc> getByTema(@PathVariable String tema) {
        return docService.findByTema(tema);
    }

    @GetMapping(value = "/api/autor/{autor}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Doc> getByAutor(@PathVariable String autor) {
        return docService.findByAutor(autor);
    }

    @GetMapping(value = "/api/id/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<Doc> getDocById(@PathVariable String id) throws Exception {
        return docService.findById(id);
    }

    // @GetMapping("/api/temas")
    @GetMapping(value = "/api/temas", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<String> getTemas() {
        return docService.findTemas();
    }

    @PostMapping(value = "/api/add")
    public String addDoc(@RequestBody Doc doc) {
        Doc returnedDoc = docService.save(doc);
        /*
         * if (returnedDoc.getId().isEmpty()) {
         * throw new ValidationException("Error adding Application to Cosmos DB.");
         * }
         * return new StatusMessage("200", "Application Added");
         */
        return "Documento añadido" + returnedDoc.getId();
    }

    @DeleteMapping("/api/delete/{id}")
    public String deleteDoc(@PathVariable String id) {

        String borrado = docService.delete(id);
        return borrado;
    }

}

/*
 * @GetMapping("/api/doc/{id}")
 * public Doc getDocById(@PathVariable long id) throws Exception {
 * return docService.findById(id);
 * }
 */
