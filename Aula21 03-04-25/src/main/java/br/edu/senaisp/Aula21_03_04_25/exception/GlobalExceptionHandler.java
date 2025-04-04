package br.edu.senaisp.Aula21_03_04_25.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecursoNotFound.class)
	public ResponseEntity<?> recursoNotFound(RecursoNotFound e, WebRequest request) {
		MensagemError msg = new MensagemError(LocalDateTime.now(), e.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> geralRuntimeException(RuntimeException e, WebRequest request) {
		System.err.println("AQUI 2");
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
