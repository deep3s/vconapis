package com.vcon.v1.apis.dao;

import com.vcon.v1.apis.model.Categories;

import java.util.List;

public interface CategoriesServiceDao {
    List<Categories> get();
    Categories get(int id);
    void save (Categories categories);
    void delete(int id);
}
