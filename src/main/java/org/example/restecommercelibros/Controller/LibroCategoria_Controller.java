package org.example.restecommercelibros.Controller;

import org.example.restecommercelibros.Model.LibroCategoria_Entity;
import org.example.restecommercelibros.Service.LibroCategoria_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libro-categorias")
public class LibroCategoria_Controller {
    @Autowired
    private LibroCategoria_Service libroCategoria_serv;

    @GetMapping
    public List<LibroCategoria_Entity> findAll() {
        return libroCategoria_serv.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<LibroCategoria_Entity> findById(@PathVariable Long id){
        return libroCategoria_serv.findById(id);
    }
}
