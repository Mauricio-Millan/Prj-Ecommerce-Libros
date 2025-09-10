package org.example.restecommercelibros.Controller;


import org.example.restecommercelibros.Model.Libro_Entity;
import org.example.restecommercelibros.Service.Libro_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class Libro_Controller {
    @Autowired
    private Libro_Service libro_serv;

    @GetMapping
    public List<Libro_Entity> findAll() {
        return libro_serv.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Libro_Entity> finById(@PathVariable Long id){
        return libro_serv.findById(id);
    }

    @PostMapping
    public Libro_Entity save(@RequestBody Libro_Entity libro){
        return libro_serv.save(libro);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        libro_serv.deleteById(id);
    }
    // Libro_Controller.java
    @PutMapping("/{id}")
    public Libro_Entity update(@PathVariable Long id, @RequestBody Libro_Entity libro) {
        return libro_serv.update(id, libro);
    }
}
