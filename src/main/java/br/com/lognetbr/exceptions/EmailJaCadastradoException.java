package br.com.lognetbr.exceptions;

public class EmailJaCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Email já cadastrado no sistema.";
	}

}
