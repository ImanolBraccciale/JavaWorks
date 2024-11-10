package com.javaworks.JavaWorks.repository;

import com.javaworks.JavaWorks.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
