package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.LibroAutor_Entity;
import org.example.restecommercelibros.Repository.LibroAutor_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class LibroAutor_Service_Impl implements LibroAutor_Service {
    @Autowired
    private LibroAutor_Repository libroAutor_repo;

    @Override
    public List<LibroAutor_Entity> findAll() {
        return (List<LibroAutor_Entity>) libroAutor_repo.findAll();
    }

    @Override
    public Optional<LibroAutor_Entity> findById(Long id){
        return libroAutor_repo.findById(id);
    }

    @Override
    public LibroAutor_Entity save(LibroAutor_Entity LibroAutor){return libroAutor_repo.save(LibroAutor);}

    @Override
    public String deleteById(Long id) {
        libroAutor_repo.deleteById(id);
        return  "Eliminado correctamente";
    }

    @Override
    public LibroAutor_Entity update(Long id, LibroAutor_Entity libroAutor) {
        Optional<LibroAutor_Entity> libroAutorExistente = libroAutor_repo.findById(id);

        if (libroAutorExistente.isPresent()) {
            LibroAutor_Entity libroAutorActualizado = libroAutorExistente.get();
            libroAutorActualizado.setLibro(libroAutor.getLibro());
            libroAutorActualizado.setAutor(libroAutor.getAutor());
            libroAutorActualizado.setGrado(libroAutor.getGrado());

            return libroAutor_repo.save(libroAutorActualizado);
        }
        return null; // O lanzar excepción si el libro-autor no existe
    }
}
