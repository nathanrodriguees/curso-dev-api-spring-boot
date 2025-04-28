package br.edu.senaisp.colegio.controller;

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
import org.springframework.web.client.RestClient.ResponseSpec;

import br.edu.senaisp.colegio.model.Professor;
import br.edu.senaisp.colegio.service.ProfessorService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/professor")
@Tag(name="Professor Controller", 
description = "Pacote de End-Points para manutenção "
		+ "de cadastro de Professores.")
public class ProfessorController {

	@Autowired
	ProfessorService professorService; 
	

	@Operation(summary = "Lista todos os Professores.",
			   description = "Retorna uma lista de dados dos professores.",
			   responses = {
				@ApiResponse(responseCode = "200"
						, description = "Sucesso"),
				@ApiResponse(responseCode = "400"
				, description = "Não Encontrado"),				
				@ApiResponse(responseCode = "500"
				, description = "Erro Interno")				
			   })
	@GetMapping()
	public ResponseEntity<?> buscarTodos(){
		
		try {
			return ResponseEntity
					.ok(professorService.buscarTodos());
		} catch (Exception e) {
			return ResponseEntity.status(
					HttpStatus.BAD_REQUEST)
						.body(e.getMessage());
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(
			@PathVariable Long id){
		
		try {
			return ResponseEntity
					.ok(professorService.buscarPorId(id));
		} catch (Exception e) {
			return ResponseEntity.status(
					HttpStatus.BAD_REQUEST)
						.body(e.getMessage());
		}
		
	}	
	
	@Hidden
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(
			@PathVariable Long id){
		
		try {
			return ResponseEntity
					.ok(professorService.excluir(id));
		} catch (Exception e) {
			return ResponseEntity.status(
					HttpStatus.BAD_REQUEST)
						.body(e.getMessage());
		}
		
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(
			
			@Parameter(description = "Id do Professor a ser alterado!")
			@PathVariable Long id,
			@io.swagger.v3.oas.annotations.parameters
			.RequestBody(description = "Passar o JSon do Professor")
			@RequestBody Professor p
			){
		
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(professorService.alterar(id, p));
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}		
		
	}
	
	@PostMapping
	public ResponseEntity<?> gravar(
			@RequestBody Professor p){
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(professorService.gravar(p));
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
		
	}
	
}
