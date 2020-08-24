package br.com.cbf.campeonatobrasileiro.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.service.TimeServico;

@RestController
@RequestMapping(value = "/times")
public class TimeRestController {
	
	@Autowired
	private TimeServico timeServico;
	
	@GetMapping
	public ResponseEntity<List<Time>> getTimes(){
		return ResponseEntity.ok().body(timeServico.listar());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Time> getTime(@PathVariable Integer id){
		return ResponseEntity.ok().body(timeServico.obterTime(id));
	}
	
	public ResponseEntity<Void> cadastrarTime(Time time){
		timeServico.cadastrarTime(time);
		return ResponseEntity.ok().build();
	}
}
