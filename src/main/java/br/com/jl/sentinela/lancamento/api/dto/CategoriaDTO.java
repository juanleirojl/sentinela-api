package br.com.jl.sentinela.lancamento.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.RepresentationModel;

import br.com.jl.sentinela.lancamento.domain.model.Categoria;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO extends RepresentationModel<CategoriaDTO> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@NotBlank
	@ApiModelProperty(example = "Moradia")
	private String nome;
	
	
	@NotBlank
	@ApiModelProperty(example = "Conta de Luz")
	private ContaDTO tipoCategoria;
	
	
	public static CategoriaDTO toModel(Categoria categoria) {
		return CategoriaDTO.builder()
				.id(categoria.getId())
				.nome(categoria.getNome())
				//.tipoCategoria(ContaDTO.toModel(categoria.getTipoCategoria()))
				.build();
	}
	
	public static Categoria toEntity(CategoriaDTO categoriaDTO) {
		return Categoria.builder()
				.id(categoriaDTO.getId())
				.nome(categoriaDTO.getNome())
				///.tipoCategoria(ContaDTO.toEntity(categoriaDTO.getTipoCategoria()))
				.build();
	}

}
