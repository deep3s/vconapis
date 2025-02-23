package com.vcon.v1.apis.service;

import com.vcon.v1.apis.model.Categories;
import java.util.List;

public interface CategoriesService {
    List<Categories> get();
    Categories get(int id);
    void save (Categories categories);
    void delete(int id);
}
