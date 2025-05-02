package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.dto.ApiResponse;
import com.vcon.v1.apis.entity.Location;
import com.vcon.v1.apis.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vcon.v1.apis.constant.MessageConstant;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Location>>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return ResponseEntity.ok(ApiResponse.success(MessageConstant.LOCATIONS_RETRIEVED_SUCCESSFULLY, locations));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Location>> getLocationById(@PathVariable Long id) {
        Optional<Location> location = locationService.getLocationById(id);
        if (location.isPresent()) {
            return ResponseEntity.ok(ApiResponse.success(MessageConstant.LOCATION_RETRIEVED_SUCCESSFULLY, location.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error(MessageConstant.LOCATION_NOT_FOUND));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Location>> createLocation(@RequestBody Location location) {
        Location createdLocation = locationService.createLocation(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(MessageConstant.LOCATION_CREATED_SUCCESSFULLY, createdLocation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Location>> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        Location updatedLocation = locationService.updateLocation(id, location);
        if (updatedLocation != null) {
            return ResponseEntity.ok(ApiResponse.success(MessageConstant.LOCATION_UPDATED_SUCCESSFULLY, updatedLocation));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error(MessageConstant.LOCATION_NOT_FOUND));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.ok(ApiResponse.success(MessageConstant.LOCATION_DELETED_SUCCESSFULLY, null));
    }

    @GetMapping("/business/{businessId}")
    public ResponseEntity<ApiResponse<List<Location>>> getLocationsByBusinessId(@PathVariable Long businessId) {
        List<Location> locations = locationService.getLocationsByBusinessId(businessId);
        return ResponseEntity.ok(ApiResponse.success(MessageConstant.LOCATIONS_FOR_BUSINESS_RETRIEVED_SUCCESSFULLY, locations));
    }
}