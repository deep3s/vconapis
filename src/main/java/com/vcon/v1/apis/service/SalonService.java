package com.vcon.v1.apis.service;

import com.vcon.v1.apis.model.Salon;

import java.util.List;

public interface SalonService {
    List<Salon> get();
    Salon get(int id);
    void save (Salon salon);
    void delete(int id);
}
