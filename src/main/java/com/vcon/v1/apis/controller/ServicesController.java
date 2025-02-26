package com.vcon.v1.apis.controller;


import com.vcon.v1.apis.entity.Service;
import com.vcon.v1.apis.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    ServicesService servicesService;

    @GetMapping("")
    public List<Service> get() { return servicesService.getAllServices();};

    @GetMapping("/{id}")
    public Optional<Service> get(@PathVariable Long id){
        return servicesService.getServiceById(id);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Service service, @RequestParam Long categoryId) {
        try {
            servicesService.createService(service, categoryId);  // Call the service layer to save the salon
            return ResponseEntity.status(HttpStatus.CREATED).body("Services created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating salon: " + e.getMessage());
        }
    }

    @PutMapping("")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Service service) {
        try {
            servicesService.updateService(id, service);  // Call the service layer to save the salon
            return ResponseEntity.status(HttpStatus.CREATED).body("Services created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating salon: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        servicesService.deleteService(id);
    }
}
