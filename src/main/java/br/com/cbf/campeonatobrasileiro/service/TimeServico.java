package br.com.cbf.campeonatobrasileiro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cbf.campeonatobrasileiro.dto.TimeDto;
import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.repository.TimeRepository;

@Service
public class TimeServico {
	
	@Autowired
	private TimeRepository timeRepository;
	
	public TimeDto cadastrarTime(TimeDto time) throws Exception {
		Time entity = toEntity(time);
		if(time.getId() == null) {
			entity = timeRepository.save(entity);
			return toDto(entity);
		}else {
			throw new Exception("Time já existe");
		}
		
	}
	
	private Time toEntity(TimeDto time) {
		Time entity = new Time();
		entity.setEstadio(time.getEstadio());
		entity.setSigla(time.getSigla());
		entity.setNome(time.getNome());
		entity.setUf(time.getUf());
		return entity;
		
	}
	
	public List<TimeDto> listar(){
		return timeRepository.findAll().stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}
	
	public TimeDto obterTime(Integer id) {
		return toDto(timeRepository.findById(id).get());
	}
	
	public TimeDto toDto(Time entity) {
		TimeDto dto = new TimeDto();
		dto.setEstadio(entity.getEstadio());
		dto.setSigla(entity.getSigla());
		dto.setNome(entity.getNome());
		dto.setUf(entity.getUf());
		dto.setId(entity.getId());
		return dto;
	}
	
	public List<Time> findAll() {
        return timeRepository.findAll();
    }

}
