package br.edu.senaisp.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.model.dto.AlunoDTO;
import br.edu.senaisp.colegio.service.AlunoService;
import br.edu.senaisp.colegio.service.TurmaService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService; 
	
	@GetMapping
	public ResponseEntity buscarTodos() {
		return ResponseEntity.ok(
					alunoService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(
			@PathVariable Long id) {
		Aluno a = alunoService.buscarPorId(id);
		if (a == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.
					status(HttpStatus.OK).body(a);
	} 
	
	@PostMapping
	public ResponseEntity inserir(
			@RequestBody Aluno a) {
		
		try {
			return ResponseEntity.ok(
					alunoService.gravarAluno(a)
					);
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity alterar(
			@PathVariable Long id,
			@RequestBody Aluno a
			) {
		
		a = alunoService.alterarAluno(a, id);

		if (a == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.
					status(HttpStatus.OK).body(a);
 
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(
			@PathVariable Long id) {
		try {
			Aluno a = alunoService.excluirPorId(id);
			
			if (a == null)
				return ResponseEntity.notFound().build();
			else
				return ResponseEntity.ok(a);			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}		
	
	

}
