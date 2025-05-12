package com.enlatadosmg.enlatado.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    private int cui;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;


}
