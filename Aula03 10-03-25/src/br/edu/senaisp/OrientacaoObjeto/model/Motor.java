package br.edu.senaisp.OrientacaoObjeto.model;

public class Motor {
	private String nrSerie;
	private String fabricante;
	private int potencia;
	
	public Motor(String nrSerie) {
		this.nrSerie = nrSerie;
	}

	public String getNrSerie() {
		return "SN: " + nrSerie;
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
