package br.edu.senaisp.Aula26_10_04_25.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula26_10_04_25.model.Aluno;
import br.edu.senaisp.Aula26_10_04_25.model.Professor;
import br.edu.senaisp.Aula26_10_04_25.model.Turma;
import br.edu.senaisp.Aula26_10_04_25.repository.AlunoRepository;
import br.edu.senaisp.Aula26_10_04_25.repository.ProfessorRepository;
import br.edu.senaisp.Aula26_10_04_25.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository repoTurma;

	@Autowired
	AlunoRepository repoAluno;

	@Autowired
	ProfessorRepository repoProfessor;

	public List<Turma> buscarTodos() {
		return repoTurma.findAll();
	}

	public Turma buscarPorId(Long id) {

		Optional<Turma> op = repoTurma.findById(id);

		return op.orElseThrow(() -> new RuntimeException("Só pra Testar"));
	}

	public Turma gravarTurma(Turma t) {

		Set<Professor> lista = new HashSet<>();
		for (Professor p : t.getProfessores()) {
			Professor prof = repoProfessor.findById(p.getId()).orElse(null);
			if (prof != null) {
				System.err.println(prof.getId());
				lista.add(prof);
			}
		}

		t.setProfessores(lista);

		Turma tmp = repoTurma.save(t);
		List<Aluno> alunos = new ArrayList<Aluno>();
		for (Aluno a : t.getAlunos()) {
			a.setTurma(tmp);
			alunos.add(a);
		}
		alunos = repoAluno.saveAll(alunos);
		tmp.setAlunos(alunos);

		return tmp;

	}

	public Turma excluirPorId(Long id) {
		try {
			Turma t = buscarPorId(id);
			if (t != null) {
				repoTurma.deleteById(id);
				return t;
			}

		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}

		return null;
	}

	public Turma alterarPorId(Long id, Turma turma) {
		Optional<Turma> op = repoTurma.findById(id);

		if (op.isPresent()) {
			turma.setId(id);
			return repoTurma.save(turma);
		} else
			return null;
	}

}
