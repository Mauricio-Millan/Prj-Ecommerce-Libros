package org.example.restecommercelibros.Controller;

import org.example.restecommercelibros.Model.Autor_Entity;
import org.example.restecommercelibros.Service.Autor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class Autor_Controller {
    @Autowired
    private Autor_Service autor_serv;

    @GetMapping
    public List<Autor_Entity> findAll() {
        return autor_serv.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Autor_Entity> findById(@PathVariable Long id){
        return autor_serv.findById(id);
    }

    @PostMapping
    public Autor_Entity save(@RequestBody Autor_Entity autor) {
        return autor_serv.save(autor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        autor_serv.deleteById(id);
    }

    @PutMapping("/{id}")
    public Autor_Entity update(@PathVariable Long id, @RequestBody Autor_Entity autor) {
        return autor_serv.update(id, autor);
    }
}
