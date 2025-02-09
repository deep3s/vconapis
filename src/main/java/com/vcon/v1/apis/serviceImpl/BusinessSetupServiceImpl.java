package com.vcon.v1.apis.serviceImpl;

import com.vcon.v1.apis.daoImpl.BusinessSetupRepository;
import com.vcon.v1.apis.model.BusinessDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessSetupServiceImpl {

    @Autowired
    private BusinessSetupRepository businessSetupRepository;

    // Get a Business Details by ID
    public Optional<BusinessDetails> getBusinessDetailsById(String id) {
        return businessSetupRepository.findById(id);
    }
    public List<BusinessDetails> getAllBusinesses() {
        return businessSetupRepository.findAll();
    }

    // Create a new business
    public BusinessDetails createBusiness(BusinessDetails business) {
        return businessSetupRepository.save(business);
    }

    // Update an existing business
    public BusinessDetails updateBusiness(String id, BusinessDetails business) {
        if (businessSetupRepository.existsById(id)) {
            business.setId(id);
            return businessSetupRepository.save(business);
        }
        return null;
    }

    // Delete a business by ID
    public boolean deleteBusiness(String id) {
        if (businessSetupRepository.existsById(id)) {
            businessSetupRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
