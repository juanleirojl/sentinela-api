package br.com.jl.sentinela.lancamento.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "idTipoCategoria")
//    @JsonBackReference
//    private Conta tipoCategoria;
}
