package br.com.jl.sentinela.lancamento.api.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.jl.sentinela.lancamento.api.TipoCategoriaController;
import br.com.jl.sentinela.lancamento.api.dto.TipoCategoriaDTO;
import br.com.jl.sentinela.lancamento.domain.model.TipoCategoria;

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
