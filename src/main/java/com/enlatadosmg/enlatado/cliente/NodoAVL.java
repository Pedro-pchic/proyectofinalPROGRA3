package com.enlatadosmg.enlatado.cliente;


import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
public class NodoAVL {
    private final Cliente cliente;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    private int altura = 1;
}


