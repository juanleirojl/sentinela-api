package br.com.jl.sentinela.seguranca.api.dto;

import br.com.jl.sentinela.seguranca.domain.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	@Size(min = 3, max = 20)
	private String nome;

	@Email
	private String email;

	@NotBlank
	@Size(min = 3, max = 20)
	private String senha;

	@NotNull
	private Boolean ativo;

	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private LocalDateTime dataCriacao;

	public static UsuarioDTO toModel(@Valid Usuario usuario) {
		return UsuarioDTO.builder()
				.id(usuario.getId())
				.nome(usuario.getNome())
				.email(usuario.getEmail())
				.senha(usuario.getSenha())
				.ativo(usuario.getAtivo())
				.dataCriacao(usuario.getDataCriacao()!=null ? usuario.getDataCriacao() : LocalDateTime.now() )
				.build();
	}
}
