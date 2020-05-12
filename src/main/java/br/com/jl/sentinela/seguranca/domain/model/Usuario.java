package br.com.jl.sentinela.seguranca.domain.model;

import br.com.jl.sentinela.seguranca.api.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	@Size(min = 3, max = 20)
	private String nome;

	@Email
	private String email;

	@NotBlank
	@Column(nullable = false)
	@Size(min = 3, max = 20)
	private String senha;

	@NotNull
	private Boolean ativo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime dataCriacao;


	public static Usuario toEntity(@Valid UsuarioDTO usuarioDTO) {
		return Usuario.builder()
				.id(usuarioDTO.getId())
				.nome(usuarioDTO.getNome())
				.email(usuarioDTO.getEmail())
				.senha(usuarioDTO.getSenha())
				.ativo(usuarioDTO.getAtivo())
				.dataCriacao(usuarioDTO.getDataCriacao()!=null ? usuarioDTO.getDataCriacao() : LocalDateTime.now() )
				.build();
	}
}
