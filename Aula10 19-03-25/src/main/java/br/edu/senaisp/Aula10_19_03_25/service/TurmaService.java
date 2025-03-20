package br.edu.senaisp.Aula10_19_03_25.service;

import java.util.List;
import java.util.Optional;

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

	public Turma buscarPorId(Long id) {

		Optional<Turma> op = turmaRepository.findById(id);

		return op.orElse(null);

		// return op.orElseThrow(()-> new RuntimeException());

	}

	public Turma insertTurma(Turma turma) {
		return turmaRepository.save(turma);
	}

	public Turma excluirPorId(Long id) {

		try {
			Turma t = buscarPorId(id);
			if (t != null) {
				turmaRepository.deleteById(id);
				return t;
			}
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}

		return null;

	}
}
