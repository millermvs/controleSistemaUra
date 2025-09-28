package br.com.lognetbr.exceptions;

public class ErroUsuarioOuSenhaException extends RuntimeException{
	
	static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Erro usuario ou senha.";
	}

}
