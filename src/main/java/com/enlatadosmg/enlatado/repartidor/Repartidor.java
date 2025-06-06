package com.enlatadosmg.enlatado.repartidor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "repartidor")
public class Repartidor {
    @Id
    private String cui;
    private String nombre;
    private String apellido;
    private String licencia;
    private String telefono;


}
