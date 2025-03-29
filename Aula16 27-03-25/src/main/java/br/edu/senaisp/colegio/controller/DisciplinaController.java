package br.edu.senaisp.colegio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.service.DisciplinaService;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
	@Autowired
	private DisciplinaService disciplinaService;

	@PostMapping
	public ResponseEntity<?> gravarDisciplina(@RequestBody Disciplina d) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.gravar(d));

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> buscarTodos() {
		List<Disciplina> lista = 
				disciplinaService
				.buscarTodos();
		if (lista.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(
			@PathVariable Long id) {

		Optional<Disciplina> opt =	disciplinaService.buscarPorId(id);
		if (opt.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(opt.get());
	}	
	
}
