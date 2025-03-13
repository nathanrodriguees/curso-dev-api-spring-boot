package br.edu.senaisp.Escola.Aula05_12_03_25.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

	@GetMapping
	public String buscarTodos() {
		return "Ola";
	}

	@GetMapping("/{id}")
	public String buscarId(@PathVariable int id) {
		return "Fulano" + id;
	}

	@PostMapping
	public void insertAluno() {

	}

}