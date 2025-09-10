package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Autor_Entity;
import org.example.restecommercelibros.Repository.Autor_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Autor_Service_Impl implements Autor_Service {
    @Autowired
    private Autor_Repository autor_repo;

    @Override
    public List<Autor_Entity> findAll() {
        return (List<Autor_Entity>) autor_repo.findAll();
    }

    @Override
    public Optional<Autor_Entity> findById(Long id){
        return autor_repo.findById(id);
    }

    @Override
    public Autor_Entity save(Autor_Entity autor) {
        return autor_repo.save(autor);
    }

    @Override
    public void deleteById(Long id) {
        autor_repo.deleteById(id);
    }

    @Override
    public Autor_Entity update(Long id, Autor_Entity autor) {
        Optional<Autor_Entity> autorExistente = autor_repo.findById(id);

        if (autorExistente.isPresent()) {
            Autor_Entity autorActualizado = autorExistente.get();
            autorActualizado.setNombre(autor.getNombre());
            autorActualizado.setNacionalidad(autor.getNacionalidad());

            return autor_repo.save(autorActualizado);
        }
        return null; // O lanzar excepción si el autor no existe
    }
}
