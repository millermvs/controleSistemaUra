package br.com.lognetbr.handlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lognetbr.exceptions.ErroUsuarioOuSenhaException;

@ControllerAdvice
public class ErroUsuarioOuSenhaHandler {
	
	@ExceptionHandler(ErroUsuarioOuSenhaException.class)
	public ResponseEntity<Object> handlerErroUsuarioOuSenha(ErroUsuarioOuSenhaException ex){
		Map<String, Object> body = new HashMap<>();

		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.UNAUTHORIZED.value());
		body.put("errors", ex.getMessage());

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
	}
}
