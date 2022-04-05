package com.pf.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/api/id/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Optional<Doc> getDocById(@PathVariable String id) throws Exception {
        return docService.findById(id);
    }

    // @GetMapping("/api/temas")
    @GetMapping(value = "/api/temas", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<String> getTemas() {
        return docService.findTemas();
    }

}

/*
 * @GetMapping("/api/doc/{id}")
 * public Doc getDocById(@PathVariable long id) throws Exception {
 * return docService.findById(id);
 * }
 */
