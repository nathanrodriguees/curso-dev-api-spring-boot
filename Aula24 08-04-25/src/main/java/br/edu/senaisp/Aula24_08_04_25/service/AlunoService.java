package br.edu.senaisp.Aula24_08_04_25.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula24_08_04_25.exception.RecursoNotFound;
import br.edu.senaisp.Aula24_08_04_25.model.Aluno;
import br.edu.senaisp.Aula24_08_04_25.repository.AlunoRepository;
import br.edu.senaisp.Aula24_08_04_25.repository.TurmaRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository repoAluno;

	@Autowired
	private TurmaRepository repoTurma;

	public Aluno gravarAluno(Aluno a) {
		try {
			return repoAluno.save(a);
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível inserir o aluno");
		}

	}

	public List<Aluno> buscarTodos() {
		return repoAluno.findAll();
	}

	public Aluno buscarPorId(Long id) {

		Optional<Aluno> op = repoAluno.findById(id);

		return op.orElseThrow(() -> new RecursoNotFound("XAXA"));
	}

	public Aluno alterarAluno(Aluno a, Long id) {

		Optional<Aluno> op = repoAluno.findById(id);

		if (op.isPresent()) {
			a.setId(id);
			return repoAluno.save(a);
		} else
			throw new RecursoNotFound("");

	}

	public Aluno excluirPorId(Long id) {
		try {
			Aluno a = buscarPorId(id);
			if (a != null) {
				repoAluno.deleteById(id);

				a = buscarPorId(id);
				if (a == null)
					return a;

				throw new RuntimeException("Não foi possível Excluir ");

			}

		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}

		return null;
	}

}
