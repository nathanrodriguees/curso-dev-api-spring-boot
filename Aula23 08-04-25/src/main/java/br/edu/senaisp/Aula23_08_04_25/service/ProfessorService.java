package br.edu.senaisp.Aula23_08_04_25.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula23_08_04_25.model.Professor;
import br.edu.senaisp.Aula23_08_04_25.model.Turma;
import br.edu.senaisp.Aula23_08_04_25.repository.ProfessorRepository;
import br.edu.senaisp.Aula23_08_04_25.repository.TurmaRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository repo;

	@Autowired
	TurmaRepository repoTurma;

	public List<Professor> buscarTodos() {
		return repo.findAll();
	}

	public Professor buscarPorId(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public Professor gravar(Professor professor) {
		try {
			Set<Turma> turmas = new HashSet<>();

			for (Turma t : professor.getTurmas()) {
				t = repoTurma.findById(t.getId()).orElse(null);
				if (t != null)
					turmas.add(t);
			}
			professor.setTurmas(turmas);
			return repo.save(professor);

		} catch (Exception e) {
			throw new RuntimeException("Não foi possível incluir o Professor." + e.getMessage());
		}

	}
	// alterar
	// excluir

	public Professor excluir(Long id) {
		Professor tmp = buscarPorId(id);
		if (tmp != null)
			repo.deleteById(id);

		if (buscarPorId(id) == null)
			return tmp;
		else
			throw new RuntimeException();

	}

	public Object alterar(Long id, Professor p) {
		try {
			Set<Turma> turmas = new HashSet<>();
			for (Turma t : p.getTurmas()) {
				t = repoTurma.findById(t.getId()).orElse(null);
				if (t != null)
					turmas.add(t);
			}
			p.setId(id);
			p.setTurmas(turmas);
			return repo.save(p);

		} catch (Exception e) {
			throw new RuntimeException("Não foi possível incluir o Professor." + e.getMessage());
		}
	}

}
