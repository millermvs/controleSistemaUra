package br.com.lognetbr.dtos;

import java.time.LocalDateTime;

public record ListarLigacoesResponseDto(Integer protocolo, String telefone, String context, LocalDateTime dataGeracao

) {

}
