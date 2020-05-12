package br.com.jl.sentinela.lancamento.domain.repository;

import br.com.jl.sentinela.lancamento.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
