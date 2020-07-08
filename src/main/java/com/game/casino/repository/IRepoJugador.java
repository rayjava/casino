package com.game.casino.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.casino.entity.Jugador;

@Repository
public interface IRepoJugador extends JpaRepository<Jugador, String> {

	Jugador findByUsuario(String usuario);
	Jugador findByUuid(String uuid);
}
