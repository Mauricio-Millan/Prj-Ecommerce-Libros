package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.Edicion_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Edicion_Repository extends JpaRepository<Edicion_Entity, Long> {
    List<Edicion_Entity> findAll();

    Optional<Edicion_Entity> findById(int id);

    // En Edicion_Repository.java
    @Modifying
    @Transactional
    @Query("UPDATE Edicion_Entity e SET e.idioma = :idioma, e.encuadernacion = :encuadernacion, " +
            "e.dimensiones = :dimensiones, e.fecha_publicacion = :fechaPublicacion, " +
            "e.precio_venta = :precioVenta, e.resumen = :resumen, e.traductor = :traductor, " +
            "e.libro.id = :libroId, e.editorial.id = :editorialId WHERE e.id = :id")
    Optional<Edicion_Entity> updateEdicion(@Param("id") int id,
                      @Param("idioma") String idioma,
                      @Param("encuadernacion") String encuadernacion,
                      @Param("dimensiones") String dimensiones,
                      @Param("fechaPublicacion") Date fechaPublicacion,
                      @Param("precioVenta") BigDecimal precioVenta,
                      @Param("resumen") String resumen,
                      @Param("traductor") String traductor,
                      @Param("libroId") int libroId,
                      @Param("editorialId") int editorialId);
}
