package com.game.casino.service;

import java.util.List;

import com.game.casino.entity.Configuracion;
import com.game.casino.entity.Juegos;

public interface IServConfiguracion {

	public Configuracion findBytipo(String tipojuego);
	public List<Configuracion> listarconfig();
	public void crearconfig(List<Configuracion> configuracion);
}
