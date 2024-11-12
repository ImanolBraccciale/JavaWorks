package com.javaworks.JavaWorks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("supplier")
    private List<Product>  product;
}
