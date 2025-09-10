package org.example.restecommercelibros.Controller;

import org.example.restecommercelibros.Model.Editorial_Entity;
import org.example.restecommercelibros.Service.Editorial_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editoriales")
public class Editorial_Controller {
    @Autowired
    private Editorial_Service editorial_serv;

    @GetMapping
    public List<Editorial_Entity> findAll() {
        return editorial_serv.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Editorial_Entity> findById(@PathVariable Long id) {
        return editorial_serv.findById(id);
    }

    @PostMapping
    public Editorial_Entity save(@RequestBody Editorial_Entity editorial) {
        return editorial_serv.save(editorial);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        editorial_serv.deleteById(id);
    }

    @PutMapping("/{id}")
    public Editorial_Entity update(@PathVariable Long id, @RequestBody Editorial_Entity editorial) {
        return editorial_serv.update(id, editorial);
    }
}
