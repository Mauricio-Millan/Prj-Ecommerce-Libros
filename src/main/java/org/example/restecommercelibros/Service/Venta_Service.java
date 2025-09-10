package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Venta_Entity;

import java.util.List;
import java.util.Optional;

public interface Venta_Service {
    List<Venta_Entity> findAll();
    Optional<Venta_Entity> findById(Long id);

    Venta_Entity save(Venta_Entity venta);
    void deleteById(Long id);
    Venta_Entity update(Long id, Venta_Entity venta);
}
