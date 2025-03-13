package br.edu.senaisp.Interface.model;

public class Carro {
	private IMotor motor;

	public Carro(IMotor motor) {
		this.motor = motor;
	}

	public int getVelocidade() {
		return motor.acelera();
	}

}
