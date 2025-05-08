package com.enlatadosmg.enlatado.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ModeloUsuario crearUsuario(@RequestBody ModeloUsuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping
    public  List<ModeloUsuario> obtenerUsuarios(){
        return usuarioService.obtenerTodos();
    }
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable int id) {
        boolean eliminado = usuarioService.eliminarPorId(id);
        return eliminado ? "Usuario eliminado" : "Usuario no encontrado";
    }

    // Solo para pruebas de lista enlazada (memoria)
    @GetMapping("/lista")
    public void imprimirLista() {
        usuarioService.imprimirLista();
    }

    @GetMapping("/vacia")
    public boolean estaVacia() {
        return usuarioService.estaVacia();
    }

    @DeleteMapping("/inicio")
    public void eliminarInicio() {
        usuarioService.eliminarInicio();
    }

    @DeleteMapping("/final")
    public void eliminarFinal() {
        usuarioService.eliminarFinal();
    }
}
