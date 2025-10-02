package br.com.lognetbr.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListarLigacoesResponseDto {
	
	private String protocolo;
	private String telefone;
	private String context;
	private String dataGeracao;

}
