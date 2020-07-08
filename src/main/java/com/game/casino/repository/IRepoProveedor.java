package com.game.casino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.casino.entity.Movimientos;
import com.game.casino.entity.Proveedor;

@Repository
public interface IRepoProveedor extends JpaRepository<Proveedor, String>{

	Proveedor findByNombreproveedor(String nombreproveedor);
	
	Proveedor findByUuidprov(String uuid);
}
