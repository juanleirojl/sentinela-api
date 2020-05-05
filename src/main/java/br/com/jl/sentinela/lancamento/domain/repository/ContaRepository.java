package br.com.jl.sentinela.lancamento.domain.repository;

import br.com.jl.sentinela.lancamento.domain.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long>{

}
