package com.enlatadosmg.enlatado.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enlatadosmg.enlatado.usuario.ModeloUsuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<ModeloUsuario, Integer> {


    ;
}
