package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.LibroCategoria_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroCategoria_Repository extends JpaRepository<LibroCategoria_Entity, Long> {
    List<LibroCategoria_Entity> findAll();
    Optional<LibroCategoria_Entity> findById(int id);
}
