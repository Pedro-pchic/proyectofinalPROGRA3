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

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<ModeloUsuario> createUsuario(@RequestBody ModeloUsuario usuario) {
        ModeloUsuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<ModeloUsuario>> getAllUsuarios() {
        List<ModeloUsuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<ModeloUsuario> getUsuarioById(@PathVariable int id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<ModeloUsuario> updateUsuario(@PathVariable int id, @RequestBody ModeloUsuario detallesusuario) {
        ModeloUsuario usuarioActualizado = usuarioService.update(id, detallesusuario);
        return usuarioActualizado != null ? ResponseEntity.ok(usuarioActualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
