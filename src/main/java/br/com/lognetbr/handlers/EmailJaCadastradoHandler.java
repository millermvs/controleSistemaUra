package br.com.lognetbr.handlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lognetbr.exceptions.EmailJaCadastradoException;

@ControllerAdvice
public class EmailJaCadastradoHandler {
	@ExceptionHandler(EmailJaCadastradoException.class)
	public ResponseEntity<Object> handlerEmailJaCadastrado(EmailJaCadastradoException ex) {
		Map<String, Object> body = new HashMap<>();

		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.CONFLICT.value());
		body.put("errors", ex.getMessage());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
	}

}
