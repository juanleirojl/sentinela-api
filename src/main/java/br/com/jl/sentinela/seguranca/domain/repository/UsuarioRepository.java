package br.com.jl.sentinela.seguranca.domain.repository;

import br.com.jl.sentinela.seguranca.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
