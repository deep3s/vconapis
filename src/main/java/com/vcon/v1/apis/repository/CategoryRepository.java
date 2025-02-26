package com.vcon.v1.apis.repository;

import com.vcon.v1.apis.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
