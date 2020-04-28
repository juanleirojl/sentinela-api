package br.com.jl.sentinela.lancamento.api.doc;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import br.com.jl.sentinela.lancamento.api.dto.CategoriaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "TiposCategoria")
public interface CategoriaControllerAPI {
	
	@ApiOperation("Lista as categorias com paginação")
	PagedModel<CategoriaDTO> listar(Pageable pageable);
	
	@ApiOperation("Busca uma categoria por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID da categoria inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Categoria não encontrada", response = Problem.class)
	})
	CategoriaDTO buscar(@ApiParam(value = "ID de uma categoria", example = "1", required = true)	Long categoriaId);
	
	@ApiOperation("Cadastra uma categoria")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Categoria cadastrada"),
	})
	CategoriaDTO adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova categoria", required = true)
			CategoriaDTO categoriaDTO);
	
	@ApiOperation("Atualiza uma categoria por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Categoria atualizada"),
		@ApiResponse(code = 404, message = "Categoria não encontrada", response = Problem.class)
	})
	CategoriaDTO atualizar(
			@ApiParam(value = "ID de uma categoria", example = "1", required = true)
			Long categoriaId,
			
			@ApiParam(name = "corpo", value = "Representação de uma categoria com os novos dados", 
				required = true)
			CategoriaDTO categoriaDTO);
	
	@ApiOperation("Exclui uma categoria por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Categoria excluída"),
		@ApiResponse(code = 404, message = "Categoria não encontrada", response = Problem.class)
	})
	void remover(
			@ApiParam(value = "ID de uma categoria", example = "1", required = true)
			Long categoriaId);
	
}
