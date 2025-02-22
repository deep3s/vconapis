package com.vcon.v1.apis.daoImpl;

import com.vcon.v1.apis.model.BusinessLocationDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessLocationRepository extends MongoRepository<BusinessLocationDetails, String> {
// You can define custom queries here if necessary
}