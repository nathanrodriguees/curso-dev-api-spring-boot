package br.edu.senaisp.Interface.model;

public class MotorE implements IMotor {

	private String fabricante;
	private int potencia;

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(int pontencia) {
		this.potencia = pontencia;
	}

	@Override
	public int acelera() {
		return (potencia = potencia * 3);
	}

}