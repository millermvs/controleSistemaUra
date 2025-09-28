package br.com.lognetbr.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutenticarUsuarioRequestDto {
	
	@Email (message = "Email inválido")
	private String email;
	
	@NotEmpty (message = "Informe a senha")
	private String senha;

}
