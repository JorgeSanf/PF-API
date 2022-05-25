
package com.pf.api;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends CosmosRepository<Mensaje, String> {

}