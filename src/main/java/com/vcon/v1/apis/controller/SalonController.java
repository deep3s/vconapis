package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.model.Salon;
import com.vcon.v1.apis.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("api")
public class SalonController {
    @Autowired
    SalonService salonService;

    @GetMapping("/salons")
    public List<Salon> get() {
        return salonService.get();
    };

    @GetMapping("/salons/{id}")
    public Salon get(@PathVariable int id){
        return salonService.get(id);
    }

    @PostMapping("/salons")
    public ResponseEntity<String> save(@RequestBody Salon salon){
        try {
            salonService.save(salon);  // Call the service layer to save the salon
            return ResponseEntity.status(HttpStatus.CREATED).body("Salon created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating salon: " + e.getMessage());
        }
    }

    @DeleteMapping("/salons/{id}")
    public void delete(@PathVariable int id){
        salonService.delete(id);
    }

    @GetMapping("/salons/location")
    public List<Salon> getSalonsByLocation(@RequestParam String address) {
        return salonService.getSalonsByLocation(address);
    }

    @PutMapping("/salons/{id}/imageUrls")
    public ResponseEntity<String> updateImageUrls(@PathVariable int id, @RequestParam String imageUrls) {
        try {
            salonService.updateImageUrls(id, imageUrls);
            return ResponseEntity.status(HttpStatus.OK).body("Image URLs updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating image URLs: " + e.getMessage());
        }
    }

}

