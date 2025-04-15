package br.edu.senaisp.Aula28_14_04_25.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO {

	private Long id;
	private String nome;
	private String email;
	private Long turma_id;

}
