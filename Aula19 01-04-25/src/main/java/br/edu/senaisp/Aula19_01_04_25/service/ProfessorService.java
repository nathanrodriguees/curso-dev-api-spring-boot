package br.edu.senaisp.Aula19_01_04_25.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula19_01_04_25.model.Professor;
import br.edu.senaisp.Aula19_01_04_25.model.Turma;
import br.edu.senaisp.Aula19_01_04_25.repository.ProfessorRepository;
import br.edu.senaisp.Aula19_01_04_25.repository.TurmaRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	@Autowired
	TurmaRepository turmaRepository;

	public Professor gravar(Professor professor) {

		try {
			Set<Turma> turmas = new HashSet<>();

			for (Turma t : professor.getTurmas()) {
				t = turmaRepository.findById(t.getId()).orElse(null);

				if (t != null)
					turmas.add(t);
			}

			professor.setTurmas(turmas);
			return professorRepository.save(professor);

		} catch (Exception e) {
			throw new RuntimeException("Não foi possível incluir o Professor" + e.getMessage());
		}

	}

	public List<Professor> buscarTodos() {
		return professorRepository.findAll();
	}

	public Professor buscarPorId(Long id) {
		return professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
	}

	public Professor excluir(Long id) {
		Professor tmp = buscarPorId(id);
		if (tmp != null)
			professorRepository.deleteById(id);

		if (buscarPorId(id) == null)
			return tmp;
		else
			throw new RuntimeException();
	}

}
