package com.enlatadosmg.enlatado.almacen;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "almacen")
public class Caja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private int correlativo;
    private LocalDate fechaIngreso;

    public Caja() {

    }

    public Caja(int correlativo) {
        this.correlativo = correlativo;
        this.fechaIngreso = LocalDate.now();
    }
}
