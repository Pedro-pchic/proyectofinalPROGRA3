package com.enlatadosmg.enlatado.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import com.enlatadosmg.enlatado.usuario.ModeloUsuario;
public interface UsuarioRepository extends JpaRepository<ModeloUsuario, Integer> {


}
