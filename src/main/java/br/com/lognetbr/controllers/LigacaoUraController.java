package br.com.lognetbr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lognetbr.dtos.CriarLigacaoUraRequestDto;
import br.com.lognetbr.services.LigacaoUraService;

@RestController
@RequestMapping("/api/v1/ura/ligacoes")
public class LigacaoUraController {

	@Autowired
	private LigacaoUraService ligacaoUraService;

	@PostMapping("salvar")
	public ResponseEntity<?> post(@RequestBody CriarLigacaoUraRequestDto request) {
		var response = ligacaoUraService.criarLigacao(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("listar/{dataInicio}")
	public ResponseEntity<?> get(@PathVariable String dataInicio) {
		var response = ligacaoUraService.listarLigacoesUra();
		return ResponseEntity.ok().body(response);
	}
}
