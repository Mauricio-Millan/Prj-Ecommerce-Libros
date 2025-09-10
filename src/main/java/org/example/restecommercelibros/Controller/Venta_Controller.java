package org.example.restecommercelibros.Controller;

import org.example.restecommercelibros.Model.Venta_Entity;
import org.example.restecommercelibros.Service.Venta_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class Venta_Controller {
    @Autowired
    private Venta_Service venta_serv;

    @GetMapping
    public List<Venta_Entity> findAll() {
        return venta_serv.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Venta_Entity> findById(@PathVariable Long id){
        return venta_serv.findById(id);
    }

    @PostMapping
    public Venta_Entity save(@RequestBody Venta_Entity venta){return venta_serv.save(venta);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        venta_serv.deleteById(id);
    }
    @PutMapping("/{id}")
    public Venta_Entity update(@PathVariable Long id, @RequestBody Venta_Entity venta) {
        return venta_serv.update(id, venta);
    }
}
