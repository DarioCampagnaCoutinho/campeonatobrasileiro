package br.com.cbf.campeonatobrasileiro.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class JogoDto {
	
	private Integer id;
	
	private LocalDateTime data;
	
	private Integer golsTime1;
	
	private Integer golsTime2;
	
	private Integer publicoPagante;
	
	private Boolean encerrado;
	
	private Integer rodada;
	
    private TimeDto time1;
	
	private TimeDto time2;

}
