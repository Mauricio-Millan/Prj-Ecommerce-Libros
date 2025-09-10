package org.example.restecommercelibros.Controller;

import org.example.restecommercelibros.Model.DetalleVenta_Entity;
import org.example.restecommercelibros.Service.DetalleVenta_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-ventas")
public class DetalleVenta_Controller {
    @Autowired
    private DetalleVenta_Service detalleVenta_serv;

    @GetMapping
    public List<DetalleVenta_Entity> findAll() {
        return detalleVenta_serv.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DetalleVenta_Entity> findById(@PathVariable Long id){
        return detalleVenta_serv.findById(id);
    }
}
