package br.com.jl.sentinela.lancamento.api.dto;

import br.com.jl.sentinela.lancamento.domain.model.Conta;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(example = "1")
	private Long id;


	@ApiModelProperty(example = "Nubank")
	@NotBlank
	@Size(min = 3, max = 20)
	private String nome;

	@ApiModelProperty(example = "3000.00")
	private BigDecimal limite;

	@ApiModelProperty(example = "1000.00")
	private BigDecimal saldo;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dataCriacao;


	public static ContaDTO toModel(@Valid Conta conta) {
		return ContaDTO.builder()
				.id(conta.getId())
				.nome(conta.getNome())
				.limite(conta.getLimite())
				.saldo(conta.getSaldo())
				.dataCriacao(conta.getDataCriacao()!=null ? conta.getDataCriacao() : LocalDateTime.now() )
				.build();
	}

}
