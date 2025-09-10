package org.example.restecommercelibros.Repository;

import org.example.restecommercelibros.Model.Usuario_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Usuario_Repository extends JpaRepository<Usuario_Entity, Long> {
    List<Usuario_Entity> findAll();
    Optional<Usuario_Entity> findById(int id);

    @Query("select user from Usuario_Entity user where user.nombre =:nombre and user.clave =:clave")
    Optional<Usuario_Entity> Login(@Param("nombre") String nombre, @Param("clave") String clave);
}
