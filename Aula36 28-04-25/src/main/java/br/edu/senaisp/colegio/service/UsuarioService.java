package br.edu.senaisp.colegio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Usuario;
import br.edu.senaisp.colegio.model.dto.UsuarioSaidaDTO;
import br.edu.senaisp.colegio.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repo;

	@Autowired
	PasswordEncoder cripto;

	public Usuario gravar(Usuario u) {
		if (repo.existsByLogin(u.getLogin()))
			throw new RuntimeException("Login já Existe!");

		try {
			u.setSenha(cripto.encode(u.getSenha()));
			return repo.save(u);
		} catch (Exception e) {
			throw new RuntimeException("Erro nos valores enviados para usuário!");
		}
	}

	public Usuario alterar(Long id, Usuario u) {

		try {
			if (id == null)
				throw new RuntimeException("Id não pode ser nulo!");

			if (u == null)
				throw new RuntimeException("Erro nos valores enviados para usuário!");

			if (repo.findById(id).isEmpty())
				throw new RuntimeException("Usuário Inexistente!");

			u.setId(id);
			u.setSenha(cripto.encode(u.getSenha()));
			return repo.save(u);
		} catch (Exception e) {
			throw new RuntimeException("Erro:" + e.getMessage());
		}
	}

	public Usuario buscarPorId(Long id) {
		if (id == null)
			throw new RuntimeException("Id não pode ser nulo!");

		return repo.findById(id).orElseThrow(() -> new RuntimeException("Usuário Inexistente!"));
	}

	public List<UsuarioSaidaDTO> buscarTodos(Pageable pageable) {
		List<Usuario> lista = repo.findAll(pageable).toList();

		List<UsuarioSaidaDTO> lstDTO = new ArrayList<>();

		for (Usuario usuario : lista) {
			lstDTO.add(new UsuarioSaidaDTO(usuario.getLogin(), usuario.getPerfil(), usuario.getStatus()));
		}

		return lstDTO;
	}

	public void excluirPorId(Long id) {
		if (id == null)
			throw new RuntimeException("Id não pode ser nulo!");

		if (!repo.existsById(id))
			throw new RuntimeException("Usuário Inexistente!");

		repo.deleteById(id);

		if (repo.existsById(id))
			throw new RuntimeException("Não foi possível " + "excluir o usuário!");

	}

}
