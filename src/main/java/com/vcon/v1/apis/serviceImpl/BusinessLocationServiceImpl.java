package com.vcon.v1.apis.serviceImpl;

import com.vcon.v1.apis.daoImpl.BusinessLocationRepository;
import com.vcon.v1.apis.model.BusinessLocationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessLocationServiceImpl {

    @Autowired
    private BusinessLocationRepository businessLocationRepository;

    // Get a Business Details by ID
    public Optional<BusinessLocationDetails> getBusinessLocationDetailsById(String id) {
        return businessLocationRepository.findById(id);
    }
    public List<BusinessLocationDetails> getAllBusinessLocations() {
        return businessLocationRepository.findAll();
    }

    // Create a new business
    public BusinessLocationDetails createBusinessLocation(BusinessLocationDetails business) {
        return businessLocationRepository.save(business);
    }

    // Update an existing business
    public BusinessLocationDetails updateBusinessLocation(String id, BusinessLocationDetails business) {
        if (businessLocationRepository.existsById(id)) {
            business.setId(id);
            return businessLocationRepository.save(business);
        }
        return null;
    }

    // Delete a business by ID
    public boolean deleteBusinessLocation(String id) {
        if (businessLocationRepository.existsById(id)) {
            businessLocationRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
