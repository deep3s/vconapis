package com.vcon.v1.apis.serviceImpl;

import com.vcon.v1.apis.daoImpl.SalonDetailsRepository;
import com.vcon.v1.apis.model.SalonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonDetailsServiceImpl {

    @Autowired
    private SalonDetailsRepository salonDetailsRepository;

    // Get a user by ID
    public Optional<SalonDetails> getSalonDetailsById(String id) {
        return salonDetailsRepository.findById(id);
    }

    public List<SalonDetails> getAllSalons() {
        return salonDetailsRepository.findAll();
    }

}
