package com.javaworks.JavaWorks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("product")
    private Category category;

    @ManyToOne
    @JsonIgnoreProperties("product")
    private Supplier supplier;

}
