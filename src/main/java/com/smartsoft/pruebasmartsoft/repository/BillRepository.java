package com.smartsoft.pruebasmartsoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartsoft.pruebasmartsoft.models.Bill;

@Repository
public interface BillRepository extends MongoRepository<Bill, String>{

}
