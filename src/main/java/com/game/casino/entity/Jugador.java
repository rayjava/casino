package com.game.casino.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jugador", schema = "public")
public class Jugador implements java.io.Serializable{
	
	/*ID único (UUID)
	● Balance
	● tiempo de juego: cantidad de tiempo máximo que puede estar jugando.
	● Proveedor de usuario (UUID) - usuarios pueden venir de diferentes proveedores de
	usuarios*/
	
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	private String uuid;
	private String usuario;
	private String tipojuego;
	private double balance;
	private int timePlay;
	private String fecha;
	private double montoapuesta;
	private String descripcionapuesta;
	private String uuidproveedor;
	private String mensajes;
		
	public Jugador() {
		
	}

	public Jugador(String uuid, String usuario, String tipojuego, double balance, int timePlay, String fecha,
			double montoapuesta, String descripcionapuesta, String uuidproveedor, String mensajes) {
		super();
		this.uuid = uuid;
		this.usuario = usuario;
		this.tipojuego = tipojuego;
		this.balance = balance;
		this.timePlay = timePlay;
		this.fecha = fecha;
		this.montoapuesta = montoapuesta;
		this.descripcionapuesta = descripcionapuesta;
		this.uuidproveedor = uuidproveedor;
		this.mensajes = mensajes;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipojuego() {
		return tipojuego;
	}

	public void setTipojuego(String tipojuego) {
		this.tipojuego = tipojuego;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getTimePlay() {
		return timePlay;
	}

	public void setTimePlay(int timePlay) {
		this.timePlay = timePlay;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getMontoapuesta() {
		return montoapuesta;
	}

	public void setMontoapuesta(double montoapuesta) {
		this.montoapuesta = montoapuesta;
	}

	public String getDescripcionapuesta() {
		return descripcionapuesta;
	}

	public void setDescripcionapuesta(String descripcionapuesta) {
		this.descripcionapuesta = descripcionapuesta;
	}

	public String getUuidproveedor() {
		return uuidproveedor;
	}

	public void setUuidproveedor(String uuidproveedor) {
		this.uuidproveedor = uuidproveedor;
	}

	public String getMensajes() {
		return mensajes;
	}

	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}

	
	
}
