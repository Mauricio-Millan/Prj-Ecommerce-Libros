package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.Venta_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Venta_Repository extends JpaRepository<Venta_Entity, Long> {
    List<Venta_Entity> findAll();
    Optional<Venta_Entity> findById(int id);
}
