package org.example.restecommercelibros.Model;

import ch.qos.logback.core.model.NamedModel;
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
@Table(name= "usuario")
public class Usuario_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 255)
    private String nombre;

    @Column(name = "apellido", length = 255)
    private String apellido;

    @Column(name = "clave", length = 255)
    private String clave;

    @Column(name = "email", length = 255, unique = true)
    private String email;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "numero-telefono", length = 20)
    private String telefono;


}
