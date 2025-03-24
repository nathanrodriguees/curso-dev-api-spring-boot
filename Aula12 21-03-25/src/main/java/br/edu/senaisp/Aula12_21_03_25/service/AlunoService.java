package br.edu.senaisp.Aula12_21_03_25.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.Aula12_21_03_25.model.Aluno;
import br.edu.senaisp.Aula12_21_03_25.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
//	public AlunoService(AlunoRepository r) {
//		AlunoRepository alunoRepository = r;
//	}

	public Aluno inserirAluno(Aluno aluno) {
		
		return alunoRepository.save(aluno);
	}

}
