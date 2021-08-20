package org.lpav2.videotienda.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.lpav2.videotienda.model.entity.Pelicula;

@Repository
public interface PeliculaDAO extends PagingAndSortingRepository<Pelicula, Long> {
}
