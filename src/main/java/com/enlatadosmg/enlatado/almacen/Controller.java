package com.enlatadosmg.enlatado.almacen;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacen")
public class Controller {
    private CajaService service;
    public Controller(CajaService service) {
        this.service = service;
    }

    @PostMapping("/caja")
    public ResponseEntity<Caja> agregarCaja() {
        Caja caja = service.agregarCaja();
        return ResponseEntity.ok(caja);
    }

    @DeleteMapping("/caja")
    public ResponseEntity<?> retirarCaja() {
        Caja caja = service.retirarCaja();
        return (caja != null) ?
                ResponseEntity.ok(caja) :
                ResponseEntity.status(204).body("No hay cajas para retirar.");
    }

    @GetMapping("/cajas")
    public List<Caja> verCajas() {
        return service.verCajas();
    }
}
