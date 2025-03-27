package br.edu.senaisp.Aula15_26_03_25.model;

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
