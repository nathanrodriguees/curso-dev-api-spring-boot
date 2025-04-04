package br.edu.senaisp.Aula21_03_04_25.exception;

public class RecursoNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoNotFound(String message) {
		super(message);
	}

}