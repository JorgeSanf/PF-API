package com.pf.api;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends CosmosRepository<Doc, String> {
    Iterable<Doc> findByTema(String tema);

    long countByAutor(String autor);

    // Doc findOne(String titulo, String autor);
}
