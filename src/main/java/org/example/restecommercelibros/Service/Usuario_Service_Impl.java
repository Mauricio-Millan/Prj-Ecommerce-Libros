package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Usuario_Entity;
import org.example.restecommercelibros.Repository.Usuario_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Usuario_Service_Impl implements Usuario_Service {
    @Autowired
    private Usuario_Repository usuario_repo;

    @Override
    public List<Usuario_Entity> findAll() {
        return (List<Usuario_Entity>) usuario_repo.findAll();
    }

    @Override
    public Optional<Usuario_Entity> findById(Long id){
        return usuario_repo.findById(id);
    }

    @Override
    public Usuario_Entity save(Usuario_Entity usuario) {
        return usuario_repo.save(usuario);
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
            usuarioActualizado.setClave(usuario.getClave());

            return usuario_repo.save(usuarioActualizado);
        }
        return null; // O lanzar excepción si el usuario no existe
    }
    @Override
    public  Optional<Usuario_Entity> Login(Usuario_Entity usuario) {
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getClave());
        return usuario_repo.Login(usuario.getNombre(),usuario.getClave());

    }
}
