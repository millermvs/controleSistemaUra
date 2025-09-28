package br.com.lognetbr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lognetbr.dtos.AutenticarUsuarioRequestDto;
import br.com.lognetbr.dtos.CriarUsuarioRequestDto;
import br.com.lognetbr.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("criar")
	public ResponseEntity<?> post(@Valid @RequestBody CriarUsuarioRequestDto request) {
		var response = usuarioService.criarUsuario(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("autenticar")
	public ResponseEntity<?> post(@Valid @RequestBody AutenticarUsuarioRequestDto request) {
		var response = usuarioService.autenticarUsuario(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("consultar")
	public ResponseEntity<?> get() {
		var response = usuarioService.getUsuarios();
		return ResponseEntity.ok(response);
	}
}
