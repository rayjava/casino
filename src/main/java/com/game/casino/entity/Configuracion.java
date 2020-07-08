package com.game.casino.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuracion", schema = "public")
public class Configuracion implements java.io.Serializable{
	
	/*Configuración de juego
	● ID único
	● Tipo de juego
	● Configuración: premios, apuestas(min/max), etc
	● Probabilidad de premio: %*/
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String tipojuego;
	private String regla;
	private double premio;
	private double min;
	private double max;
	private double probabilidad;
	
	public Configuracion() {
		
	}

	public Configuracion(Integer id, String tipojuego, String regla, double premio, double min, double max,
			double probabilidad) {
		super();
		Id = id;
		this.tipojuego = tipojuego;
		this.regla = regla;
		this.premio = premio;
		this.min = min;
		this.max = max;
		this.probabilidad = probabilidad;
	}

	public Configuracion(String tipojuego, String regla, double premio, double min, double max, double probabilidad) {
		super();
		this.tipojuego = tipojuego;
		this.regla = regla;
		this.premio = premio;
		this.min = min;
		this.max = max;
		this.probabilidad = probabilidad;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTipojuego() {
		return tipojuego;
	}

	public void setTipojuego(String tipojuego) {
		this.tipojuego = tipojuego;
	}

	public String getRegla() {
		return regla;
	}

	public void setRegla(String regla) {
		this.regla = regla;
	}

	public double getPremio() {
		return premio;
	}

	public void setPremio(double premio) {
		this.premio = premio;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(double probabilidad) {
		this.probabilidad = probabilidad;
	}
	
	
	

}
