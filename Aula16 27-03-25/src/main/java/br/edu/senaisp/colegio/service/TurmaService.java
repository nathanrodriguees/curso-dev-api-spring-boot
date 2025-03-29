package br.edu.senaisp.colegio.service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.repository.AlunoRepository;
import br.edu.senaisp.colegio.repository.TurmaRepository;
import jakarta.transaction.Transactional;

@Service
public class TurmaService {
	
	@Autowired
	TurmaRepository repoTurma;
	
	@Autowired
	AlunoRepository repoAluno;
	
	public List<Turma> buscarTodos(){
		return repoTurma.findAll();
	}
	
	public Turma buscarPorId(Long id) {
		
		Optional<Turma> op = repoTurma.findById(id);
		
		return op.orElse(null);
	}

	public Turma gravarTurma(Turma t){
		
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
	      }
	      else
	    	  return null;
	}
	
	

}
