package com.game.casino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.casino.entity.Juegos;

@Repository
public interface IRepoJuegos extends JpaRepository<Juegos, String>{

	 Juegos findByTipojuego(String tipojuego);
}
