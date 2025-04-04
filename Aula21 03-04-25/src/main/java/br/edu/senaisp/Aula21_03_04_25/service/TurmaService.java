package br.edu.senaisp.Aula21_03_04_25.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula21_03_04_25.model.Aluno;
import br.edu.senaisp.Aula21_03_04_25.model.Professor;
import br.edu.senaisp.Aula21_03_04_25.model.Turma;
import br.edu.senaisp.Aula21_03_04_25.repository.AlunoRepository;
import br.edu.senaisp.Aula21_03_04_25.repository.ProfessorRepository;
import br.edu.senaisp.Aula21_03_04_25.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	public List<Turma> buscarTodos() {
		return turmaRepository.findAll();

	}

	public Turma buscarPorId(Long id) {

		Optional<Turma> op = turmaRepository.findById(id);

//		return op.orElse(null);

		return op.orElseThrow(() -> new RuntimeException("Turma não encontrada"));

	}

	public Turma gravarTurma(Turma turma) {
		Set<Professor> professores = new HashSet<>();

		for (Professor p : turma.getProfessores()) {
			Professor prof = professorRepository.findById(p.getId()).orElse(null);

			if (prof != null)
				professores.add(prof);
		}

		turma.setProfessores(professores);

		Turma tmp = turmaRepository.save(turma);

		List<Aluno> alunos = new ArrayList<Aluno>();

		for (Aluno a : turma.getAlunos()) {
			a.setTurma(tmp);
		}

		alunos = alunoRepository.saveAll(alunos);
		tmp.setAlunos(alunos);

		return tmp;
	}

	public Turma alterarPorId(Long id, Turma turma) {
		Optional<Turma> op = turmaRepository.findById(id);

//		op.orElseThrow(()-> new RuntimeException("Usuário não existe"));

		if (op.isPresent()) {
			turma.setId(id);
			return turmaRepository.save(turma);
		} else
			return null;

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
