package com.game.casino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.casino.entity.Jugador;
import com.game.casino.repository.IRepoJugador;

@Service
public class ImpServJugador implements IServJugador{

	@Autowired
	IRepoJugador irepojugador;

	@Override
	public Jugador findbyusuario(String usuario) {
		
		return irepojugador.findByUsuario(usuario);
	}

	@Override
	public Jugador crearbyjugador(Jugador jugador) {
		
		return irepojugador.save(jugador);
	}

	
	@Override
	public List<Jugador> listarjugadores() {
		
		return irepojugador.findAll();
	}

	@Override
	public Jugador findbyuuid(String uuid) {
		
		return irepojugador.findByUuid(uuid);
	}

	@Override
	public void updatejugador(Jugador jugador) {
		
		irepojugador.saveAndFlush(jugador);
		
	}

	
	
	
	

	
}
