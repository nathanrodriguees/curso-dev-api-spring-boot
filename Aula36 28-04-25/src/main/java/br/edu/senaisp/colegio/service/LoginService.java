package br.edu.senaisp.colegio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.repository.UsuarioRepository;

@Service
public class LoginService implements UserDetailsService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRepository.findByLogin(username).orElseThrow(
				()-> new UsernameNotFoundException("Usuário não encontrado!"));
	}
	
	public String validaroken(String token) {
		
	}

}
