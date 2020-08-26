package br.com.cbf.campeonatobrasileiro.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbf.campeonatobrasileiro.entity.Jogo;
import br.com.cbf.campeonatobrasileiro.service.JogoServico;

@RestController
@RequestMapping(value = "/jogos")
public class JogoRestController {
	
	@Autowired
	private JogoServico jogoServico;
	
	@PostMapping(value = "/gerar")
	public ResponseEntity<Void> gerarJogo(){
		jogoServico.gerarJogos(LocalDateTime.now());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Jogo>> obterJogo(){
		return ResponseEntity.ok().body(jogoServico.obterJogos());
	}
}
