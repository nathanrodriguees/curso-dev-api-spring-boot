package br.edu.senaisp.Aula10_19_03_25.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Aula10_19_03_25.model.Turma;
import br.edu.senaisp.Aula10_19_03_25.service.TurmaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@GetMapping
	public ResponseEntity<List<Turma>> buscarTodos() {
		return ResponseEntity.ok(turmaService.buscarTodos());
	}

	@PostMapping
	public ResponseEntity insert(@Valid @RequestBody Turma turma) {

		try {

			Turma t = turmaService.insertTurma(turma);
			return ResponseEntity.ok(t);

		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e.getMessage());

		}

	}
}
