package br.edu.senaisp.Revisao;

import javax.sound.midi.SysexMessage;

public class Variaveis {

	public static void main(String[] args) {
		byte pequenininho = 127;

		short pequeno = 127;
		int medio = 127;
		long muitoGrande = 127;

		float grande1 = 1.5F;
		double muitoGrande1 = 1.5;

		Byte pp = 127;
		Short p = 127;
		Integer m = 127;
		Long mg = (long) 127;

		Float f = (float) 127.5;
		Double d = 127.5;

		float preco = Float.parseFloat("99.9999");
		double dddd = Double.parseDouble("8.96");

		String nome = "Bittencourt";
		char[] vetorNome = nome.toCharArray();

		String boleano = String.valueOf(true);
		String numero = String.valueOf(15.25);

		String idade1 = "25";
		String idade2 = "30";
		String idade3 = "45";

		String soma = idade1 + idade2 + idade3;
		System.err.println(soma);

		int id1 = Integer.parseInt(idade1);
		int id2 = Integer.parseInt(idade2);
		int id3 = Integer.parseInt(idade3);
		int somatorio = id1 + id2 + id3;
		System.out.println(somatorio);

	}
}