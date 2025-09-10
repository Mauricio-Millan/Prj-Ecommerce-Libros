package org.example.restecommercelibros.Controller;

import org.example.restecommercelibros.Model.LibroAutor_Entity;
import org.example.restecommercelibros.Service.LibroAutor_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libro-autores")
public class LibroAutor_Controller {
    @Autowired
    private LibroAutor_Service libroAutor_serv;

    @GetMapping
    public List<LibroAutor_Entity> findAll() {
        return libroAutor_serv.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LibroAutor_Entity> findById(@PathVariable Long id){
        return libroAutor_serv.findById(id);
    }

    @PostMapping
    public LibroAutor_Entity save(@RequestBody LibroAutor_Entity LibroAutor){return libroAutor_serv.save(LibroAutor);}

    @PutMapping("/{id}")
    public LibroAutor_Entity update (@PathVariable Long id, @RequestBody LibroAutor_Entity LibroAutor){
        return libroAutor_serv.update(id, LibroAutor);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){return libroAutor_serv.deleteById(id);}
}
