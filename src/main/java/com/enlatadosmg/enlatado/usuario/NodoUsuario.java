package com.enlatadosmg.enlatado.usuario;


import com.enlatadosmg.enlatado.usuario.ModeloUsuario;
public class NodoUsuario {
    private Nodo cabeza;


    private class Nodo{
        ModeloUsuario usuario;
        Nodo siguiente;

        Nodo(ModeloUsuario usuario){
            this.usuario = usuario;
        }
    }
    // verificar si la lista esta vacia
    public boolean estaVacia(){
        return cabeza == null;
    }
    // insertar al frente
    public void insertarAlFrente(ModeloUsuario usuario){
        Nodo nuevo = new Nodo(usuario);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
    // insertar al final
    public void insertarAlFinal(ModeloUsuario usuario){
        Nodo nuevo = new Nodo(usuario);
        if(cabeza == null){
            cabeza = nuevo;
        }else {
            Nodo actual = cabeza;
            while (actual.siguiente !=null){
                actual = actual.siguiente;
            }
            actual.siguiente =nuevo;
        }
    }
    public boolean eliminarPorId(int id){
        if (cabeza == null) return false;

        if(cabeza.usuario.getId() == id){
            cabeza = cabeza.siguiente;
            return  true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null){
            if (actual.siguiente.usuario.getId() == id){
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }


    public void eliminarAlFrente(){
        if(cabeza != null) cabeza = cabeza.siguiente;
    }
    public void eliminarAlFinal(){
        if(cabeza == null || cabeza.siguiente == null){
            cabeza = null;
        }else {
            Nodo actual = cabeza;
            while (actual.siguiente.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = null;
        }

    }

    public void imprimir(){
        Nodo actual = cabeza;
        while(actual != null){
            ModeloUsuario u = actual.usuario;
            System.out.println("ID:" + u.getId() + ", Nombre :" + u.getNombre());
            actual = actual.siguiente;
        }
    }
}
