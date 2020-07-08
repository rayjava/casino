package com.game.casino.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.game.casino.entity.Configuracion;
import com.game.casino.entity.Juegos;
import com.game.casino.entity.Jugador;
import com.game.casino.entity.Movimientos;
import com.game.casino.entity.Proveedor;
import com.game.casino.service.IServConfiguracion;
import com.game.casino.service.IServJuegos;
import com.game.casino.service.IServJugador;
import com.game.casino.service.IServMovimientos;
import com.game.casino.service.IServProveedor;


@RestController
public class CasinoController {
			
	@Autowired
	public IServProveedor iservproveedor;
	
	@Autowired
	IServJuegos iservjuegos; 
	
	@Autowired
	IServConfiguracion iservconfiguracion;
	
	@Autowired
	IServJugador iservjugador;
	
	@Autowired
	IServMovimientos iservmovimientos;
	
	
	
	//Endpoint Registrar datos del Jugador
	@PostMapping("/jugador")
	public Jugador jugador(@RequestBody Jugador jugador) {
		long iniciojuego = System.currentTimeMillis();
		String mensajes;
		String resp;
		//Si vine informado el proveedor pero no esta registrado en la BD
				Proveedor proveedor = iservproveedor.findbyuuidprov(jugador.getUuidproveedor());
				
		//Si esta informado el usuario y/o el proveedor
		if (jugador.getUsuario().isEmpty() || jugador.getUuidproveedor().isEmpty() || proveedor == null ) {
			mensajes = "Usuario y/o Proveedor No informado, favor revisar";
			
			jugador.setMensajes(mensajes);
			iservjugador.updatejugador(jugador);
			return jugador;
		}
		
				
		//Si no vine el uuid del jugador se creea		
		if (jugador.getUuid().equals("")){
			jugador.setUuid(Creauuid());
			iservjugador.crearbyjugador(jugador);
		}
		//Validar campos Balance y apuesta del jugador.
		Configuracion configuracion = iservconfiguracion.findBytipo(jugador.getTipojuego());
		if((jugador.getBalance() >= configuracion.getMin() && jugador.getBalance() <= configuracion.getMax()) || 
				(jugador.getBalance() >= configuracion.getMax())) {
			if ((jugador.getMontoapuesta() >= configuracion.getMin() && jugador.getMontoapuesta() <= configuracion.getMax())
					&& (jugador.getBalance() >= jugador.getMontoapuesta())) {
				//Registrar movimientos o transacciones del jugador
				  mensajes = iservmovimientos.registromovimientosjugador(jugador,configuracion);
			}else {
				mensajes = "Monto de la Apuesta no se encuentra entre los minimos y maximos aceptado";
			}
		}else {
			mensajes = "No dispone de suficiente credito para jugar";
		}
		
		jugador.setMensajes(mensajes);
		iservjugador.updatejugador(jugador);
		return jugador;
}
	 //Endpoint para crear proveedores
		@GetMapping("/creaprov")
		public List<Proveedor> creaprov() { 
					
			List<Proveedor> proveedor = Stream.of(
	                new Proveedor(Creauuid(), "Poker Star"),
	                new Proveedor(Creauuid(),"BWIN")
	        ).collect(Collectors.toList());
			iservproveedor.Crearprov(proveedor);
				
			return iservproveedor.listarprov();
		}
		
		//Endpoint para crear Juegos
		@GetMapping("/creajuegos")
		public List<Juegos> creajuegos() { 
					
			List<Juegos> juegos = Stream.of(
	                new Juegos("VIDEOBINGO"),
	                new Juegos("SLOT"),
	                new Juegos("BLACKJACK"),
	                new Juegos("POKER"),
	                new Juegos("RULETA")
	                
	        ).collect(Collectors.toList());
			iservjuegos.crearjuegos(juegos);
				
			return iservjuegos.listarjuegos();
		}
		
		//Endpoint Crear Configuracion de Juegos
		@GetMapping("/creaconfig")
		public List<Configuracion> creaconfig() { 
					
			List<Configuracion> configuracion = Stream.of(
	                new Configuracion("VIDEOBINGO","123",100.0,10.0,30.0,25.0),
	                new Configuracion("SLOT","123",100.0,10.0,30.0,25.0),
	                new Configuracion("BLACKJACK","21",100.0,10.0,30.0,25.0),
	                new Configuracion("POKER","21",100.0,10.0,30.0,25.0),
	                new Configuracion("RULETA","5N",100.0,10.0,30.0,25.0)
	                
	        ).collect(Collectors.toList());
			iservconfiguracion.crearconfig(configuracion);
				
			return iservconfiguracion.listarconfig();
		}
	  //Endpoint Listar Movimientos
		@GetMapping("/movimientos")
		public List<Movimientos> movimientos() { 
		return iservmovimientos.listarmovimientos();
		}
		
	 //Endpoint Listar Jugadores
		@GetMapping("/jugadores")
		public List<Jugador> jugadores() { 
		return iservjugador.listarjugadores();
		}
		
    //Metodo para crear UUID
	public String Creauuid(){
		 return UUID.randomUUID().toString();
	}
	
}
