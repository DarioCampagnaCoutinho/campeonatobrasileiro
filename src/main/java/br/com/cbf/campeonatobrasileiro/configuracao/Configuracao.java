package br.com.cbf.campeonatobrasileiro.configuracao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.repository.TimeRepository;

@Configuration
@Profile("test")
public class Configuracao implements CommandLineRunner{
	
	@Autowired
	private TimeRepository timeRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Time t1 = new Time(null, "São Paulo", "SPFC", "SP", "Morumbi");
		Time t2 = new Time(null, "Palmeiras", "SCLP", "SP", "Parque");
		Time t3 = new Time(null, "Santos", "SAFC", "SP", "Vila Belmiro");
		Time t4 = new Time(null, "Corinthians", "COFC", "SP", "Arena");
		
		timeRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}

}
