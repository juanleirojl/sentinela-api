package br.com.jl.sentinela.lancamento.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jl.sentinela.lancamento.api.doc.CategoriaControllerAPI;
import br.com.jl.sentinela.lancamento.api.dto.CategoriaDTO;
import br.com.jl.sentinela.lancamento.api.dto.assembler.CategoriaDTOAssembler;
import br.com.jl.sentinela.lancamento.domain.model.Categoria;
import br.com.jl.sentinela.lancamento.domain.model.CategoriaRepository;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/categorias")
@Api(tags = "Categorias")
public class CategoriaController implements CategoriaControllerAPI{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private PagedResourcesAssembler<Categoria> pagedResourcesAssembler;
	
	@Autowired
	private CategoriaDTOAssembler categoriaDTOAssembler;
	
	@Override
	@GetMapping(value="/listar")
	public PagedModel<CategoriaDTO> listar(@PageableDefault(size = 10) Pageable pageable) {
		
		Page<Categoria> categoriaPage = categoriaRepository.findAll(pageable);
//		List<CategoriaDTO> listaCategoria = categoriaPage.getContent()
//																	.stream()
//																	.map(CategoriaDTO::toModel)
//																	.collect(Collectors.toList());
		
		
		PagedModel<CategoriaDTO> model = pagedResourcesAssembler.toModel(categoriaPage,categoriaDTOAssembler);
		return model;
	}

	@Override
	public CategoriaDTO buscar(Long categoriaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaDTO adicionar(CategoriaDTO categoriaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaDTO atualizar(Long categoriaId, CategoriaDTO categoriaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Long categoriaId) {
		// TODO Auto-generated method stub
		
	}

}
