package org.lpav2.videotienda.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.lpav2.videotienda.model.entity.Pelicula;

public interface PeliculaService {
	public List<Pelicula> buscarPeliculasTodos();
	public Page<Pelicula> buscarPeliculasTodos(Pageable pageable);
	public void actualizarPelicula(Pelicula pelicula);
	public Pelicula buscarPeliculaPorId(Long id);
	public void eliminarPeliculaPorId(Long id);
}
