package com.enlatadosmg.enlatado.almacen;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PilaCaja {
    private CajaRepository cajaRepository;
    private AtomicInteger contadorCorrelativo = new AtomicInteger(1);

    public PilaCaja(CajaRepository cajaRepository){
        this.cajaRepository = cajaRepository;
        inicializarCorrelativo();
    }
    public void inicializarCorrelativo(){
        List<Caja> caja = cajaRepository.findAll();
        if(!caja.isEmpty()){
            int max = caja.stream().mapToInt(Caja::getCorrelativo).max().orElse(0);
            contadorCorrelativo.set(max + 1);
        }
    }
    public Caja pushCaja() {
        Caja nueva = new Caja(contadorCorrelativo.getAndIncrement());
        return cajaRepository.save(nueva);
    }
    public Caja popCaja(){
        List<Caja> cajas = cajaRepository.findAll();
        if (cajas.isEmpty()) return null;

        // Retirar la última ingresada (comportamiento LIFO)
        Caja ultima = cajas.get(cajas.size() - 1);
        cajaRepository.delete(ultima);
        return ultima;
    }

    public List<Caja> listarCajas() {
        return cajaRepository.findAll();
    }

    public boolean estaVacia() {
        return cajaRepository.count() == 0;
    }


}
