package com.enlatadosmg.enlatado.repartidor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Nodo {
    private Repartidor repartidor;
    private Nodo siguiente;

    public Nodo(Repartidor repartidor) {
        this.repartidor = repartidor;
        this.siguiente = null;
    }

}
