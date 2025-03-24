package br.edu.senaisp.Aula12_21_03_25.controller;

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

import br.edu.senaisp.Aula12_21_03_25.model.Aluno;
import br.edu.senaisp.Aula12_21_03_25.service.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public ResponseEntity buscarTodos() {
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Aluno aluno) {
		try {
			return ResponseEntity.ok(alunoService.inserirAluno(aluno));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity alterar(@PathVariable Long id, @RequestBody Aluno aluno) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		return null;
	}
}
