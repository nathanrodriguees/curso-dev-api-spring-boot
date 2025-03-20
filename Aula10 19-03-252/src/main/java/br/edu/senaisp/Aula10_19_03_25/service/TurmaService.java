package br.edu.senaisp.Aula10_19_03_25.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula10_19_03_25.model.Turma;
import br.edu.senaisp.Aula10_19_03_25.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	public List<Turma> buscarTodos() {
		return turmaRepository.findAll();

	}

	public Turma insertTurma(Turma turma) {
		return turmaRepository.save(turma);
	}
}
