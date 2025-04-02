package br.edu.senaisp.Aula19_01_04_25.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Aula19_01_04_25.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
