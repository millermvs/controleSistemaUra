package br.com.lognetbr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lognetbr.dtos.CriarLigacaoUraRequestDto;
import br.com.lognetbr.dtos.CriarLigacaoUraResponseDto;
import br.com.lognetbr.entities.LigacaoUra;
import br.com.lognetbr.repositories.LigacaoUraRepository;

@Service
public class LigacaoUraService {

	@Autowired
	private LigacaoUraRepository ligacaoUraRepository;

	public CriarLigacaoUraResponseDto criarLigacao(CriarLigacaoUraRequestDto request) {

		var ligacaoUra = new LigacaoUra();
		ligacaoUra.setProtocolo(request.getProtocolo());
		ligacaoUra.setTelefone(request.getTelefone());
		ligacaoUra.setContext(request.getContext());
		ligacaoUra.setDataGeracao(request.getDataGeracao());
		ligacaoUraRepository.save(ligacaoUra);

		var response = new CriarLigacaoUraResponseDto();
		response.setResposta("Ligação salva no banco de dados.");

		return response;
	}

	public ResponseEntity<?> listarLigacoesUra() {

		var lista = ligacaoUraRepository.findAll();

		return ResponseEntity.ok().body(lista);

	}

}
