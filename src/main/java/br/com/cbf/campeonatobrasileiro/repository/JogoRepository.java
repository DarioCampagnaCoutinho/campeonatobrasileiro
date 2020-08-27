package br.com.cbf.campeonatobrasileiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cbf.campeonatobrasileiro.entity.Jogo;
import br.com.cbf.campeonatobrasileiro.entity.Time;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer>{
	
	List<Jogo> findByTime1AndEncerrado(Time time, Boolean encerrado);
    List<Jogo> findByTime2AndEncerrado(Time time, Boolean encerrado);
}
