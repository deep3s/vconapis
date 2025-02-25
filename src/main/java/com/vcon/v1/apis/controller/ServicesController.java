package com.vcon.v1.apis.controller;


import com.vcon.v1.apis.model.Services;
import com.vcon.v1.apis.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    ServicesService servicesService;

    @GetMapping("/")
    public List<Services> get() { return servicesService.get();};

    @GetMapping("/{id}")
    public Services get(@PathVariable int id){
        return servicesService.get(id);
    }


    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Services services) {
        try {
            servicesService.save(services);  // Call the service layer to save the salon
            return ResponseEntity.status(HttpStatus.CREATED).body("Services created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating salon: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        servicesService.delete(id);
    }
}
