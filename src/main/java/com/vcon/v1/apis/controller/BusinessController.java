package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.dto.ApiResponse;
import com.vcon.v1.apis.entity.Business;
import com.vcon.v1.apis.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Business>>> getAllBusinesses() {
        List<Business> businesses = businessService.getAllBusinesses();
        return ResponseEntity.ok(ApiResponse.success("Businesses retrieved successfully", businesses));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Business>> getBusinessById(@PathVariable Long id) {
        Optional<Business> business = businessService.getBusinessById(id);
        if (business.isPresent()) {
            return ResponseEntity.ok(ApiResponse.success("Business retrieved successfully", business.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Business not found"));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Business>> createBusiness(@RequestBody Business business) {
        Business createdBusiness = businessService.createBusiness(business);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Business created successfully", createdBusiness));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Business>> updateBusiness(@PathVariable Long id, @RequestBody Business business) {
        Business updatedBusiness = businessService.updateBusiness(id, business);
        if (updatedBusiness != null) {
            return ResponseEntity.ok(ApiResponse.success("Business updated successfully", updatedBusiness));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Business not found"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBusiness(@PathVariable Long id) {
        businessService.deleteBusiness(id);
        return ResponseEntity.ok(ApiResponse.success("Business deleted successfully", null));
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<ApiResponse<List<Business>>> getBusinessesByOwnerId(@PathVariable Long ownerId) {
        List<Business> businesses = businessService.getBusinessesByOwnerId(ownerId);
        return ResponseEntity.ok(ApiResponse.success("Businesses retrieved successfully by owner", businesses));
    }
}