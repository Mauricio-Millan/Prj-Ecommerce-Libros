package org.example.restecommercelibros.JWT;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.restecommercelibros.Model.Rol_Entity;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Register_Request {

    private int id;

    private String nombre;

    private String apellido;

    private String clave;

    private String email;

    private String direccion;

    private String telefono;

    private Rol_Entity idRol;

}
