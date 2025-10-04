package br.com.lognetbr.exceptions;


public class SemDadosNaConsultaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Não há dados para essa consulta";
	}

}
