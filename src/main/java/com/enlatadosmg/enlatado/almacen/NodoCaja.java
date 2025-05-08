package com.enlatadosmg.enlatado.almacen;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NodoCaja {
    private Caja caja;
    private NodoCaja siguiente;

    public NodoCaja(Caja caja) {
        this.caja = caja;
        this.siguiente = null;
    }


}
