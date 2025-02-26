package com.vcon.v1.apis.service;

import com.vcon.v1.apis.entity.Category;
import com.vcon.v1.apis.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    @Autowired
    private CategoryRepository categoryRepository;

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Create new category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get category by id
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Update category
    public Category updateCategory(Long id, Category categoryDetails) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            category.get().setName(categoryDetails.getName());
            category.get().setName(categoryDetails.getName());
            return categoryRepository.save(category.get());
        }
        return null;
    }

    // Delete category
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
