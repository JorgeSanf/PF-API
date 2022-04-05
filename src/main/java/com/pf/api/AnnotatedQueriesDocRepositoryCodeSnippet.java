package com.pf.api;

import java.util.List;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;

import org.springframework.data.repository.query.Param;

public interface AnnotatedQueriesDocRepositoryCodeSnippet extends CosmosRepository<Doc, String> {
    @Query("select * from c where c.autor = @autor and c.tema = @tema")
    List<Doc> getDocByAutorAndTema(@Param("autor") String firstName, @Param("autor") String lastName);

    @Query("select value count(1) from c where c.tema = @tema")
    long getNumberByTema(@Param("tema") String tema);

}

/*
 * @Query("select * from c offset @offset limit @limit")
 * List<Doc> getUsersWithOffsetLimit(@Param("offset") int
 * offset, @Param("limit") int limit);
 */

/*
 * @Query("select tema from c")
 * Iterable<Doc> getTemas();
 */
// He metido Iterable porque lo he hecho con otros, pero suena mejor List
// ¿Cómo hacer esto?