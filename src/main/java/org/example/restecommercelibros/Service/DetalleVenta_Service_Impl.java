package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.DetalleVenta_Entity;
import org.example.restecommercelibros.Repository.DetalleVenta_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVenta_Service_Impl implements DetalleVenta_Service {
    @Autowired
    private DetalleVenta_Repository detalleVenta_repo;

    @Override
    public List<DetalleVenta_Entity> findAll() {
        return (List<DetalleVenta_Entity>) detalleVenta_repo.findAll();
    }

    @Override
    public Optional<DetalleVenta_Entity> findById(Long id){
        return detalleVenta_repo.findById(id);
    }
}
