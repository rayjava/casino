package com.game.casino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.casino.entity.Movimientos;

@Repository
public interface IRepoMovimientos extends JpaRepository<Movimientos, String> {
	
	Movimientos findByUsuario(String usuario);

}
