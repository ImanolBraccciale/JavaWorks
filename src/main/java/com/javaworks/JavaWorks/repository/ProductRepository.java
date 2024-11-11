package com.javaworks.JavaWorks.repository;

import com.javaworks.JavaWorks.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
