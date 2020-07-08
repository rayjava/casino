package com.game.casino.service;


import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.casino.entity.Configuracion;
import com.game.casino.entity.Juegos;
import com.game.casino.entity.Jugador;
import com.game.casino.entity.Movimientos;
import com.game.casino.repository.IRepoJugador;
import com.game.casino.repository.IRepoMovimientos;


@Service
public class ImpServMovimientos implements IServMovimientos{
	
	static final String GANAR = "GANANCIA";
	static final String RETIRAR = "RETIRAR";
	private static  final org.slf4j.Logger logger = LoggerFactory.getLogger(ImpServMovimientos.class);
	 @Autowired
	 IRepoMovimientos irepomovimientos;
	 	 	 
	 @Autowired
		IServJuegos iservjuegos;
	 
	 @Autowired
	 IRepoJugador irepojugador;

	@Override
	public Movimientos findbyusuario(String usuario) {
		
		return irepomovimientos.findByUsuario(usuario);
	}






	@Override
	public String registromovimientosjugador(Jugador jugador, Configuracion configuracion) {
		
		String mensajes = null;
		double balance = 0;
		Date date = new Date();
		java.sql.Date sqlDate = convert(date);
		Juegos juegos = iservjuegos.findBytipo(jugador.getTipojuego());
		if (jugador.getDescripcionapuesta().equals(configuracion.getRegla())){
			
			Movimientos movimientos = new Movimientos(jugador.getUsuario(),GANAR,configuracion.getPremio(),configuracion.getTipojuego(),sqlDate);
			//Graba registro movimiento
			irepomovimientos.save(movimientos);
			 balance = jugador.getBalance() + configuracion.getPremio();
			 //Actualiza el saldo disponible al jugador para jugar.
			 jugador.setBalance(balance);
			 irepojugador.saveAndFlush(jugador);
			logger.info("Transacción :" + GANAR + " Usuario: "+ jugador.getUsuario() +  " Incremento: " +
			Double.toString(configuracion.getPremio()) + " Juego: " + configuracion.getTipojuego());
			mensajes = "Haz Ganado!!!";
		}else {
			Movimientos movimientos = new Movimientos(jugador.getUsuario(),RETIRAR,jugador.getMontoapuesta()*-1,configuracion.getTipojuego(),sqlDate);
			//Graba registro movimiento
			irepomovimientos.save(movimientos);
			 balance = jugador.getBalance() - jugador.getMontoapuesta();
			//Actualiza el saldo disponible para jugar.
			 jugador.setBalance(balance);
			 irepojugador.saveAndFlush(jugador);
			logger.info("Transacción :" + RETIRAR + " Usuario: "+ jugador.getUsuario() +  " Incremento: " +
			Double.toString(jugador.getMontoapuesta()*-1) + " Juego: " + configuracion.getTipojuego());
			mensajes = "Lo sentimos, haz perdido, vuelve a intentar..";		
			if(balance <= 0) {
				mensajes = "Balance igual a cero, no dispone de mas credito..";	
			}
		}
		long finjuego = System.currentTimeMillis();
		return mensajes;
	}

	@Override
	public List<Movimientos> listarmovimientos() {
		
		return irepomovimientos.findAll();
	}
	

	private java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }


		
}
