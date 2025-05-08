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
    public List<ModeloUsuario> obtenerTodos(){
        return usuarioRepository.findAll();
    }
    // Buscar por ID en base de datos
    public ModeloUsuario buscarPorId(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Eliminar por ID en lista y base de datos
    public boolean eliminarPorId(int id) {
        boolean eliminadoLista = listaUsuarios.eliminarPorId(id);
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return eliminadoLista;
    }

    // Métodos de la lista enlazada (solo en memoria)
    public void imprimirLista() {
        listaUsuarios.imprimir();
    }

    public boolean estaVacia() {
        return listaUsuarios.estaVacia();
    }

    public void eliminarInicio() {
        listaUsuarios.eliminarAlFrente();
    }

    public void eliminarFinal() {
        listaUsuarios.eliminarAlFinal();
    }

}
