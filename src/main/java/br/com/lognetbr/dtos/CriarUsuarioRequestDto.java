package br.com.lognetbr.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarUsuarioRequestDto {

	@NotEmpty(message = "Nome obrigatório.")
	@Pattern(regexp = "^[A-Za-zÀ-Üà-ü\\s]{3,75}$", message = "Somente letras, Min: 3; Máx: 75")
	private String nome;

	@NotEmpty(message = "Email obrigatório.")
	@Email(message = "Email invalido")
	private String email;

	@NotEmpty(message = "Senha obrigatória.")
	@Pattern(
		    regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&#^()\\-_=+{}\\[\\]:;,.<>])[A-Za-z0-9@$!%*?&#^()\\-_=+{}\\[\\]:;,.<>]{8,20}$",
		    message = "A senha deve ter entre 8 e 20 caracteres, com pelo menos 1 letra maiúscula, 1 número e 1 caracter especial"
		)
		private String senha;
}
