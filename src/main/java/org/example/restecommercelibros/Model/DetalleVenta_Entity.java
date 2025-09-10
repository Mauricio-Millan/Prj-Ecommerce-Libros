package org.example.restecommercelibros.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "detalle_venta")
public class DetalleVenta_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_edicion")
    private Edicion_Entity edicion;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta_Entity venta;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precio_venta;

    @Column(name = "descuento", precision = 5, scale = 2)
    private BigDecimal descuento;
}
