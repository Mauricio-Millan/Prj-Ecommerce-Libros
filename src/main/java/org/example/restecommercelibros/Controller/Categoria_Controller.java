package org.example.restecommercelibros.Controller;

import org.example.restecommercelibros.Model.Categoria_Entity;
import org.example.restecommercelibros.Service.Categoria_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class Categoria_Controller {
    @Autowired
    private Categoria_Service categoria_serv;

    @GetMapping
    public List<Categoria_Entity> findAll() {
        return categoria_serv.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria_Entity> findById(@PathVariable Long id){
        return categoria_serv.findById(id);
    }

    @PostMapping
    public Categoria_Entity save(@RequestBody Categoria_Entity categoria) {
        return categoria_serv.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoria_serv.deleteById(id);
    }

    @PutMapping("/{id}")
    public Categoria_Entity update(@PathVariable Long id, @RequestBody Categoria_Entity categoria) {
        return categoria_serv.update(id, categoria);
    }
}
