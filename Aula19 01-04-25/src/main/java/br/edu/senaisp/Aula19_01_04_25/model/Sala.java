package br.edu.senaisp.Aula19_01_04_25.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Sala {
	
	private String nr;
	private String predio;

}
