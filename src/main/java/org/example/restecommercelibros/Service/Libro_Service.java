package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Libro_Entity;

import java.util.List;
import java.util.Optional;

public interface Libro_Service {
List<Libro_Entity> findAll();
Optional<Libro_Entity> findById(Long id);

Libro_Entity save(Libro_Entity libro);
void deleteById(Long id);
// Libro_Service.java
Libro_Entity update(Long id, Libro_Entity libro);
}
