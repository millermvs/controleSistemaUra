package br.com.lognetbr.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ligacoes_ura")
public class LigacaoUra {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Long id;
	
	@Column (unique = true)
	private Integer protocolo;
	
	@Column
	private String telefone;
	
	@Column
	private String context;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataGeracao;
	

}
