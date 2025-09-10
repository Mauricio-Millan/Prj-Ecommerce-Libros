package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.LibroAutor_Entity;

import java.util.List;
import java.util.Optional;

public interface LibroAutor_Service {
    List<LibroAutor_Entity> findAll();
    Optional<LibroAutor_Entity> findById(Long id);

    String deleteById(Long id);
    LibroAutor_Entity save(LibroAutor_Entity libroAutor);
    LibroAutor_Entity update(Long id, LibroAutor_Entity libroAutor);
}
