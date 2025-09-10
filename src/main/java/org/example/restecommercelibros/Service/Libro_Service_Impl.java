package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Libro_Entity;
import org.example.restecommercelibros.Repository.Libro_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Libro_Service_Impl implements Libro_Service {
@Autowired
    private Libro_Repository libro_repo;

    @Override
    public List<Libro_Entity> findAll() {
        // (List<Libro_Entity) lo coloca el autocompletado falta comprobar
        return (List<Libro_Entity>) libro_repo.findAll();
    }
    @Override
    public Optional<Libro_Entity> findById(Long id){
        return libro_repo.findById(id);
    }

    @Override
    public Libro_Entity save(Libro_Entity libro) {
        return libro_repo.save(libro);
    }
    @Override
    public void deleteById(Long id) {
        libro_repo.deleteById(id);
    }
    // Libro_Service_Impl.java
    @Override
    public Libro_Entity update(Long id, Libro_Entity libro) {
        Optional<Libro_Entity> libroExistente = libro_repo.findById(id);

        if (libroExistente.isPresent()) {
            Libro_Entity libroActualizado = libroExistente.get();
            libroActualizado.setNombre(libro.getNombre());
            libroActualizado.setIdioma_original(libro.getIdioma_original());

            return libro_repo.save(libroActualizado);
        }
        return null; // O lanzar excepción si el libro no existe
    }

}
