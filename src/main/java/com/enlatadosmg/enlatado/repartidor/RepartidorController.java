package com.enlatadosmg.enlatado.repartidor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repartidores")
public class RepartidorController {
    private final RepartidorService service;

    @Autowired
    public RepartidorController(RepartidorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Repartidor> listar() {
        return service.obtenerCola();
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> agregar(@RequestBody Repartidor r) {
        service.agregarRepartidor(r);
        return ResponseEntity.ok("Repartidor agregado.");
    }

    @PostMapping("/asignar")
    public ResponseEntity<Repartidor> asignar() {
        Repartidor r = service.asignarRepartidor();
        if (r == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(r);
    }

    @PostMapping("/finalizar")
    public ResponseEntity<String> finalizar(@RequestBody Repartidor r) {
        service.finalizarEntrega(r);
        return ResponseEntity.ok("Repartidor disponible nuevamente.");
    }
}
