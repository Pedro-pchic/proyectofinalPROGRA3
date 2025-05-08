package com.enlatadosmg.enlatado.almacen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/almacen")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @PostMapping("/almacenar")
    public ResponseEntity<String> almacenarCaja(@RequestBody Caja caja) {
        almacenService.almacenarCaja(caja);
        return ResponseEntity.ok("Caja almacenada con éxito.");
    }

    @GetMapping("/retirar")
    public ResponseEntity<Caja> retirarCaja() {
        Caja cajaRetirada = almacenService.retirarCaja();
        if (cajaRetirada != null) {
            return ResponseEntity.ok(cajaRetirada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/verSuperior")
    public ResponseEntity<Caja> verCajaSuperior() {
        Caja cajaSuperior = almacenService.verCajaSuperior();
        if (cajaSuperior != null) {
            return ResponseEntity.ok(cajaSuperior);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/estaVacia")
    public ResponseEntity<Boolean> estaVacia() {
        return ResponseEntity.ok(almacenService.estaVacia());
    }
}
