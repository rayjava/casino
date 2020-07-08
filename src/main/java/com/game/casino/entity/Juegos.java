package com.game.casino.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "juegos", schema = "public")
public class Juegos implements java.io.Serializable{

	// El Casino Online puede ofrecer los siguientes juegos
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String tipojuego;
	
	public Juegos() {
	
	}

	public Juegos(Integer id, String tipojuego) {
		super();
		this.id = id;
		this.tipojuego = tipojuego;
	}

	public Juegos(String tipojuego) {
		super();
		this.tipojuego = tipojuego;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipojuego() {
		return tipojuego;
	}

	public void setTipojuego(String tipojuego) {
		this.tipojuego = tipojuego;
	}
	
	
}
