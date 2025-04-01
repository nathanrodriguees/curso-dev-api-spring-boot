package br.edu.senaisp.Aula18_31_03_25.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Aula18_31_03_25.model.Professor;
import br.edu.senaisp.Aula18_31_03_25.service.ProfessorService;

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
}
