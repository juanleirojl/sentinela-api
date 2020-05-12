package br.com.jl.sentinela.seguranca.api;

import br.com.jl.sentinela.api.ResourceUriHelper;
import br.com.jl.sentinela.api.exception.EntidadeNaoEncontradaException;
import br.com.jl.sentinela.core.message.Messages;
import br.com.jl.sentinela.seguranca.api.doc.UsuarioControllerAPI;
import br.com.jl.sentinela.seguranca.api.dto.UsuarioDTO;
import br.com.jl.sentinela.seguranca.domain.model.Usuario;
import br.com.jl.sentinela.seguranca.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuarios")
public class UsuarioController implements UsuarioControllerAPI {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private Messages messages;
	
	@Override
	@GetMapping
	public Page<UsuarioDTO> listar(@PageableDefault(size = 10) Pageable pageable) {

		Page<UsuarioDTO> usuarios = usuarioRepository.findAll(pageable).map(UsuarioDTO::toModel);
		return usuarios;
	}

	@Override
	@GetMapping("/{id}")
	public UsuarioDTO buscar(@PathVariable Long id) {
		return usuarioRepository.findById(id).map(UsuarioDTO::toModel).orElseThrow(() -> new EntidadeNaoEncontradaException());
	}

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioDTO adicionar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		Usuario usuario = Usuario.toEntity(usuarioDTO);
		usuario = usuarioRepository.save(usuario);
		usuarioDTO = UsuarioDTO.toModel(usuario);

		ResourceUriHelper.addUriInResponseHeader(usuarioDTO.getId());
		return usuarioDTO;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
		 return usuarioRepository.findById(id).map(usuario -> Usuario.toEntity(usuarioDTO))
				.map(usuario -> usuarioRepository.save(usuario))
				.map(usuario -> ResponseEntity.ok(usuario)).orElseGet(()-> ResponseEntity.notFound().build());

	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> remover(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
