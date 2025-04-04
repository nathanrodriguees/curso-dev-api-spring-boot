package br.edu.senaisp.Aula21_03_04_25.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula21_03_04_25.exception.RecursoNotFound;
import br.edu.senaisp.Aula21_03_04_25.model.Aluno;
import br.edu.senaisp.Aula21_03_04_25.repository.AlunoRepository;
import br.edu.senaisp.Aula21_03_04_25.repository.TurmaRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private TurmaService turmaService;

	public List<Aluno> buscarTodos() {
		return alunoRepository.findAll();
	}

	public Aluno buscarPorId(Long id) {
		Optional<Aluno> op = alunoRepository.findById(id);
		return op.orElseThrow(() -> new RecursoNotFound("Aluno não Encontrado!"));
	}

	public Aluno inserirAluno(Aluno aluno) {

		try {
			return alunoRepository.save(aluno);
		} catch (Exception e) {
			throw new RuntimeException("Não foio possivel inserir o aluno");
		}

	}

	public Aluno alterarPorId(Long id, Aluno aluno) {
		Optional<Aluno> op = alunoRepository.findById(id);

		if (op.isPresent()) {
			aluno.setId(id);
			return alunoRepository.save(aluno);
		} else
			return null;
	}

	public Aluno excluirPorId(Long id) {

		try {
			Aluno a = buscarPorId(id);
			if (a != null) {
				alunoRepository.deleteById(id);
				return a;
			}
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}

		return null;

	}
}