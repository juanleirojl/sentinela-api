package br.com.jl.sentinela.lancamento.api.controller;

import br.com.jl.sentinela.core.message.Messages;
import br.com.jl.sentinela.api.ResourceUriHelper;
import br.com.jl.sentinela.lancamento.api.controller.doc.ContaControllerAPI;
import br.com.jl.sentinela.lancamento.api.dto.ContaDTO;
import br.com.jl.sentinela.api.exception.EntidadeNaoEncontradaException;
import br.com.jl.sentinela.lancamento.domain.model.Conta;
import br.com.jl.sentinela.lancamento.domain.repository.ContaRepository;
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
@RequestMapping("/api/v1/contas")
public class ContaController implements ContaControllerAPI {
	
	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private Messages messages;
	
	@Override
	@GetMapping(value="/listar")
	public Page<ContaDTO> listar(@PageableDefault(size = 10) Pageable pageable) {

		Page<ContaDTO> contas = contaRepository.findAll(pageable).map(ContaDTO::toModel);
		return contas;
	}

	@Override
	@GetMapping("/{id}")
	public ContaDTO buscar(@PathVariable Long id) {
		return contaRepository.findById(id).map(ContaDTO::toModel).orElseThrow(() -> new EntidadeNaoEncontradaException());
	}

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContaDTO adicionar(@RequestBody @Valid ContaDTO contaDTO) {
		Conta conta = Conta.toEntity(contaDTO);
		conta = contaRepository.save(conta);
		contaDTO = ContaDTO.toModel(conta);

		ResourceUriHelper.addUriInResponseHeader(contaDTO.getId());
		return contaDTO;
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Conta> atualizar(@PathVariable Long id, @RequestBody ContaDTO contaDTO) {
		 return contaRepository.findById(id).map(conta -> Conta.toEntity(contaDTO))
				.map(conta -> contaRepository.save(conta))
				.map(conta -> ResponseEntity.ok(conta)).orElseGet(()-> ResponseEntity.notFound().build());

	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> remover(@PathVariable Long id) {
		contaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
