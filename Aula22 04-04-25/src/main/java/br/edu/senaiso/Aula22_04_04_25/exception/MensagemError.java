package br.edu.senaiso.Aula22_04_04_25.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MensagemError {

	private LocalDateTime dtOcorrencia;
	private String mensagem;
	private String detalhes;

}
