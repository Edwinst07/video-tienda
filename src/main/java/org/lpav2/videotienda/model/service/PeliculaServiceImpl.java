package org.lpav2.videotienda.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.lpav2.videotienda.model.dao.PeliculaDAO;
import org.lpav2.videotienda.model.entity.Pelicula;

@Service
public class PeliculaServiceImpl implements PeliculaService {

	@Autowired
	private PeliculaDAO peliculaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> buscarPeliculasTodos() {
		return (List<Pelicula>) peliculaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pelicula> buscarPeliculasTodos(Pageable pageable) {
		return peliculaDAO.findAll(pageable);
	}

	@Override
	public void actualizarPelicula(Pelicula pelicula) {
		peliculaDAO.save(pelicula);
	}

	@Override
	@Transactional(readOnly = true)
	public Pelicula buscarPeliculaPorId(Long id) {
		return peliculaDAO.findById(id).orElse(null);
	}

	@Override
	public void eliminarPeliculaPorId(Long id) {
		peliculaDAO.deleteById(id);
	}

}
