package br.edu.senaisp.Metodos;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in); 
		
		int a = teclado.nextInt();
		int b = teclado.nextInt();
		int c = teclado.nextInt();
		int j = teclado.nextInt();
		int resultado = somar(a, b);
		impressao( resultado  );
		impressao( somar(a, c)  );
		impressao( somar(j, c)  );
	}
	public static int somar(int n1, int n2){
		return n1 + n2;
	}
	public static void impressao(int valor) {
		System.err.println(valor);
	}
	
	
	

}
