package org.example.restecommercelibros.Service;

import lombok.RequiredArgsConstructor;
import org.example.restecommercelibros.JWT.Auth_Response;
import org.example.restecommercelibros.JWT.Jwt_Service;
import org.example.restecommercelibros.JWT.Login_Request;
import org.example.restecommercelibros.JWT.Register_Request;
import org.example.restecommercelibros.Model.Rol_Entity;
import org.example.restecommercelibros.Model.Usuario_Entity;
import org.example.restecommercelibros.Repository.Usuario_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Usuario_Service_Impl implements Usuario_Service {

    @Autowired
    private final Usuario_Repository usuario_repo;
    private final Jwt_Service jwt_serv;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public List<Usuario_Entity> findAll() {
        return (List<Usuario_Entity>) usuario_repo.findAll();
    }

    @Override
    public Optional<Usuario_Entity> findById(Long id){
        return usuario_repo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        usuario_repo.deleteById(id);
    }

    @Override
    public Usuario_Entity update(Long id, Usuario_Entity usuario) {
        Optional<Usuario_Entity> usuarioExistente = usuario_repo.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario_Entity usuarioActualizado = usuarioExistente.get();
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setClave(passwordEncoder.encode(usuario.getClave())); // ✅ ENCRIPTAR
            usuarioActualizado.setApellido(usuario.getApellido());
            usuarioActualizado.setEmail(usuario.getEmail());

            return usuario_repo.save(usuarioActualizado);
        }
        return null;
    }



    public Auth_Response Login(Login_Request request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getClave()));

        UserDetails user = usuario_repo.findByEmail(request.getEmail()).orElseThrow();
        String token = jwt_serv.getToken(user);
        return Auth_Response.builder().token(token).build();
    }
    Rol_Entity rol1 = new Rol_Entity(1, "USER");;
    public Auth_Response register(Register_Request request) {
        Usuario_Entity usuario = Usuario_Entity.builder()
                .nombre(request.getNombre())
                .clave(passwordEncoder.encode(request.getClave()))
                .apellido(request.getApellido())
                .email(request.getEmail())
                .direccion(request.getDireccion())
                .telefono(request.getTelefono())
                .idRol(rol1)
                .build();
        usuario_repo.save(usuario);
        return Auth_Response.builder().token(jwt_serv.getToken(usuario)).build();
    }
}
