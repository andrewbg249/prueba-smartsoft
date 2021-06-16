package com.smartsoft.pruebasmartsoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartsoft.pruebasmartsoft.models.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String>{

}
