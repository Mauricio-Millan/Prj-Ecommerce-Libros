package org.example.restecommercelibros.Controller;

import org.example.restecommercelibros.Model.Edicion_Entity;
import org.example.restecommercelibros.Service.Edicion_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ediciones")
public class Edicion_Controller {
    @Autowired
    private Edicion_Service edicion_serv;

    @GetMapping
    public List<Edicion_Entity> findAll() {
        return edicion_serv.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Edicion_Entity> findById(@PathVariable Long id){
        return edicion_serv.findById(id);
    }

    @PostMapping
    public Edicion_Entity save(@RequestBody Edicion_Entity edicion) {
        return edicion_serv.save(edicion);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        edicion_serv.deleteById(id);
    }

    @PutMapping("/{id}")
    public Edicion_Entity update(@PathVariable Long id, @RequestBody Edicion_Entity edicion) {
        return edicion_serv.update(id, edicion);
    }
}
