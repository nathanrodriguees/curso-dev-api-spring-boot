package br.edu.senaiso.Aula22_04_04_25.exception;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	MessageSource messageSource;

	@ExceptionHandler(RecursoNotFound.class)
	public ResponseEntity<?> recursoNotFound(RecursoNotFound e, WebRequest request) {

		String idioma = request.getHeader("Accept-Language");
		System.out.println(request.getLocale().getLanguage()); // teste

		idioma = (idioma == null ? LocaleContextHolder.getLocale().getLanguage() : idioma);

		String msgLang = messageSource.getMessage("recurso_notfound", null, new Locale(idioma));

		MensagemErro msg = new MensagemErro(LocalDateTime.now(), msgLang, request.getDescription(false));

		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> geralRuntimeException(RuntimeException e, WebRequest request) {
		System.err.println("AQUI 2");
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
