package com.enlatadosmg.enlatado.almacen;

public class PilaCaja {
    private NodoCaja cima;

    public PilaCaja(NodoCaja cima) {
        this.cima = null;
    }
    //agregar una caja a la pila
    public void push(Caja caja){
        NodoCaja nuevoNodo = new NodoCaja(caja);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
    }
    //retirar la caja de la cima de la pila
    public Caja pop(){
        if  (cima == null){
            return  null; // la pila esta vacia
        }
        Caja cajaRetirada = cima.getCaja();
        cima = cima.getSiguiente();
        return cajaRetirada;
    }
    //ver la caja en la cima de la pila
    public Caja peek(){
        return (cima != null) ? cima.getCaja() : null;

    }
    public boolean isEmpty(){
        return cima == null;
    }


}
