package com.enlatadosmg.enlatado.almacen;


import org.springframework.stereotype.Service;
import com.enlatadosmg.enlatado.almacen.PilaCaja;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CajaService {
    private  PilaCaja pilaCajas;

    public CajaService(PilaCaja pilaCajas) {
        this.pilaCajas = pilaCajas;
    }

    public Caja agregarCaja() {
        return pilaCajas.pushCaja();
    }

    public Caja retirarCaja() {
        return pilaCajas.popCaja();
    }

    public List<Caja> verCajas() {
        return pilaCajas.listarCajas();
    }

    public boolean estaVacia() {
        return pilaCajas.estaVacia();
    }
}
