package org.example.restecommercelibros.Controller;

import org.example.restecommercelibros.JWT.Auth_Response;
import org.example.restecommercelibros.JWT.Login_Request;
import org.example.restecommercelibros.JWT.Register_Request;
import org.example.restecommercelibros.Model.Usuario_Entity;
import org.example.restecommercelibros.Service.Usuario_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class Usuario_Controller {
    @Autowired
    private Usuario_Service usuario_serv;

    @GetMapping
    public List<Usuario_Entity> findAll() {
        return usuario_serv.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Usuario_Entity> findById(@PathVariable Long id){
        return usuario_serv.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        usuario_serv.deleteById(id);
    }

    @PutMapping("/{id}")
    public Usuario_Entity update(@PathVariable Long id, @RequestBody Usuario_Entity usuario) {
        return usuario_serv.update(id, usuario);
    }

}
