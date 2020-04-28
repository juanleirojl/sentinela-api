package br.com.jl.sentinela.lancamento.api.doc;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;

import br.com.jl.sentinela.lancamento.api.dto.TipoCategoriaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "TiposCategoria")
public interface TipoCategoriaControllerAPI {
	
	@ApiOperation("Lista as tipoCategorias com paginação")
	PagedModel<TipoCategoriaDTO> listar(Pageable pageable);
	
	@ApiOperation("Busca uma tipoCategoria por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID da tipoCategoria inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "TipoCategoria não encontrada", response = Problem.class)
	})
	TipoCategoriaDTO buscar(@ApiParam(value = "ID de uma tipoCategoria", example = "1", required = true)	Long tipoCategoriaId);
	
	@ApiOperation("Cadastra uma tipoCategoria")
	@ApiResponses({
		@ApiResponse(code = 201, message = "TipoCategoria cadastrada"),
	})
	TipoCategoriaDTO adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova tipoCategoria", required = true)
			TipoCategoriaDTO tipoCategoriaDTO);
	
	@ApiOperation("Atualiza uma tipoCategoria por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "TipoCategoria atualizada"),
		@ApiResponse(code = 404, message = "TipoCategoria não encontrada", response = Problem.class)
	})
	TipoCategoriaDTO atualizar(
			@ApiParam(value = "ID de uma tipoCategoria", example = "1", required = true)
			Long tipoCategoriaId,
			
			@ApiParam(name = "corpo", value = "Representação de uma tipoCategoria com os novos dados", 
				required = true)
			TipoCategoriaDTO tipoCategoriaDTO);
	
	@ApiOperation("Exclui uma tipoCategoria por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "TipoCategoria excluída"),
		@ApiResponse(code = 404, message = "TipoCategoria não encontrada", response = Problem.class)
	})
	void remover(
			@ApiParam(value = "ID de uma tipoCategoria", example = "1", required = true)
			Long tipoCategoriaId);
	
}
