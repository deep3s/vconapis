package com.vcon.v1.apis.service;

import com.vcon.v1.apis.entity.Business;
import java.util.List;
import java.util.Optional;

public interface BusinessService {
    List<Business> getAllBusinesses();
    Optional<Business> getBusinessById(Long id);
    Business createBusiness(Business business);
    Business updateBusiness(Long id, Business business);
    void deleteBusiness(Long id);
    List<Business> getBusinessesByOwnerId(Long ownerId);
}