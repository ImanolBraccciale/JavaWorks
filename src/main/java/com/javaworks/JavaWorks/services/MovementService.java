package com.javaworks.JavaWorks.services;

import com.javaworks.JavaWorks.models.Movement;
import com.javaworks.JavaWorks.models.Product;
import com.javaworks.JavaWorks.repository.MovementRepository;
import com.javaworks.JavaWorks.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private ProductRepository productRepository;

    // Obtener todos los movimientos
    public List<Movement> getAllMovements() {
        return movementRepository.findAll();
    }

    // Crear un nuevo movimiento
    public Movement addMovement(Movement movement) {
        Product product = productRepository.findById(movement.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if ("Ingreso".equals(movement.getMovementType())) {
            product.setQuantity(product.getQuantity() + movement.getQuantity());
        }else if ("Egreso".equals(movement.getMovementType())) {
           if (product.getQuantity() < movement.getQuantity()) {
               throw new RuntimeException("El producto no puede ser negativo");
           }
            product.setQuantity(product.getQuantity() - movement.getQuantity());
        } else {
            throw new RuntimeException("Movimiento desconocido");
        }
        Movement savedMovement = movementRepository.save(movement);
        productRepository.save(product);

        return savedMovement;
    }
}
