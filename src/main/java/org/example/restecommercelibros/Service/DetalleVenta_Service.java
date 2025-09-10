package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.DetalleVenta_Entity;

import java.util.List;
import java.util.Optional;

public interface DetalleVenta_Service {
    List<DetalleVenta_Entity> findAll();
    Optional<DetalleVenta_Entity> findById(Long id);
}
