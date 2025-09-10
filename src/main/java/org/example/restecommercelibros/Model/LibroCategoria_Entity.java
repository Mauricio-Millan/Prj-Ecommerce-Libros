package org.example.restecommercelibros.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "libro_categoria")
public class LibroCategoria_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro_Entity libro;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria_Entity categoria;
}
