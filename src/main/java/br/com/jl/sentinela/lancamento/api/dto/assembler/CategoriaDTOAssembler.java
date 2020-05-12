package br.com.jl.sentinela.lancamento.api.dto.assembler;

import br.com.jl.sentinela.lancamento.api.controller.CategoriaController;
import br.com.jl.sentinela.lancamento.api.dto.CategoriaDTO;
import br.com.jl.sentinela.lancamento.domain.model.Categoria;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

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
				//.tipoCategoria(ContaDTO.toModel(categoria.getTipoCategoria()))
				.build();
	}


}
