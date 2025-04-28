package br.edu.senaisp.colegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.colegio.model.Usuario;
import br.edu.senaisp.colegio.model.dto.UsuarioSaidaDTO;
import br.edu.senaisp.colegio.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioSaidaDTO>> buscartodos(@RequestParam int pag, @RequestParam int qtd) {
		return ResponseEntity.ok(usuarioService.buscarTodos(PageRequest.of(pag, qtd)));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario u) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.gravar(u));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alterar(@PathVariable Long id, @RequestBody Usuario u) {
		System.out.println(u.getSenha());
		return ResponseEntity.ok(usuarioService.alterar(id, u));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> excluir(@PathVariable Long id) {
		usuarioService.excluirPorId(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
