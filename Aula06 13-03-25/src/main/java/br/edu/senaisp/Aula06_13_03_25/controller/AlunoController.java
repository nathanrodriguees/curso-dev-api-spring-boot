package br.edu.senaisp.Aula06_13_03_25.controller;

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

import br.edu.senaisp.Aula06_13_03_25.model.Aluno;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

	@GetMapping
	public String buscarTodos() {
		return "Hello World";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarId(@PathVariable Long id) {
		Aluno a = new Aluno();
		a.setId(id);
		a.setNome("Nathan");
		a.setCpf("111.111.111-11");

		return new ResponseEntity<Aluno>(a, HttpStatus.OK);
//		return ResponseEntity.ok(a);
	}

	@PostMapping
	public Aluno insertAluno(@RequestBody Aluno a) {
		return a;
	}

	@PutMapping
	public void alteraAluno(String nome) {
		System.out.println("Altera: " + nome);
	}

	@DeleteMapping
	public void deleteAluno(@RequestBody String nome) {
		System.out.println("Delete: " + nome);
	}
}
