package br.com.jl.sentinela.tipocategoria.api;

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

import br.com.jl.sentinela.tipocategoria.domain.model.TipoCategoria;
import br.com.jl.sentinela.tipocategoria.domain.model.TipoCategoriaRepository;
import br.com.jl.sentinela.tipocategoria.domain.model.dto.TipoCategoriaDTO;
import br.com.jl.sentinela.tipocategoria.domain.model.dto.TipoCategoriaDTOAssembler;
import io.swagger.annotations.Api;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Api(tags = "Tipos Categoria")
public class TipoCategoriaController implements TipoCategoriaControllerAPI{
	
	@Autowired
	private TipoCategoriaRepository tipoCategoriaRepository;
	
	@Autowired
	private PagedResourcesAssembler<TipoCategoria> pagedResourcesAssembler;
	
	@Autowired
	private TipoCategoriaDTOAssembler tipoCategoriaDTOAssembler;
	
	@Override
	@GetMapping(value="/listar")
	public PagedModel<TipoCategoriaDTO> listar(@PageableDefault(size = 10) Pageable pageable) {
		
		Page<TipoCategoria> tipoCategoriaPage = tipoCategoriaRepository.findAll(pageable);
//		List<TipoCategoriaDTO> listaTipoCategoria = tipoCategoriaPage.getContent()
//																	.stream()
//																	.map(TipoCategoriaDTO::toModel)
//																	.collect(Collectors.toList());
		
		
		PagedModel<TipoCategoriaDTO> model = pagedResourcesAssembler.toModel(tipoCategoriaPage,tipoCategoriaDTOAssembler);
		return model;
	}

	@Override
	public TipoCategoriaDTO buscar(Long tipoCategoriaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoCategoriaDTO adicionar(TipoCategoriaDTO tipoCategoriaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoCategoriaDTO atualizar(Long tipoCategoriaId, TipoCategoriaDTO tipoCategoriaDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Long tipoCategoriaId) {
		// TODO Auto-generated method stub
		
	}

}
