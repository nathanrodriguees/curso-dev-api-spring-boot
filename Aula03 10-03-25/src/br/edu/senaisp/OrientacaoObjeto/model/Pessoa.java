package br.edu.senaisp.OrientacaoObjeto.model;

public abstract class Pessoa {
	private String nome;
	private String cpf;

	public abstract void tomarCafe();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Pessoa))
			return false;

		Pessoa tmp = (Pessoa) obj;
		return (cpf.equals(tmp.cpf));
	}
}
