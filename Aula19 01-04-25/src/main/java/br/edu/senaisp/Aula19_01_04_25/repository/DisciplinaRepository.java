package br.edu.senaisp.Aula19_01_04_25.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.senaisp.Aula19_01_04_25.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
