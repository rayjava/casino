package com.game.casino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.casino.entity.Proveedor;
import com.game.casino.repository.IRepoProveedor;
@Service
public class ImpServProveedor implements IServProveedor{

	@Autowired
	IRepoProveedor irepoproveedor;

	@Override
	public Proveedor findbynombreproveedor(String nombreproveedor) {
		
		return irepoproveedor.findByNombreproveedor(nombreproveedor);
	}

	@Override
	public List<Proveedor> listarprov() {
		
		return irepoproveedor.findAll();
	}

	@Override
	public void Crearprov(List<Proveedor> proveedor) {
		
		irepoproveedor.saveAll(proveedor);
	}

	@Override
	public Proveedor findbyuuidprov(String uuid) {
		
		return irepoproveedor.findByUuidprov(uuid);
	}

	

	
	
	
	
}
