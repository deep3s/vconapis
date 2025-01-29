package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.model.SalonDetails;
import com.vcon.v1.apis.serviceImpl.SalonDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salonDetails")
public class SalonDetailsController {

    @Autowired
    private SalonDetailsServiceImpl salonDetailsService;


    // Get user by ID
    @GetMapping("/{id}")
    public Optional<SalonDetails> getSalonDetailsById(@PathVariable String id) {return salonDetailsService.getSalonDetailsById(id);
    }

    @GetMapping
    public List<SalonDetails> getAllSalons() {
        return salonDetailsService.getAllSalons();
    }


}