package com.javaworks.JavaWorks.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String Contact;

    @OneToMany(mappedBy = "supplier")
    private List<Product>  product;
}
