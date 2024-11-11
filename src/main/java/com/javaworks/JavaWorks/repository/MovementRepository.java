package com.javaworks.JavaWorks.repository;

import com.javaworks.JavaWorks.models.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository  extends JpaRepository<Movement, Long> {
}
