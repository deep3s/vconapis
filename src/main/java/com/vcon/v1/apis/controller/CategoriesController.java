package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.model.Categories;
import com.vcon.v1.apis.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoryService;

    @GetMapping("")
    public List<Categories> get() { return categoryService.get();};

    @GetMapping("/{id}")
    public Categories get(@PathVariable int id){
        return categoryService.get(id);
    }


    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Categories categories) {
        try {
            categoryService.save(categories);  // Call the service layer to save the salon
            return ResponseEntity.status(HttpStatus.CREATED).body("Categories created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating salon: " + e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }

}
