package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Usuario_Entity;

import java.util.List;
import java.util.Optional;

public interface Usuario_Service {
    List<Usuario_Entity> findAll();
    Optional<Usuario_Entity> findById(Long id);

    // Añadiendo métodos para operaciones CRUD
    Usuario_Entity save(Usuario_Entity usuario);
    void deleteById(Long id);
    Usuario_Entity update(Long id, Usuario_Entity usuario);

    //Metodos especificos
    Optional<Usuario_Entity> Login(Usuario_Entity usuario);
}
