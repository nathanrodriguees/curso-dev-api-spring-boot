package br.edu.senaisp.Aula15_26_03_25.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula15_26_03_25.model.Disciplina;
import br.edu.senaisp.Aula15_26_03_25.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	public List<Disciplina> buscarTodos() {
		return disciplinaRepository.findAll();

	}

	public Disciplina buscarPorId(Long id) {

		Optional<Disciplina> op = disciplinaRepository.findById(id);

		return op.orElse(null);
		// return op.orElseThrow(()-> new RuntimeException());

	}

	public Disciplina inserirDisciplina(Disciplina disciplina) {

		try {
			return disciplinaRepository.save(disciplina);
		} catch (Exception e) {
			throw new RuntimeException("Não foio possivel inserir a disciplina");
		}

	}

	public Disciplina alterarPorId(Long id, Disciplina disciplina) {
		Optional<Disciplina> op = disciplinaRepository.findById(id);

//		op.orElseThrow(()-> new RuntimeException("Disciplina não existe"));

		if (op.isPresent()) {
			disciplina.setId(id);
			return disciplinaRepository.save(disciplina);
		} else
			return null;
	}

	public Disciplina excluirPorId(Long id) {

		try {
			Disciplina d = buscarPorId(id);
			if (d != null) {
				disciplinaRepository.deleteById(id);
				return d;
			}
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}

		return null;

	}

}
