package com.vcon.v1.apis.service;

import com.vcon.v1.apis.entity.CategoryEntity;
import com.vcon.v1.apis.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<CategoryEntity> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public CategoryEntity createCategory(CategoryEntity CategoryEntity) {
        return categoryRepository.save(CategoryEntity);
    }

    public CategoryEntity updateCategory(Long id, CategoryEntity categoryDetails) {
        return categoryRepository.findById(id).map(CategoryEntity -> {
            CategoryEntity.setName(categoryDetails.getName());
            CategoryEntity.setDescription(categoryDetails.getDescription());
            return categoryRepository.save(CategoryEntity);
        }).orElseThrow(() -> new RuntimeException("CategoryEntity not found"));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

