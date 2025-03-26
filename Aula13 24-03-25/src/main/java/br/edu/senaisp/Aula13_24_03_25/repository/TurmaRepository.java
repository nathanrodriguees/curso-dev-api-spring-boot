package br.edu.senaisp.Aula13_24_03_25.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Aula13_24_03_25.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
