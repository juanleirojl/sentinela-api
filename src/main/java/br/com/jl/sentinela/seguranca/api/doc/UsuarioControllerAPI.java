package br.com.jl.sentinela.seguranca.api.doc;

import br.com.jl.sentinela.seguranca.api.dto.UsuarioDTO;
import br.com.jl.sentinela.seguranca.domain.model.Usuario;
import io.swagger.annotations.*;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@Api(tags = "Usuario")
public interface UsuarioControllerAPI {
	
	@ApiOperation("Lista as usuarios com paginação")
	Page<UsuarioDTO> listar(Pageable pageable);
	
	@ApiOperation("Busca uma usuario por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID da usuario inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Usuario não encontrada", response = Problem.class)
	})
    UsuarioDTO buscar(@ApiParam(value = "ID de uma usuario", example = "1", required = true)	Long usuarioId);
	
	@ApiOperation("Cadastra uma usuario")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Usuario cadastrada"),
	})
    UsuarioDTO adicionar(
			@ApiParam(name = "corpo", value = "Representação de uma nova usuario", required = true)
                    UsuarioDTO usuarioDTO);
	
	@ApiOperation("Atualiza uma usuario por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Usuario atualizada"),
		@ApiResponse(code = 404, message = "Usuario não encontrada", response = Problem.class)
	})
	ResponseEntity<Usuario> atualizar(
			@ApiParam(value = "ID de uma usuario", example = "1", required = true)
			Long usuarioId,
			
			@ApiParam(name = "corpo", value = "Representação de uma usuario com os novos dados", 
				required = true)
                    UsuarioDTO usuarioDTO);
	
	@ApiOperation("Exclui uma usuario por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Usuario excluída"),
		@ApiResponse(code = 404, message = "Usuario não encontrada", response = Problem.class)
	})
	ResponseEntity<Object> remover(
			@ApiParam(value = "ID de uma usuario", example = "1", required = true)
			Long usuarioId);
	
}
