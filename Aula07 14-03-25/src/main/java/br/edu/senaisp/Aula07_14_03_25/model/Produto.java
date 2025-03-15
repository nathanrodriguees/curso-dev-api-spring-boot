package br.edu.senaisp.Aula07_14_03_25.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
	private Long id;
	private String nome;
	private float preco;
}
