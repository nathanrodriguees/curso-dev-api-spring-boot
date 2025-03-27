package br.edu.senaisp.Aula15_26_03_25.controller;

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

import br.edu.senaisp.Aula15_26_03_25.model.Disciplina;
import br.edu.senaisp.Aula15_26_03_25.service.DisciplinaService;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;

	@GetMapping
	public ResponseEntity buscarTodos() {
		return ResponseEntity.ok(disciplinaService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		Disciplina d = disciplinaService.buscarPorId(id);
		if (d == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(d);
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Disciplina disciplina) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.inserirDisciplina(disciplina));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity alterar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
		disciplina = disciplinaService.alterarPorId(id, disciplina);
		if (disciplina == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.status(HttpStatus.OK).body(disciplina);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluirPorId(@PathVariable Long id) {
		try {
			Disciplina d = disciplinaService.excluirPorId(id);
			if (d == null)
				return ResponseEntity.notFound().build();
			else
				return ResponseEntity.ok(d);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
