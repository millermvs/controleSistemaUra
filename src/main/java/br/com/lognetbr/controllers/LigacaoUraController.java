package br.com.lognetbr.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lognetbr.dtos.CriarLigacaoUraRequestDto;
import br.com.lognetbr.dtos.ListarLigacoesResponseDto;
import br.com.lognetbr.services.LigacaoUraSercice;

@RestController
@RequestMapping("/api/v1/ura/ligacoes")
public class LigacaoUraController {

	@Autowired
	private LigacaoUraSercice ligacaoUraService;

	@PostMapping("salvar")
	public ResponseEntity<?> post(@RequestBody CriarLigacaoUraRequestDto request) {
		var response = ligacaoUraService.criarLigacao(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("listar/{dataInicio}/{dataFim}/{page}")
	public ResponseEntity<Page<ListarLigacoesResponseDto>> get(@PathVariable String dataInicio, @PathVariable String dataFim, @PathVariable int page) {
		var response = ligacaoUraService.listarLigacoesUra(LocalDate.parse(dataInicio), LocalDate.parse(dataFim), page);		
		return ResponseEntity.ok().body(response);
	}
}
