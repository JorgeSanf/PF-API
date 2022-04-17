package com.pf.api;

import java.util.List;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface DocRepository extends CosmosRepository<Doc, String> {
    Iterable<Doc> findByTema(String tema);

    long countByAutor(String autor);

    @Query("select distinct c.tema from c")
    List<Object> findTemas();

    // Iterable<Doc> findTemas();

    // Doc findOne(String titulo, String autor);
}
