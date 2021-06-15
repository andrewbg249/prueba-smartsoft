package com.smartsoft.pruebasmartsoft.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartsoft.pruebasmartsoft.documents.Bill;

@Repository
public interface BillRepository extends MongoRepository<Bill, Serializable>{

}
