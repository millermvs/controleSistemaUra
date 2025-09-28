package br.com.lognetbr.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarUsuarioResponseDto {

	private UUID id;
	private String nome;
	private String email;

}
