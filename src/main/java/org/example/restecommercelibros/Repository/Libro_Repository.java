package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.Libro_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface Libro_Repository extends JpaRepository<Libro_Entity, Long> {
    List<Libro_Entity> findAll();
    Optional<Libro_Entity> findById(int id);

    // Libro_Repository.java
//    @Modifying
//    @Query("UPDATE Libro_Entity l SET l.nombre = :nombre, l.idioma_original = :idioma_original WHERE l.id = :id")
//    int updateLibro(int id, String nombre, String idioma_original);
}
