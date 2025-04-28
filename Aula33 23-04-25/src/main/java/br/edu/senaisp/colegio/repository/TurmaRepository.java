package br.edu.senaisp.colegio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.model.dto.ITurmaListaDTO;
import br.edu.senaisp.colegio.model.dto.TurmaListaSimplesDTO;

@Repository
public interface TurmaRepository
           extends JpaRepository<Turma, Long>{
	//https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods.at-query
	
	//1. Derived Query Methods
	List<Turma> findByNome(String nome);
	long countByNome(String nome);
	List<Turma> findByNomeContains(String nome);
	List<Turma> findByNomeNotContains(String nome, Pageable pageable);
	List<Turma> findByNomeNotContains(String nome, Sort sort);
	Optional<Turma> findFirstByNome(String nome);
	Optional<Turma> findLastByNome(String nome);
	List<Turma> findByNomeAndId(String nome, Long id);
	boolean existsByNome(String nome);
	List<Turma> findByNomeContainsIgnoreCase(String nome);
	List<Turma> findByNomeNotContainsOrderByNomeDesc(String nome);
	List<Turma> findByNomeNotContainsOrderByNome(String nome);
	
	//Page<Turma> findAll(Pageable pageable);
	
	@Query(value="SELECT t FROM Turma t WHERE UPPER(t.nome) "
			+ "LIKE UPPER(%:nome%)")
	List<Turma> buscarPorNomeLike(String texto);
	
	
	@Query(value="SELECT * FROM turma t WHERE "
			+ "ucase(t.nome) "
			+ "LIKE ucase(CONCAT('%',:nome,'%'))",
			nativeQuery=true)
	List<Turma> buscarPorNomeLikeSQL(@Param("nome") String texto);
	
	@Query(value=
	"SELECT new br.edu.senaisp.colegio.model.dto."
	+ "TurmaListaSimplesDTO(t.id, t.nome)"
	+ " FROM Turma t"
	+ " WHERE t.nome = :nome")
	List<TurmaListaSimplesDTO> buscarListaCombo(
					@Param("nome") String texto);
	
	@Query(value=
	"SELECT id as id, nome as nome "
	+ " FROM Turma t"
	+ " WHERE t.nome = :nome")
	List<ITurmaListaDTO> buscarListaComboI(
					@Param("nome") String texto);	

}
