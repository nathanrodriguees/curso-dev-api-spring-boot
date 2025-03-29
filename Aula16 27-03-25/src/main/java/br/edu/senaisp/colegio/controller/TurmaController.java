package br.edu.senaisp.colegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.edu.senaisp.colegio.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService; 
	
	@GetMapping
	public ResponseEntity<List<Turma>> buscarTodos(){
		return 
		   ResponseEntity.ok(
				   turmaService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> 
				buscarPorId(@PathVariable Long id){
		Turma t = turmaService.buscarPorId(id);
		if (t == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(t);
	}
	
	@PostMapping
	public ResponseEntity inserir(
			@RequestBody Turma turma) {
		
		try {
		    Turma t = turmaService.gravarTurma(turma);
		    return ResponseEntity.ok(t);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity alterar(@PathVariable Long id, 
			@RequestBody Turma turma) {
		
		try {
			Turma t = turmaService.alterarPorId(id, turma);
		    return ResponseEntity.ok(t);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}

	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity excluirPorId(@PathVariable Long id) {
		try {
			Turma t = turmaService.excluirPorId(id);
			
			if (t == null)
				return ResponseEntity.notFound().build();
			else
				return ResponseEntity.ok(t);			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
		
		
		
	}
	

}
