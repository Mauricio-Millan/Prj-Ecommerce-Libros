package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Categoria_Entity;

import java.util.List;
import java.util.Optional;

public interface Categoria_Service {
    List<Categoria_Entity> findAll();
    Optional<Categoria_Entity> findById(Long id);

    // Añadiendo métodos para operaciones CRUD
    Categoria_Entity save(Categoria_Entity categoria);
    void deleteById(Long id);
    Categoria_Entity update(Long id, Categoria_Entity categoria);
}
