package com.smartsoft.pruebasmartsoft.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartsoft.pruebasmartsoft.documents.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Serializable>{

}
