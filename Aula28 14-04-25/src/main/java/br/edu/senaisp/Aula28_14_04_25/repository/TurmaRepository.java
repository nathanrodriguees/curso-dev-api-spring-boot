package br.edu.senaisp.Aula28_14_04_25.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Aula28_14_04_25.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

	// 1. Derived Query Methods
	List<Turma> findByNome(String nome);

	List<Turma> findByNomeContains(String nome);

	long countByNome(String nome);

	List<Turma> findByNomeNotContains(String nome);
}
