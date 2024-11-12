package com.javaworks.JavaWorks.services;

import com.javaworks.JavaWorks.models.Category;
import com.javaworks.JavaWorks.models.Product;
import com.javaworks.JavaWorks.models.Supplier;
import com.javaworks.JavaWorks.repository.CategoryRepository;
import com.javaworks.JavaWorks.repository.ProductRepository;
import com.javaworks.JavaWorks.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SupplierRepository supplierRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        // Buscar la categoría y el proveedor por su ID
        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Supplier supplier = supplierRepository.findById(product.getSupplier().getId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        // Guardar el producto en la base de datos
        return productRepository.save(product);
    }



}
