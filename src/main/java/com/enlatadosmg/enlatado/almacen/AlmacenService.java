package com.enlatadosmg.enlatado.almacen;

public class AlmacenService {
    private final PilaCaja pilaCaja;

    public AlmacenService(PilaCaja pilaCaja) {
        this.pilaCaja = pilaCaja;
    }

    public void almacenarCaja(Caja caja){
        pilaCaja.push(caja);
    }

    public Caja retirarCaja(){
        return pilaCaja.pop();
    }
    public Caja verCajaSuperior(){
        return pilaCaja.peek();
    }
    public boolean estaVacia(){
        return pilaCaja.isEmpty();
    }


}
