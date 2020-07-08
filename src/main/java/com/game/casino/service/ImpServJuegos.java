package com.game.casino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.game.casino.entity.Juegos;
import com.game.casino.repository.IRepoJuegos;

@Service
public class ImpServJuegos implements IServJuegos{

	@Autowired
	IRepoJuegos irepojuegos;

	@Override
	public Juegos findBytipo(String tipojuego) {
		return irepojuegos.findByTipojuego(tipojuego);
	}

	@Override
	public List<Juegos> listarjuegos() {
		return irepojuegos.findAll();
	}

	@Override
	public void crearjuegos(List<Juegos> juegos) {
		
		irepojuegos.saveAll(juegos);
	}

	
	
}
