package br.edu.senaisp.Aula18_31_03_25.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Aula18_31_03_25.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
