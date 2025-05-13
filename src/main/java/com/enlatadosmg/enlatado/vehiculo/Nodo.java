package com.enlatadosmg.enlatado.vehiculo;

public class Nodo {
    public Vehiculo vehiculo;
    public Nodo siguiente;

    public Nodo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        this.siguiente = null;
    }
}
