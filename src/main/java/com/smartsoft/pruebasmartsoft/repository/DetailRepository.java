package com.smartsoft.pruebasmartsoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartsoft.pruebasmartsoft.models.Detail;

@Repository
public interface DetailRepository extends MongoRepository<Detail, String>{
	
}
