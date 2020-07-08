package com.game.casino.service;

import java.util.List;

import com.game.casino.entity.Configuracion;
import com.game.casino.entity.Juegos;
import com.game.casino.entity.Jugador;
import com.game.casino.entity.Movimientos;

public interface IServMovimientos {
	
	public Movimientos findbyusuario(String usuario); 
    public String registromovimientosjugador(Jugador jugador, Configuracion configuracion);
    public List<Movimientos> listarmovimientos();
}
