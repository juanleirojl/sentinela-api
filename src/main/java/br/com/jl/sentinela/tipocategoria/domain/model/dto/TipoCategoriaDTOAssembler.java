package br.com.jl.sentinela.tipocategoria.domain.model.dto;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.jl.sentinela.tipocategoria.api.TipoCategoriaController;
import br.com.jl.sentinela.tipocategoria.domain.model.TipoCategoria;

@Component
public class TipoCategoriaDTOAssembler extends RepresentationModelAssemblerSupport<TipoCategoria, TipoCategoriaDTO> {

	public TipoCategoriaDTOAssembler() {
		super(TipoCategoriaController.class, TipoCategoriaDTO.class);
	}

	@Override
	public TipoCategoriaDTO toModel(TipoCategoria tipoCategoria) {
		return TipoCategoriaDTO.builder()
				.id(tipoCategoria.getId())
				.nome(tipoCategoria.getNome())
				.build();
	}


}
