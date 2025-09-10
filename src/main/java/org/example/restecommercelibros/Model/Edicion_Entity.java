package org.example.restecommercelibros.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "edicion")
public class Edicion_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idioma", length = 100)
    private String idioma;

    @Column(name = "encuadernacion", length = 100)
    private String encuadernacion;

    @Column(name = "dimensiones", length = 100)
    private String dimensiones;

    @Column(name = "traductor", length = 255)
    private String traductor;

    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fecha_publicacion;

    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precio_venta;

    @Column(name = "resumen", columnDefinition = "TEXT")
    private String resumen;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro_Entity libro;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Editorial_Entity editorial;
}
