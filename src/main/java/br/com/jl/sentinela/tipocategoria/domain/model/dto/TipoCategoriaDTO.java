package br.com.jl.sentinela.tipocategoria.domain.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.RepresentationModel;

import br.com.jl.sentinela.tipocategoria.domain.model.TipoCategoria;
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
public class TipoCategoriaDTO extends RepresentationModel<TipoCategoriaDTO> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@NotBlank
	@ApiModelProperty(example = "Moradia")
	private String nome;
	
	
	public static TipoCategoriaDTO toModel(TipoCategoria tipoCategoria) {
		return TipoCategoriaDTO.builder()
				.id(tipoCategoria.getId())
				.nome(tipoCategoria.getNome())
				.build();
	}
	
	public static TipoCategoria toEntity(TipoCategoriaDTO tipoCategoriaDTO) {
		return TipoCategoria.builder()
				.id(tipoCategoriaDTO.getId())
				.nome(tipoCategoriaDTO.getNome())
				.build();
	}

}
