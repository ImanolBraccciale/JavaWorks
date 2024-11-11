package com.javaworks.JavaWorks.repository;

import com.javaworks.JavaWorks.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
