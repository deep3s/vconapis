package com.vcon.v1.apis.dao;

import com.vcon.v1.apis.model.Services;

import java.util.List;

public interface ServicesDao {
    List<Services> get();
    Services get(int id);
    void save (Services services);
    void delete(int id);
}
