package com.enlatadosmg.enlatado.vehiculo;


import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehiculoService {

    private VehiculoRepository repository;
    private Cola cola = new Cola();

    @PostConstruct
    public void iniCola(){
        List<Vehiculo> vehiculos = repository.findAll();
        for(Vehiculo v : vehiculos) cola.encolar(v);
    }

    public List<Vehiculo> obtenerVehiculosEnCola(){
        return  cola.listar();

    }

    public Vehiculo asignarVehiculo(){
        return  cola.desencolar();
    }

    public void devolverVehiculo(Vehiculo vehiculo){
        cola.encolar(vehiculo);
    }

    public Vehiculo agregarVehiculo(Vehiculo vehiculo){
        repository.save(vehiculo);
        cola.encolar(vehiculo);
        return  vehiculo;
    }

}
