package com.enlatadosmg.enlatado.almacen;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Caja {
    private int id;
    private String contenido;

    public Caja() {

    }

    public Caja(String contenido, int id) {
        this.contenido = contenido;
        this.id = id;
    }

}
