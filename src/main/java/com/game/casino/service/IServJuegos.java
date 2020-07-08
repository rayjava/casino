package com.game.casino.service;

import java.util.List;

import com.game.casino.entity.Juegos;
import com.game.casino.entity.Proveedor;

public interface IServJuegos {

		public Juegos findBytipo(String tipojuego); 
		public List<Juegos> listarjuegos();
		public void crearjuegos(List<Juegos> juegos);
}
