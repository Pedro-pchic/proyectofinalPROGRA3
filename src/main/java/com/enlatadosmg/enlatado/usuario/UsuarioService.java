package com.enlatadosmg.enlatado.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService  {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private NodoUsuario listaUsuarios = new NodoUsuario();

    public ModeloUsuario guardarUsuario(ModeloUsuario usuario){
        listaUsuarios.insertarAlFinal(usuario);
        return usuarioRepository.save(usuario);
    }

    //eliminar usuario
    public boolean eliminarUsuario(int id){
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteAllById(id);
            listaUsuarios.eliminarAlFinal();
        }
    }

}
