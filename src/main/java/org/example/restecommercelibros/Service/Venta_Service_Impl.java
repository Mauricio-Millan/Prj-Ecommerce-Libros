package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Usuario_Entity;
import org.example.restecommercelibros.Model.Venta_Entity;
import org.example.restecommercelibros.Repository.Venta_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Venta_Service_Impl implements Venta_Service {
    @Autowired
    private Venta_Repository venta_repo;

    @Override
    public List<Venta_Entity> findAll() {
        return (List<Venta_Entity>) venta_repo.findAll();
    }

    @Override
    public Optional<Venta_Entity> findById(Long id){
        return venta_repo.findById(id);
    }

    @Override
    public Venta_Entity save(Venta_Entity venta) {
        return venta_repo.save(venta);
    }

    @Override
    public void deleteById(Long id) {
        venta_repo.deleteById(id);
    }

    @Override
    public Venta_Entity update(Long id, Venta_Entity venta) {
        Optional<Venta_Entity> ventaExistente = venta_repo.findById(id);

        if (ventaExistente.isPresent()) {
            Venta_Entity ventaActualizada = ventaExistente.get();
            ventaActualizada.setUsuario(venta.getUsuario());
            ventaActualizada.setFecha(venta.getFecha());

            return venta_repo.save(ventaActualizada);
        }
        return null; // O lanzar excepción si el usuario no existe
    }
}

