package br.edu.senaisp.colegio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.colegio.model.Usuario;

@Repository
public interface UsuarioRepository 
				extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByLogin(String login);
	
	boolean existsByLogin(String login);
	
	

}
