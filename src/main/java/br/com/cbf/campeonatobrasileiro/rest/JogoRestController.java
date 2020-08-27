package br.com.cbf.campeonatobrasileiro.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbf.campeonatobrasileiro.dto.JogoDto;
import br.com.cbf.campeonatobrasileiro.dto.JogoFinalizadoDto;
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
	public ResponseEntity<List<JogoDto>> listarJogo(){
		return ResponseEntity.ok().body(jogoServico.listarJogos());
	}
	
	@PostMapping(value = "/finalizar/{id}")
	public ResponseEntity<JogoDto> finalizar(@PathVariable Integer id, @RequestBody JogoFinalizadoDto jogoDto) throws Exception{
		return ResponseEntity.ok().body(jogoServico.finalizar(id, jogoDto));
	}
	
	/*
	@GetMapping(value = "/classificacao")
	public ResponseEntity<JogoDto> classificacao(){
		return ResponseEntity.ok().body(jogoServico.obterClassificacao());
	}*/
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<JogoDto> obterJogo(@PathVariable Integer id){
		return ResponseEntity.ok().body(jogoServico.obterJogo(id));
	}
}
