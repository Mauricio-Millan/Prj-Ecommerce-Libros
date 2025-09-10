package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.LibroCategoria_Entity;
import org.example.restecommercelibros.Repository.LibroCategoria_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroCategoria_Service_Impl implements LibroCategoria_Service {
    @Autowired
    private LibroCategoria_Repository libroCategoria_repo;

    @Override
    public List<LibroCategoria_Entity> findAll() {
        return (List<LibroCategoria_Entity>) libroCategoria_repo.findAll();
    }

    @Override
    public Optional<LibroCategoria_Entity> findById(Long id){
        return libroCategoria_repo.findById(id);
    }
}
