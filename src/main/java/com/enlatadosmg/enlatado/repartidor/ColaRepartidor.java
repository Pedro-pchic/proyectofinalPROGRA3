package com.enlatadosmg.enlatado.repartidor;

import org.checkerframework.checker.units.qual.N;

import java.util.ArrayList;
import java.util.List;

public class ColaRepartidor {
    private Nodo frente;
    private Nodo fin;

    public ColaRepartidor() {
        this.fin = null;
        this.frente = null;
    }

    public boolean estaVacia(){
        return frente == null;
    }

    public void encolar(Repartidor r){
        Nodo nuevo = new Nodo(r);
        if(estaVacia()){
            frente = fin = nuevo;
        }else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }


    public Repartidor desacolar(){
        if(estaVacia()) return null;
        Repartidor r = frente.getRepartidor();
        frente = frente.getSiguiente();
        if(frente == null) fin = null;
        return r;
    }

    public List<Repartidor> listar(){
        List<Repartidor> lista = new ArrayList<>();
        Nodo actual = frente;
        while (actual != null){
            lista.add(actual.getRepartidor());
            actual = actual.getSiguiente();
        }
        return  lista;
    }



}
