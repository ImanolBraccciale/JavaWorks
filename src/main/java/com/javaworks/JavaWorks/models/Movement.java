package com.javaworks.JavaWorks.models;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Data
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
