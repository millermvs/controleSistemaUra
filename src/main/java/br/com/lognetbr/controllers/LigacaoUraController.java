package br.com.lognetbr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lognetbr.dtos.CriarLigacaoUraRequestDto;
import br.com.lognetbr.services.LigacaoUraSercice;

@RestController
@RequestMapping("/api/v1/ura")
public class LigacaoUraController {

	@Autowired
	private LigacaoUraSercice ligacaoUraService;

	@PostMapping("salvar-ligacoes")
	public ResponseEntity<?> post(@RequestBody CriarLigacaoUraRequestDto request) {
		var response = ligacaoUraService.criarLigacao(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("listar-ligacoes")
	public ResponseEntity<?> get() {
		var response = ligacaoUraService.getListarLigacoesUra();
		return ResponseEntity.ok(response);
	}
}
