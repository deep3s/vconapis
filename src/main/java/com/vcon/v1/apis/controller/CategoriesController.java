package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.entity.Category;
import com.vcon.v1.apis.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoryService;

    @GetMapping("")
    public List<Category> get() { return categoryService.getAllCategories();};


    @GetMapping("/{id}")
    public Optional<Category> get(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }


    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Category categories) {
        try {
            categoryService.createCategory(categories);  // Call the service layer to save the salon
            return ResponseEntity.status(HttpStatus.CREATED).body("Categories created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating salon: " + e.getMessage());
        }
    }

    @PutMapping("")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Category categories) {
        try {
            categoryService.createCategory(categories);  // Call the service layer to save the salon
            return ResponseEntity.status(HttpStatus.CREATED).body("Categories created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating salon: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

}
