package br.edu.senaisp.colegio.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.model.dto.ITurmaListaDTO;
import br.edu.senaisp.colegio.repository.TurmaRepository;
import br.edu.senaisp.colegio.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private TurmaRepository repoTurma;

	@GetMapping("/paginacao")
	public List<Turma> testeJPA_Paginacao(@RequestParam int pag, @RequestParam int qtd) {

		return repoTurma.findAll(PageRequest.of(pag, qtd)).toList();

	}

	@GetMapping("/jpa")
	public String testeJPA() {
		List<Turma> lista = new ArrayList<Turma>();

		// List<Turma> t = repoTurma.findByNome("Font-End com React");

		// long qtd = repoTurma.count();

		// long qtd = repoTurma.countByNome("Font-End com React");
		// System.err.println(qtd);

		// List<Turma> lista = repoTurma.findByNomeNotContains("Font");

		// Optional<Turma> op = repoTurma.findFirstByNome("Font-End com React");

		// System.out.println(op.orElse(null).getNome());

		// lista = repoTurma.findByNomeAndId("Font-End com React", 15L);
		// lista = repoTurma.findByNomeContainsIgnoreCase("end");

		// Page<Turma> lista2 = repoTurma.findAll(PageRequest.of(1, 2));

//		lista = repoTurma.findByNomeNotContainsOrderByNome("z");

//		lista = repoTurma.buscarPorNomeLikeSQL("com");

//		List<TurmaListaSimplesDTO> listaDTO = repoTurma.buscarListaCombo("Font-End com React");

//		for (TurmaListaSimplesDTO t : listaDTO) {
//			System.err.println(t.getNome() + t.getId());
//		}
//
//		for (Turma turma : lista) {
//			System.err.println(turma.getNome());
//		}

		List<ITurmaListaDTO> listaDTO = repoTurma.buscarListaComboI("Font-End com React");

		for (ITurmaListaDTO t : listaDTO) {
			System.err.println(t.getNome() + t.getId());
		}

		return "Foi!";
	}

	@GetMapping
	public ResponseEntity<List<Turma>> buscarTodos() {
		return ResponseEntity.ok(turmaService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) throws IOException {
		Turma t = turmaService.buscarPorId(id);

		return ResponseEntity.ok(t);
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody Turma turma) {

		try {
			Turma t = turmaService.gravarTurma(turma);
			return ResponseEntity.ok(t);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity alterar(@PathVariable Long id, @RequestBody Turma turma) {

		try {
			Turma t = turmaService.alterarPorId(id, turma);
			return ResponseEntity.ok(t);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluirPorId(@PathVariable Long id) {
		try {
			Turma t = turmaService.excluirPorId(id);

			if (t == null)
				return ResponseEntity.notFound().build();
			else
				return ResponseEntity.ok(t);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
