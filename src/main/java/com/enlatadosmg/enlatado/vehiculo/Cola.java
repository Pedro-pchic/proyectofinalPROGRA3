package com.enlatadosmg.enlatado.vehiculo;
import java.util.LinkedList;
import java.util.List;
public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.fin = null;
        this.frente = null;
    }
    public boolean estaVacia(){
        return frente == null;
    }
    public void encolar(Vehiculo vehiculo){
        Nodo nuevo = new Nodo(vehiculo);
        if(estaVacia()){
            frente = fin = nuevo;
        }else{
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public  Vehiculo desencolar(){
        if(estaVacia()) return  null;
        Vehiculo vehiculo = frente.vehiculo;
        frente = frente.siguiente;
        if(frente == null) fin = null;
        return vehiculo;

    }

    public List<Vehiculo> listar(){
        List<Vehiculo> lista = new LinkedList<>();
        Nodo actual = frente;
        while (actual != null){
            lista.add(actual.vehiculo);
            actual = actual.siguiente;
        }
        return lista;
    }

}
