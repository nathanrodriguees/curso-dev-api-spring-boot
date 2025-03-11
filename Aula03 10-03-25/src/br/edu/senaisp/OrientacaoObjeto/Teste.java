package br.edu.senaisp.OrientacaoObjeto;

import br.edu.senaisp.OrientacaoObjeto.model.Motor;

public class Teste {

	public static void main(String[] args) {

		Motor v8 = new Motor();
		v8.setNrSerie("A2532Y-BR");

		System.out.println(v8.getNrSerie());

	}
}
