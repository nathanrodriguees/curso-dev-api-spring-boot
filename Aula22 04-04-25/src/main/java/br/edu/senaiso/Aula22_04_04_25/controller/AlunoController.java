package br.edu.senaiso.Aula22_04_04_25.controller;

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

import br.edu.senaiso.Aula22_04_04_25.model.Aluno;
import br.edu.senaiso.Aula22_04_04_25.service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public ResponseEntity buscarTodos() {
		return ResponseEntity.ok(alunoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		Aluno a = alunoService.buscarPorId(id);
		if (a == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(a);

	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Aluno aluno) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.inserirAluno(aluno));
//			return ResponseEntity.ok(alunoService.inserirAluno(aluno));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity alterar(@PathVariable Long id, @RequestBody Aluno aluno) {

//		try {
//			Aluno a = alunoService.alterarPorId(id, aluno);
//			return ResponseEntity.ok(aluno);
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}

		aluno = alunoService.alterarPorId(id, aluno);
		if (aluno == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluirPorId(@PathVariable Long id) {
		try {
			Aluno a = alunoService.excluirPorId(id);
			if (a == null)
				return ResponseEntity.notFound().build();
			else
				return ResponseEntity.ok(a);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
