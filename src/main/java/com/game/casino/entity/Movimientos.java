package com.game.casino.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos", schema = "public")
public class Movimientos implements java.io.Serializable {
	
	//Transacción XXX Usuario: YYYY Incremento: -50 Juego: Blackjack…
	
private static final long serialVersionUID = 1L; 
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
    private String usuario;
	private String transaccion;
	private double operacion;
	private String tipojuego;
	private Date fechamov;
	
	public Movimientos() {
	
	}
	
	public Movimientos(Integer id, String usuario, String transaccion, double operacion, String tipojuego,
			Date fechamov) {
		super();
		Id = id;
		this.usuario = usuario;
		this.transaccion = transaccion;
		this.operacion = operacion;
		this.tipojuego = tipojuego;
		this.fechamov = fechamov;
	}
	public Movimientos(String usuario, String transaccion, double operacion, String tipojuego,
			Date fechamov) {
		super();
		this.usuario = usuario;
		this.transaccion = transaccion;
		this.operacion = operacion;
		this.tipojuego = tipojuego;
		this.fechamov = fechamov;
	}
	
	
	public Integer getId() {
		return Id;
	}
    
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public double getOperacion() {
		return operacion;
	}

	public void setOperacion(double operacion) {
		this.operacion = operacion;
	}

	public String getTipojuego() {
		return tipojuego;
	}

	public void setTipojuego(String tipojuego) {
		this.tipojuego = tipojuego;
	}

	public Date getFechamov() {
		return fechamov;
	}

	public void setFechamov(Date fechamov) {
		this.fechamov = fechamov;
	}
	
	
	
	
	
	
}
