package br.com.cbf.campeonatobrasileiro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20)
	private String nome;
	
	@Column(length = 4)
	private String sigla;
	
	@Column(length = 2)
	private String uf;
	
	@Column(length = 20)
	private String estadio;
	
	public Time() {
		
	}

	public Time(Integer id, String nome, String sigla, String uf, String estadio) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.uf = uf;
		this.estadio = estadio;
	}
	
}
