package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.LibroCategoria_Entity;

import java.util.List;
import java.util.Optional;

public interface LibroCategoria_Service {
    List<LibroCategoria_Entity> findAll();
    Optional<LibroCategoria_Entity> findById(Long id);
}
