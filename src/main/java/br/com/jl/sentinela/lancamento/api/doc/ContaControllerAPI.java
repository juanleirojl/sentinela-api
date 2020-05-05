package br.com.jl.sentinela.lancamento.api.doc;

import br.com.jl.sentinela.lancamento.api.dto.ContaDTO;
import br.com.jl.sentinela.lancamento.domain.model.Conta;
import io.swagger.annotations.*;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Api(tags = "Conta")
public interface ContaControllerAPI {
	
	@ApiOperation("Lista as contas com paginação")
	Page<ContaDTO> listar(Pageable pageable);
	
	@ApiOperation("Busca uma conta por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID da conta inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Conta não encontrada", response = Problem.class)
	})
    ContaDTO buscar(@ApiParam(value = "ID de uma conta", example = "1", required = true)	Long contaId);
	
	@ApiOperation("Cadastra uma conta")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Conta cadastrada"),
	})
    ContaDTO adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova conta", required = true)
                    ContaDTO contaDTO);
	
	@ApiOperation("Atualiza uma conta por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Conta atualizada"),
		@ApiResponse(code = 404, message = "Conta não encontrada", response = Problem.class)
	})
	ResponseEntity<Conta> atualizar(
			@ApiParam(value = "ID de uma conta", example = "1", required = true)
			Long contaId,
			
			@ApiParam(name = "corpo", value = "Representação de uma conta com os novos dados", 
				required = true)
                    ContaDTO contaDTO);
	
	@ApiOperation("Exclui uma conta por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Conta excluída"),
		@ApiResponse(code = 404, message = "Conta não encontrada", response = Problem.class)
	})
	ResponseEntity<Object> remover(
			@ApiParam(value = "ID de uma conta", example = "1", required = true)
			Long contaId);
	
}
