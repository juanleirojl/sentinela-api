package br.com.jl.sentinela.seguranca.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException() {
        super("Entidade não encontrada");
    }

}