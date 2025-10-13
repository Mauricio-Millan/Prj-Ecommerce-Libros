package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.JWT.Auth_Response;
import org.example.restecommercelibros.JWT.Login_Request;
import org.example.restecommercelibros.JWT.Register_Request;
import org.example.restecommercelibros.Model.Usuario_Entity;

import java.util.List;
import java.util.Optional;

public interface Usuario_Service {
    List<Usuario_Entity> findAll();
    Optional<Usuario_Entity> findById(Long id);

    // Añadiendo métodos para operaciones CRUD
    Auth_Response register(Register_Request request);
    void deleteById(Long id);
    Usuario_Entity update(Long id, Usuario_Entity usuario);

    //Metodos especificos
    Auth_Response Login(Login_Request request);
}
