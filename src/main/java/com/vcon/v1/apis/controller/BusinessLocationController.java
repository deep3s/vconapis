package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.model.BusinessLocationDetails;
import com.vcon.v1.apis.serviceImpl.BusinessLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/businessLocation")
public class BusinessLocationController {

    @Autowired
    private BusinessLocationServiceImpl businessLocationService;


    // Create a new BusinessLocationDetails
    @PostMapping
    public ResponseEntity<BusinessLocationDetails> createBusinessLocation(@RequestBody BusinessLocationDetails BusinessLocationDetails) {
        BusinessLocationDetails createdBusinessLocation = businessLocationService.createBusinessLocation(BusinessLocationDetails);
        return new ResponseEntity<>(createdBusinessLocation, HttpStatus.CREATED);
    }

    // Get all businesses
    @GetMapping
    public ResponseEntity<List<BusinessLocationDetails>> getAllBusinessLocations() {
        List<BusinessLocationDetails> businessLocations = businessLocationService.getAllBusinessLocations();
        return new ResponseEntity<>(businessLocations, HttpStatus.OK);
    }

    // Get a BusinessLocationDetails by ID
    @GetMapping("/{id}")
    public ResponseEntity<BusinessLocationDetails> getBusinessLocationById(@PathVariable String id) {
        Optional<BusinessLocationDetails> BusinessLocationDetails = businessLocationService.getBusinessLocationDetailsById(id);
        return BusinessLocationDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a BusinessLocationDetails by ID
    @PutMapping("/{id}")
    public ResponseEntity<BusinessLocationDetails> updateBusinessLocation(@PathVariable String id, @RequestBody BusinessLocationDetails BusinessLocationDetails) {
        BusinessLocationDetails updatedBusinessLocation = businessLocationService.updateBusinessLocation(id, BusinessLocationDetails);
        return updatedBusinessLocation != null ? ResponseEntity.ok(updatedBusinessLocation) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a BusinessLocationDetails by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusinessLocation(@PathVariable String id) {
        return businessLocationService.deleteBusinessLocation(id) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}