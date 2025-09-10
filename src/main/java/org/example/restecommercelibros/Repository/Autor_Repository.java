package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.Autor_Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Autor_Repository extends JpaRepository<Autor_Entity, Long> {
    List<Autor_Entity> findAll();
    Optional<Autor_Entity> findById(int id);


}
