package br.edu.senaisp.Aula25_09_04_25.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Aula25_09_04_25.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
