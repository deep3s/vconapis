package com.vcon.v1.apis.serviceImpl;

import com.vcon.v1.apis.dao.CategoriesServiceDao;
import com.vcon.v1.apis.model.Categories;
import com.vcon.v1.apis.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoriesService {
    @Autowired
    CategoriesServiceDao categoriesServiceDao;

    @Transactional
    @Override
    public List<Categories> get() {
        return categoriesServiceDao.get();
    }

    @Transactional
    @Override
    public Categories get(int id) {
        return categoriesServiceDao.get(id);
    }

    @Transactional
    @Override
    public void save(Categories categories){
        categoriesServiceDao.save(categories);
    }

    @Transactional
    @Override
    public void delete(int id) {
        categoriesServiceDao.delete(id);
    }
}


