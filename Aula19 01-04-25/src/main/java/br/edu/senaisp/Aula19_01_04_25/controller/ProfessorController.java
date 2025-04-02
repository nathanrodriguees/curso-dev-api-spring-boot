package br.edu.senaisp.Aula19_01_04_25.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Aula19_01_04_25.model.Professor;
import br.edu.senaisp.Aula19_01_04_25.service.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;

	@PostMapping
	public ResponseEntity<?> gravar(@RequestBody Professor p) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(professorService.gravar(p));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> buscarTodos() {
		try {
			return ResponseEntity.ok(professorService.buscarTodos());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(professorService.buscarPorId(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(professorService.excluir(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
