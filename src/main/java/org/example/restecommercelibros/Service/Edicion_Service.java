package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Edicion_Entity;

import java.util.List;
import java.util.Optional;

public interface Edicion_Service {
    List<Edicion_Entity> findAll();
    Optional<Edicion_Entity> findById(Long id);

    // Añadiendo los métodos CRUD estándar
    Edicion_Entity save(Edicion_Entity edicion);
    void deleteById(Long id);
    Edicion_Entity update(Long id, Edicion_Entity edicion);
}
