package br.edu.senaisp.Aula08_17_03_25.model;

import jakarta.validation.constraints.Pattern;

public class Validation {
	public static void main(String[] args) {
		
		@Pattern(regexp = "$1.$2.$3-$4") String cpf;
		
	}

	
}
