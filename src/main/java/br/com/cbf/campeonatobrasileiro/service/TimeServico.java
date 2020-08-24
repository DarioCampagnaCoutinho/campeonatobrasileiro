package br.com.cbf.campeonatobrasileiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.repository.TimeRepository;

@Service
public class TimeServico {
	
	@Autowired
	private TimeRepository timeRepository;
	
	public void cadastrarTime(Time time) {
		timeRepository.save(time);
	}
	
	public List<Time> listar(){
		return timeRepository.findAll();
	}
	
	public Time obterTime(Integer id) {
		return timeRepository.findById(id).get();
	}
}
