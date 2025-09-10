package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Editorial_Entity;
import org.example.restecommercelibros.Repository.Editorial_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Editorial_Service_Impl implements Editorial_Service {

    @Autowired
    private Editorial_Repository editorial_repo;

    @Override
    public List<Editorial_Entity> findAll() {
        return (List<Editorial_Entity>) editorial_repo.findAll();
    }

    @Override
    public Optional<Editorial_Entity> findById(Long id){
        return editorial_repo.findById(id);
    }

    @Override
    public Editorial_Entity save(Editorial_Entity editorial) {
        return editorial_repo.save(editorial);
    }

    @Override
    public void deleteById(Long id) {
        editorial_repo.deleteById(id);
    }

    @Override
    @Transactional
    public Editorial_Entity update(Long id, Editorial_Entity editorial) {
        Optional<Editorial_Entity> editorialExistente = editorial_repo.findById(id);

        if (editorialExistente.isPresent()) {
            Editorial_Entity editorialActualizada = editorialExistente.get();
            editorialActualizada.setNombre(editorial.getNombre());

            return editorial_repo.save(editorialActualizada);
        }
        return null; // O lanzar excepción si la editorial no existe
    }
}
