package com.vcon.v1.apis.daoImpl;

import com.vcon.v1.apis.model.BusinessDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessSetupRepository extends MongoRepository<BusinessDetails, String> {
// You can define custom queries here if necessary
}