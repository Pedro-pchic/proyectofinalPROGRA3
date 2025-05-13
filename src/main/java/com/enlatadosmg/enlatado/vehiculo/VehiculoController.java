package com.enlatadosmg.enlatado.vehiculo;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    private VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vehiculo> listarVehiculos(){
        return service.obtenerVehiculosEnCola();
    }

    @PostMapping
    public Vehiculo agregarVehiculos(@RequestBody Vehiculo vehiculo){
        return service.agregarVehiculo(vehiculo);
    }
    @GetMapping("/asignar")
    public Vehiculo asignarVehiculos(){
        return  service.asignarVehiculo();
    }

    @PostMapping("/devolver")
    public void devolverVehiculo(@RequestBody Vehiculo vehiculo){
        service.devolverVehiculo(vehiculo);
    }



}
