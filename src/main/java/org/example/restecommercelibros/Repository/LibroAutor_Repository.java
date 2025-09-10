package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.LibroAutor_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroAutor_Repository extends JpaRepository<LibroAutor_Entity, Long> {
    List<LibroAutor_Entity> findAll();
    Optional<LibroAutor_Entity> findById(int id);
}
