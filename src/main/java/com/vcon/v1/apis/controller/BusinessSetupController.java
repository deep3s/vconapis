package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.model.BusinessDetails;
import com.vcon.v1.apis.model.SalonDetails;
import com.vcon.v1.apis.serviceImpl.BusinessSetupServiceImpl;
import com.vcon.v1.apis.serviceImpl.SalonDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/businessSetup")
public class BusinessSetupController {

    @Autowired
    private BusinessSetupServiceImpl businessSetupService;


    // Create a new BusinessDetails
    @PostMapping
    public ResponseEntity<BusinessDetails> createBusiness(@RequestBody BusinessDetails BusinessDetails) {
        BusinessDetails createdBusiness = businessSetupService.createBusiness(BusinessDetails);
        return new ResponseEntity<>(createdBusiness, HttpStatus.CREATED);
    }

    // Get all businesses
    @GetMapping
    public ResponseEntity<List<BusinessDetails>> getAllBusinesses() {
        List<BusinessDetails> businesses = businessSetupService.getAllBusinesses();
        return new ResponseEntity<>(businesses, HttpStatus.OK);
    }

    // Get a BusinessDetails by ID
    @GetMapping("/{id}")
    public ResponseEntity<BusinessDetails> getBusinessById(@PathVariable String id) {
        Optional<BusinessDetails> BusinessDetails = businessSetupService.getBusinessDetailsById(id);
        return BusinessDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a BusinessDetails by ID
    @PutMapping("/{id}")
    public ResponseEntity<BusinessDetails> updateBusiness(@PathVariable String id, @RequestBody BusinessDetails BusinessDetails) {
        BusinessDetails updatedBusiness = businessSetupService.updateBusiness(id, BusinessDetails);
        return updatedBusiness != null ? ResponseEntity.ok(updatedBusiness) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a BusinessDetails by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable String id) {
        return businessSetupService.deleteBusiness(id) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}