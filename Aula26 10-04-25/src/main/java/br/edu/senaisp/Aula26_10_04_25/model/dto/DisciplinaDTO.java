package br.edu.senaisp.Aula26_10_04_25.model.dto;

import br.edu.senaisp.Aula26_10_04_25.model.Disciplina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DisciplinaDTO(Long id, @NotBlank String titulo, @Size(min = 1) int duracaoH) {

	public Disciplina toDisciplina() {
		Disciplina tmp = new Disciplina();
		tmp.setId(this.id);
		tmp.setTitulo(this.titulo);
		tmp.setDuracaoH(this.duracaoH);
		return tmp;
	}

}
