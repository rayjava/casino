package com.game.casino.service;


import java.util.List;

import com.game.casino.entity.Proveedor;

public interface IServProveedor {

	public Proveedor findbynombreproveedor(String nombreproveedor);
	
    public List<Proveedor> listarprov();
	
	public void Crearprov(List<Proveedor> proveedor);
	
	public Proveedor findbyuuidprov(String uuid);
	
}
