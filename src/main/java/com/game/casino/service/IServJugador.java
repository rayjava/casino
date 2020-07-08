package com.game.casino.service;

import java.util.List;

import com.game.casino.entity.Jugador;

public interface IServJugador {

	public Jugador findbyusuario(String usuario); 
	
	public Jugador crearbyjugador(Jugador jugador);
	
	public Jugador findbyuuid(String uuid);
	
	public List<Jugador> listarjugadores();
	
	public void updatejugador(Jugador jugador);
}
