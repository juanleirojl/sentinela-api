package br.com.jl.sentinela.lancamento.api.dto.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.jl.sentinela.lancamento.api.CategoriaController;
import br.com.jl.sentinela.lancamento.api.dto.CategoriaDTO;
import br.com.jl.sentinela.lancamento.api.dto.TipoCategoriaDTO;
import br.com.jl.sentinela.lancamento.domain.model.Categoria;

@Component
public class CategoriaDTOAssembler extends RepresentationModelAssemblerSupport<Categoria, CategoriaDTO> {

	public CategoriaDTOAssembler() {
		super(CategoriaController.class, CategoriaDTO.class);
	}

	@Override
	public CategoriaDTO toModel(Categoria categoria) {
		return CategoriaDTO.builder()
				.id(categoria.getId())
				.nome(categoria.getNome())
				.tipoCategoria(TipoCategoriaDTO.toModel(categoria.getTipoCategoria()))
				.build();
	}


}
