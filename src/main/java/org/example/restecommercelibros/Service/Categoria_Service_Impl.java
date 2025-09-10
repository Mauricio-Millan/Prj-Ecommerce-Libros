package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Categoria_Entity;
import org.example.restecommercelibros.Repository.Categoria_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Categoria_Service_Impl implements Categoria_Service {
    @Autowired
    private Categoria_Repository categoria_repo;

    @Override
    public List<Categoria_Entity> findAll() {
        return (List<Categoria_Entity>) categoria_repo.findAll();
    }

    @Override
    public Optional<Categoria_Entity> findById(Long id){
        return categoria_repo.findById(id);
    }

    @Override
    public Categoria_Entity save(Categoria_Entity categoria) {
        return categoria_repo.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        categoria_repo.deleteById(id);
    }

    @Override
    public Categoria_Entity update(Long id, Categoria_Entity categoria) {
        Optional<Categoria_Entity> categoriaExistente = categoria_repo.findById(id);

        if (categoriaExistente.isPresent()) {
            Categoria_Entity categoriaActualizada = categoriaExistente.get();
            categoriaActualizada.setNombre(categoria.getNombre());

            return categoria_repo.save(categoriaActualizada);
        }
        return null; // O lanzar excepción si la categoría no existe
    }
}
