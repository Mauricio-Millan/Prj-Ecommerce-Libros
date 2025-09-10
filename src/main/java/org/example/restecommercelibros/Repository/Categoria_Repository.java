package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.Categoria_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Categoria_Repository extends JpaRepository<Categoria_Entity, Long> {
    List<Categoria_Entity> findAll();
    Optional<Categoria_Entity> findById(int id);
}
