package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Autor_Entity;

import java.util.List;
import java.util.Optional;

public interface Autor_Service {
    List<Autor_Entity> findAll();
    Optional<Autor_Entity> findById(Long id);

    // Añadiendo métodos para operaciones CRUD
    Autor_Entity save(Autor_Entity autor);
    void deleteById(Long id);
    Autor_Entity update(Long id, Autor_Entity autor);
}
