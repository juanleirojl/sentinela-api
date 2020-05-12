package br.com.jl.sentinela.lancamento.domain.model;

import br.com.jl.sentinela.lancamento.api.dto.ContaDTO;
import br.com.jl.sentinela.seguranca.domain.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false)
	@Size(min = 3, max = 20)
	private String nome;

	@PositiveOrZero
	@NotNull
	private BigDecimal limite;

	@NotNull
	private BigDecimal saldo;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dataCriacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	public static Conta toEntity(@Valid ContaDTO contaDTO) {
		return Conta.builder()
				.id(contaDTO.getId())
				.nome(contaDTO.getNome())
				.limite(contaDTO.getLimite())
				.saldo(contaDTO.getSaldo())
				.usuario(Usuario.toEntity(contaDTO.getUsuario()))
				.dataCriacao(contaDTO.getDataCriacao()!=null ? contaDTO.getDataCriacao() : LocalDateTime.now())
				.build();
	}


}
