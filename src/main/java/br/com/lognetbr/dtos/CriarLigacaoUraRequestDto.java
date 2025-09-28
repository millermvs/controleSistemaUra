package br.com.lognetbr.dtos;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarLigacaoUraRequestDto {
	
	
	private Integer protocolo;
	
	private String telefone;	
	
	private String context;	
	
	private LocalDateTime dataGeracao;
	
}
