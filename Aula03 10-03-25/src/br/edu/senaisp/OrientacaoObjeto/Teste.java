package br.edu.senaisp.OrientacaoObjeto;

import br.edu.senaisp.OrientacaoObjeto.model.Aluno;
import br.edu.senaisp.OrientacaoObjeto.model.Motor;
import br.edu.senaisp.OrientacaoObjeto.model.Professor;

public class Teste {

	public static void main(String[] args) {
		Motor v8 = new Motor("A2532Y-BR", "Mercedez", 600);
		System.out.println(v8.getNrSerie());

		Aluno a1 = new Aluno();
		a1.setNome("Francisco");
		a1.setCpf("111.111.111-11");

		Professor p1 = new Professor();
		p1.setNome("Bitt");
		p1.setCpf("222.222.222-22");
	}
}
