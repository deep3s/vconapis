package com.vcon.v1.apis.daoImpl;

import com.vcon.v1.apis.model.SalonDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonDetailsRepository extends MongoRepository<SalonDetails, String> {
// You can define custom queries here if necessary
}