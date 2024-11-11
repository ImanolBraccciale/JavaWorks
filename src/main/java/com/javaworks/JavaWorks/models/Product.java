package com.javaworks.JavaWorks.models;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer quantity;


    @ManyToOne
    private Category category;

    @ManyToOne
    private Supplier supplier;

}
