package com.enlatadosmg.enlatado.repartidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

@Service
public class RepartidorService {

    private final RepartidorRepository repository;
    private final ColaRepartidor cola = new ColaRepartidor();

    @Autowired
    public RepartidorService(RepartidorRepository repository){
        this.repository = repository;
        inicializarCola();
    }
    private void inicializarCola(){
        repository.findAll().forEach(cola::encolar);
    }
    public List<Repartidor> obtenerCola(){
        return cola.listar();
    }
    public void agregarRepartidor(Repartidor r){
        repository.save(r);
        cola.encolar(r);
    }
    public Repartidor asignarRepartidor(){
        return cola.desacolar();
    }
    public void finalizarEntrega(Repartidor r){
        cola.encolar(r);
    }


}
