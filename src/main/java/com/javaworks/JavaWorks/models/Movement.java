package com.javaworks.JavaWorks.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private Integer quantity;
    private String movementType;

    @ManyToOne
    private Product product;

}
