package com.game.casino.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.casino.entity.Configuracion;
import com.game.casino.repository.IRepoConfiguracion;

@Service
public class ImpServConfiguracion implements IServConfiguracion {
	
	@Autowired
    IRepoConfiguracion irepoconfiguracion;

	@Override
	public Configuracion findBytipo(String tipojuego) {
		
		return irepoconfiguracion.findByTipojuego(tipojuego);
	}

	@Override
	public List<Configuracion> listarconfig() {
		
		return irepoconfiguracion.findAll();
	}

	@Override
	public void crearconfig(List<Configuracion> configuracion) {
		
		irepoconfiguracion.saveAll(configuracion);
	}

	
	
	
	}

	

	
	
	
	
	
