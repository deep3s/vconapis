package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.model.Salon;
import com.vcon.v1.apis.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class SalonController {
    @Autowired
    SalonService salonService;

    @GetMapping("/salons")
    public List<Salon> get() {return salonService.get();};
}
