package com.game.casino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.casino.entity.Configuracion;

@Repository
public interface IRepoConfiguracion extends JpaRepository<Configuracion, Integer> {
	
	Configuracion findByTipojuego(String tipojuego);
}
