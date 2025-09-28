package br.com.lognetbr.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticarUsuarioResponseDto {

	private UUID id;
	private String nome;
	private String email;
	private String token;
	private LocalDateTime horaCriacao;
	private LocalDateTime horaExpiracao;

}
