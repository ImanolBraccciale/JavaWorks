package com.javaworks.JavaWorks.controllers;

import com.javaworks.JavaWorks.models.Movement;
import com.javaworks.JavaWorks.repository.MovementRepository;
import com.javaworks.JavaWorks.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    private MovementService movementService;

    // Obtener todos los movimientos
    @GetMapping
    public List<Movement> getAllMovements() {
        return movementService.getAllMovements();
    }

    // Crear un nuevo movimiento
    @PostMapping
    public ResponseEntity<Movement> addMovement(@RequestBody Movement movement) {
        Movement newMovement = movementService.addMovement(movement);
        return ResponseEntity.status(201).body(newMovement);
    }
}