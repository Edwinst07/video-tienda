package org.lpav2.videotienda.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;

	@Column(nullable = false, length = 100)
	@NotEmpty
	private String titulo;
	
	@Column(nullable = false, length = 50)
	@NotEmpty	
	private String genero;
	
	@Min(value = 1895)
	@Column(nullable = false, name = "año_estreno")
	private int anioEstreno;
	
	private boolean disponible;
	
	@Column(name = "caratula")
	private String caratula;
	
	public Pelicula() {
	}

	public Pelicula(Long id, String titulo, String genero, int anioEstreno, boolean disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.anioEstreno = anioEstreno;
		this.disponible = disponible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnioEstreno() {
		return anioEstreno;
	}

	public void setAnioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}
	
}
