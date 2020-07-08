package com.game.casino.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor", schema = "public")
public class Proveedor implements java.io.Serializable {
	
	//Provveedor Externo
	
private static final long serialVersionUID = 1L;
	
	
	
	
	private String uuidprov;
	private String nombreproveedor;
	
	
    public Proveedor() {
    	
    }


	public Proveedor(String uuidprov, String nombreproveedor) {
		super();
		this.uuidprov = uuidprov;
		this.nombreproveedor = nombreproveedor;
	}

	@Id
	public String getUuidprov() {
		return uuidprov;
	}


	public void setUuidprov(String uuidprov) {
		this.uuidprov = uuidprov;
	}


	public String getNombreproveedor() {
		return nombreproveedor;
	}


	public void setNombreproveedor(String nombreproveedor) {
		this.nombreproveedor = nombreproveedor;
	};
    
	
	
	
	

	
}
