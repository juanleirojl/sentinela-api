package br.com.jl.sentinela.api.exception;

public class EntidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException() {
        super("Entidade não encontrada");
    }

}