package br.com.lognetbr.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListarLigacoesResponseDto {

	// private List<?> ligacoes;
	private Long id;

	private String protocolo;

	private String telefone;

	private String context;

	private LocalDate dataGeracao;

}
