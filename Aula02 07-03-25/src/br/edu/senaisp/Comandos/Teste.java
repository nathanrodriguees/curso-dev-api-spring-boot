package br.edu.senaisp.Comandos;

public class Teste {

	public static void main(String[] args) {

		// Decisão
		// Exclusiva
//		if(true) {
//			//Verdade
//		}
//		
//		if(boleana) {
//			//Verdadeiro
//		}else {
//			//Falso
//		}
//		//Aninhado
//		if(boleana) {
//			//Verdadeiro
//		}else {
//			//Falso
//			if(boleana) {
//				//Verdadeiro
//			}else {
//				//Falso
//			}
//		}		

		// Operador Ternário (Short If)
		String situacao = (5 > 7 ? "Ativo" : "Inativo");

		// Laços de Repetição
		int diaSemana = 12;
		switch (diaSemana) {
		case 1:
			System.err.println("Domingo");
			break;
		case 2:
			System.err.println("Segunda-Feira");
			break;
		default:
			System.out.println("Inexistente");
		}

		for (int x = 0; x < 3; x = x + 1) {
			System.out.println(x);
		}

		int x = 7;
		while (x < 3) {
			System.out.println(x);
			x = x + 1;
		}

		x = 7;
		do {
			System.out.println(x);
			x = x + 1;
		} while (x < 3);

		String[] vetor = { "Laranja", "Pitaya", "Lichia" };
		for (String f : vetor) {
			System.out.println(f);
		}

		// Vetores / Arrays
		float[][][][] numeros = new float[5][5][5][5];
		numeros[2][1][0][3] = (float) 12.0;
		numeros[2][2][0][3] = (float) 12.0;

		String[] palavras = new String[5];
		palavras[0] = "Xaxa";
		palavras[1] = "Xexe";
		palavras[4] = "Xuxu";

	}

}