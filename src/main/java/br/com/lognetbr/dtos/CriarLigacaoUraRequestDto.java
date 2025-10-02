package br.com.lognetbr.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarLigacaoUraRequestDto {

	private String protocolo;

	private String telefone;

	private String context;

	private LocalDate dataGeracao;

}
