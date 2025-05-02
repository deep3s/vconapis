package com.vcon.v1.apis.serviceImpl;

import com.vcon.v1.apis.entity.Business;
import com.vcon.v1.apis.repository.BusinessRepository;
import com.vcon.v1.apis.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceImpl implements BusinessService { // Changed to implement the interface

    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override // Added these @Override annotations
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Optional<Business> getBusinessById(Long id) {
        return businessRepository.findById(id);
    }

    @Override
    public Business createBusiness(Business business) {
        return businessRepository.save(business);
    }

    @Override
    public Business updateBusiness(Long id, Business business) {
        Optional<Business> existingBusiness = businessRepository.findById(id);
        if (existingBusiness.isPresent()) {
            Business updatedBusiness = existingBusiness.get();
            updatedBusiness.setName(business.getName());
            //updatedBusiness.setDescription(business.getDescription());
            updatedBusiness.setOwnerId(business.getOwnerId());
            return businessRepository.save(updatedBusiness);
        }
        return null;
    }

    @Override
    public void deleteBusiness(Long id) {
        businessRepository.deleteById(id);
    }

    @Override
    public List<Business> getBusinessesByOwnerId(Long ownerId) {
        return businessRepository.findByOwnerId(ownerId);
    }
}