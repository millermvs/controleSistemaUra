package br.com.lognetbr.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.lognetbr.dtos.CriarLigacaoUraRequestDto;
import br.com.lognetbr.dtos.CriarLigacaoUraResponseDto;
import br.com.lognetbr.dtos.ListarLigacoesResponseDto;
import br.com.lognetbr.entities.LigacaoUra;
import br.com.lognetbr.repositories.LigacaoUraRepository;

@Service
public class LigacaoUraSercice {

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

	public Page<ListarLigacoesResponseDto> listarLigacoesUra(LocalDate dataInicio, LocalDate dataFim, int page) {

		var pageable = PageRequest.of(page, 25);
		var lista = ligacaoUraRepository.findByDate(dataInicio, dataFim, pageable);
		var response = lista.map(m -> new ListarLigacoesResponseDto(
				m.getProtocolo(),
				m.getTelefone(),
				m.getContext(),
				m.getDataGeracao()				
				));

		return response;

	}

}
