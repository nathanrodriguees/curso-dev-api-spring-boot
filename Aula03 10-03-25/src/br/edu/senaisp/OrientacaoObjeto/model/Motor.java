package br.edu.senaisp.OrientacaoObjeto.model;

public class Motor {
	private String nrSerie;
	private String fabricante;
	private int potencia;

	public Motor(String nrSerie, String fabricante, int potencia) {
		this.nrSerie = nrSerie;
		this.fabricante = fabricante;
		this.potencia = potencia;
	}

	public String getNrSerie() {
		return nrSerie;
	}

	public void setNrSerie(String nrSerie) {
		this.nrSerie = nrSerie;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

}
