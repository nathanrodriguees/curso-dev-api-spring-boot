package br.edu.senaisp.Interface.model;

public class Motor implements IMotor {
	private String nrSerie;
	private String fabricante;
	private int potencia;

	public Motor(String nrSerie) {
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

	public String getNrSerie() {
		return nrSerie;
	}

	@Override
	public int acelera() {
		return (potencia = potencia * 2);
	}

}
