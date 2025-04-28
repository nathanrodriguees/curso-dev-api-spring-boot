package br.edu.senaisp.colegio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "{usuario.login.notblank}")
	@Column(unique = true, nullable = false)
	private String login;

	@NotBlank
	@Size(min = 6)
	private String senha;

	@Enumerated(EnumType.STRING)
	private EPerfil perfil;
	
	@Enumerated(EnumType.STRING)
	private EStatus status;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public EPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(EPerfil perfil) {
		this.perfil = perfil;
	}

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	
	
}
