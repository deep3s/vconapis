package com.vcon.v1.apis.service;

import com.vcon.v1.apis.model.Services;

import java.util.List;

public interface ServicesService {
    List<Services> get();
    Services get(int id);
    void save (Services services);
    void delete(int id);
}
