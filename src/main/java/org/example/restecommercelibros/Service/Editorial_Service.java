package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Editorial_Entity;

import java.util.List;
import java.util.Optional;

public interface Editorial_Service {
    List<Editorial_Entity> findAll();
    Optional<Editorial_Entity> findById(Long id);

    // Método save para crear
    Editorial_Entity save(Editorial_Entity editorial);

    // Método update modificado para seguir el mismo patrón que otras entidades
    Editorial_Entity update(Long id, Editorial_Entity editorial);

    // Método para eliminar
    void deleteById(Long id);
}
