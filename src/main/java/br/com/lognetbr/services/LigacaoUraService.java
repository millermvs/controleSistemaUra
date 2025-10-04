package br.com.lognetbr.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lognetbr.dtos.CriarLigacaoUraRequestDto;
import br.com.lognetbr.dtos.CriarLigacaoUraResponseDto;
import br.com.lognetbr.dtos.ListarLigacoesResponseDto;
import br.com.lognetbr.entities.LigacaoUra;
import br.com.lognetbr.exceptions.SemDadosNaConsultaException;
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
		ligacaoUra.setDatageracao(request.getDataGeracao());
		ligacaoUraRepository.save(ligacaoUra);

		var response = new CriarLigacaoUraResponseDto();
		response.setResposta("Ligação salva no banco de dados.");

		return response;
	}

	public ResponseEntity<List<ListarLigacoesResponseDto>> listarLigacoesUra(String dataInicio, String dataFim) {

		var  consultaLista = ligacaoUraRepository.findByDate(LocalDate.parse(dataInicio), LocalDate.parse(dataFim));
			if (consultaLista == null)
				throw new SemDadosNaConsultaException();

		var listaResponse = consultaLista.stream().map(l -> {
			var dto = new ListarLigacoesResponseDto();
			dto.setId(l.getId());
			dto.setProtocolo(l.getProtocolo());
			dto.setTelefone(l.getTelefone());
			dto.setContext(l.getContext());
			dto.setDataGeracao(l.getDatageracao());
			return dto;
		}).toList();
		

		return ResponseEntity.ok().body(listaResponse);
	}

}
