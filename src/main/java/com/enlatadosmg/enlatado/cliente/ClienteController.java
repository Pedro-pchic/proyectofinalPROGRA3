package com.enlatadosmg.enlatado.cliente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public String agregarCliente(@RequestBody Cliente cliente) {
        clienteService.agregarCliente(cliente);
        return "Cliente agregado correctamente;";
    }

    @GetMapping("/{cui}")
    public Cliente obtenerCliente(@PathVariable Long cui) {
        return clienteService.buscarCliente(cui);
    }
}
