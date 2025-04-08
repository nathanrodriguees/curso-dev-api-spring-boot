package br.edu.senaisp.Aula23_08_04_25.exception;

public class RecursoNotFound extends
					RuntimeException {
	private static final long serialVersionUID = 1L;

	public RecursoNotFound(String mensagem) {
		super(mensagem);
	}

}
