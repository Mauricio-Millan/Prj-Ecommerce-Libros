package org.example.restecommercelibros.Controller;

import lombok.RequiredArgsConstructor;
import org.example.restecommercelibros.JWT.Auth_Response;
import org.example.restecommercelibros.JWT.Login_Request;
import org.example.restecommercelibros.JWT.Register_Request;
import org.example.restecommercelibros.Service.Usuario_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class Auth_Controller {
    @Autowired
    private Usuario_Service usuario_serv;

    @PostMapping("/register")
    public ResponseEntity<Auth_Response> save(@RequestBody Register_Request usuario) {
        return ResponseEntity.ok(usuario_serv.register(usuario));
    }

        @PostMapping("/login")
    public ResponseEntity<Auth_Response> Login (@RequestBody Login_Request usuario)
    {
        return ResponseEntity.ok(usuario_serv.Login(usuario));
    }
}
