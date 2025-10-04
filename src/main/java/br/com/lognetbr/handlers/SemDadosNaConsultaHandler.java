package br.com.lognetbr.handlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.lognetbr.exceptions.SemDadosNaConsultaException;

@ControllerAdvice
public class SemDadosNaConsultaHandler {
	
	@ExceptionHandler(SemDadosNaConsultaException.class)
	public ResponseEntity<Object> handlerSemDadosNaConsulta(SemDadosNaConsultaException ex){
		Map<String, Object> body = new HashMap<>();
		
		body.put("data e hora", LocalDateTime.now());
		body.put("status", HttpStatus.ACCEPTED);
		body.put("message", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(body);
	}
	

}
