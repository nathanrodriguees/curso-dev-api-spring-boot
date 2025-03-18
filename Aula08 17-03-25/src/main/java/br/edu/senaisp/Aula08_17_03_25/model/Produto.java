package br.edu.senaisp.Aula08_17_03_25.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	
	private Long id;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 1, max = 120)
	private String nome;
	private float preco;
}
