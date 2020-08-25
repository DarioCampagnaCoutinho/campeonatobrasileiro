package br.com.cbf.campeonatobrasileiro.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbf.campeonatobrasileiro.dto.TimeDto;
import br.com.cbf.campeonatobrasileiro.service.TimeServico;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/times")
public class TimeRestController {
	
	@Autowired
	private TimeServico timeServico;
	
	@GetMapping
	public ResponseEntity<List<TimeDto>> getTimes(){
		return ResponseEntity.ok().body(timeServico.listar());
	}
	
	@ApiOperation(value = "Obtém os dados de um time")
	@GetMapping(value = "/{id}")
	public ResponseEntity<TimeDto> getTime(@PathVariable Integer id){
		return ResponseEntity.ok().body(timeServico.obterTime(id));
	}
	
	@PostMapping
	public ResponseEntity<TimeDto> cadastrarTime(@Valid @RequestBody TimeDto time) throws Exception{
		return ResponseEntity.ok().body(timeServico.cadastrarTime(time));
	}
}
