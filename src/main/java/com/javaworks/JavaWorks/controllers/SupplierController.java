package com.javaworks.JavaWorks.controllers;

import com.javaworks.JavaWorks.models.Supplier;
import com.javaworks.JavaWorks.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @PostMapping
    public Supplier postSupplier(@RequestBody Supplier supplier) {
        return supplierService.addSupplier(supplier);
    }


}
