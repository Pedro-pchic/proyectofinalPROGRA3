package com.enlatadosmg.enlatado.usuario;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter

@Entity
@Table(name = "usuarios")
public class ModeloUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String contrasena;

    public ModeloUsuario() {

    }

    public ModeloUsuario(int id, String nombre, String apellido, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
    }


}
