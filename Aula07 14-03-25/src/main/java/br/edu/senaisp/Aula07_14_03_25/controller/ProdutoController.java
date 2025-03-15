package br.edu.senaisp.Aula07_14_03_25.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Aula07_14_03_25.model.Produto;
import br.edu.senaisp.Aula07_14_03_25.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	public ResponseEntity<Produto> insertProduto(@RequestBody Produto p) {

		try {
			produtoService.gravarProdutoTexto(p);
			return new ResponseEntity<Produto>(p, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Produto>(HttpStatus.BAD_REQUEST);
		}

	}
}
