package com.enlatadosmg.enlatado.vehiculo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id

    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private int anio;

    public Vehiculo(int anio, String color, String marca, String modelo, String placa) {
        this.anio = anio;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }
}
