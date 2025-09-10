package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.Editorial_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Editorial_Repository extends JpaRepository<Editorial_Entity, Long> {
    List<Editorial_Entity> findAll();
    Optional<Editorial_Entity> findById(int id);

    @Modifying
    @Query("UPDATE Editorial_Entity e SET e.nombre = :#{ed.getnombre} WHERE e.id = :#{ed.getid}")
    int update(@Param("ed") Editorial_Entity editorial);
}
