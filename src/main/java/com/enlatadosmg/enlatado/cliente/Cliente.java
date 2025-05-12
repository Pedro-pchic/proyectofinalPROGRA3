package com.enlatadosmg.enlatado.cliente;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Cliente{
    private int cui;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

    public Cliente(int cui, String apellido, String direccion, String nombre, String telefono) {
        this.apellido = apellido;
        this.cui = cui;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
