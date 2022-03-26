package com.pf.api;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/api")
    public List<Doc> getAllDocs() {
        return docService.findAll();
    }

    @GetMapping(value = "/api/tema/{tema}")
    public List<Doc> getByTema(@PathVariable String tema) {
        return docService.findByTema(tema);
    }

    @GetMapping("/api/id/{id}")
    public Optional<Doc> getDocById(@PathVariable String id) throws Exception {
        return docService.findById(id);
    }

}

/*
 * @GetMapping("/api/doc/{id}")
 * public Doc getDocById(@PathVariable long id) throws Exception {
 * return docService.findById(id);
 * }
 */
