package org.example.restecommercelibros.Service;

import org.example.restecommercelibros.Model.Edicion_Entity;
import org.example.restecommercelibros.Repository.Edicion_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Edicion_Service_Impl implements Edicion_Service {
    @Autowired
    private Edicion_Repository edicion_repo;

    @Override
    public List<Edicion_Entity> findAll() {
        return (List<Edicion_Entity>) edicion_repo.findAll();
    }

    @Override
    public Optional<Edicion_Entity> findById(Long id){
        return edicion_repo.findById(id);
    }

    @Override
    public Edicion_Entity save(Edicion_Entity edicion) {
        return edicion_repo.save(edicion);
    }

    @Override
    public void deleteById(Long id) {
        edicion_repo.deleteById(id);
    }

    @Override
    public Edicion_Entity update(Long id, Edicion_Entity edicion) {
        Optional<Edicion_Entity> edicionExistente = edicion_repo.findById(id);

        if (edicionExistente.isPresent()) {
            Edicion_Entity edicionActualizada = edicionExistente.get();

            // Actualizar campos básicos
            edicionActualizada.setIdioma(edicion.getIdioma());
            edicionActualizada.setEncuadernacion(edicion.getEncuadernacion());
            edicionActualizada.setDimensiones(edicion.getDimensiones());
            edicionActualizada.setTraductor(edicion.getTraductor());
            edicionActualizada.setFecha_publicacion(edicion.getFecha_publicacion());
            edicionActualizada.setPrecio_venta(edicion.getPrecio_venta());
            edicionActualizada.setResumen(edicion.getResumen());

            // Actualizar referencias
            if (edicion.getLibro() != null) {
                edicionActualizada.setLibro(edicion.getLibro());
            }

            if (edicion.getEditorial() != null) {
                edicionActualizada.setEditorial(edicion.getEditorial());
            }

            return edicion_repo.save(edicionActualizada);
        }
        return null; // O lanzar excepción si la edición no existe
    }
}
