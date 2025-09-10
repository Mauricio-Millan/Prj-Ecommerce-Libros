package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.DetalleVenta_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetalleVenta_Repository extends JpaRepository<DetalleVenta_Entity, Long> {
    List<DetalleVenta_Entity> findAll();
    Optional<DetalleVenta_Entity> findById(int id);
}
