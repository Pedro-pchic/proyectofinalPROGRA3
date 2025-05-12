package com.enlatadosmg.enlatado.cliente;
import com.enlatadosmg.enlatado.cliente.Cliente;


public class ArbolAVL {
    private NodoAVL raiz;

    public void insertar(Cliente cliente) {
        raiz = insertar(raiz, cliente);
    }

    private NodoAVL insertar(NodoAVL nodo, Cliente cliente) {
        if (nodo == null) return new NodoAVL(cliente);

        if (cliente.getCui() < nodo.getCliente().getCui()) {
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), cliente));
        } else if (cliente.getCui() > nodo.getCliente().getCui()) {
            nodo.setDerecho(insertar(nodo.getDerecho(), cliente));
        } else {
            return nodo; // No duplicar
        }

        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));
        return balancear(nodo);
    }

    private NodoAVL balancear(NodoAVL nodo) {
        int balance = getBalance(nodo);

        if (balance > 1) {
            if (getBalance(nodo.getIzquierdo()) < 0) {
                nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
            }
            return rotarDerecha(nodo);
        }

        if (balance < -1) {
            if (getBalance(nodo.getDerecho()) > 0) {
                nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            }
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.getIzquierdo();
        NodoAVL T2 = x.getDerecho();

        x.setDerecho(y);
        y.setIzquierdo(T2);

        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);
        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);

        return x;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.getDerecho();
        NodoAVL T2 = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(T2);

        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);
        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);

        return y;
    }

    private int altura(NodoAVL nodo) {
        return nodo == null ? 0 : nodo.getAltura();
    }

    private int getBalance(NodoAVL nodo) {
        return nodo == null ? 0 : altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
    }

    public Cliente buscar(Long cui) {
        return buscar(raiz, cui);
    }

    private Cliente buscar(NodoAVL nodo, Long cui) {
        if (nodo == null) return null;

        if (cui.equals(nodo.getCliente().getCui())) {
            return nodo.getCliente();
        }

        return cui < nodo.getCliente().getCui()
                ? buscar(nodo.getIzquierdo(), cui)
                : buscar(nodo.getDerecho(), cui);
    }

}
