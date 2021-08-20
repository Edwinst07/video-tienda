package org.lpav2.videotienda.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import org.lpav2.videotienda.model.entity.Pelicula;
import org.lpav2.videotienda.model.service.PeliculaService;
import org.lpav2.videotienda.util.paginator.PageRender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/videotienda")
@SessionAttributes("pelicula")	
public class PeliculaController {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping("/peliculas")
	public String peliculasListar(@RequestParam(value = "pag", defaultValue = "0") int pag, Model model) {
		Pageable pagina = PageRequest.of(pag, 5);
		Page<Pelicula> peliculas = peliculaService.buscarPeliculasTodos(pagina);
		
		PageRender<Pelicula> pageRender = new PageRender<>("/videotienda/peliculas", peliculas);

		model.addAttribute("titulo", "Listado de películas");
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("pageRender", pageRender);
		return "pelicula/listado_peliculas";
	}
	
	@GetMapping("/nuevapelicula")
	public String peliculaFrmNuevo(Model model) {
		model.addAttribute("titulo", "Nueva película");
		model.addAttribute("accion", "Crear");
		model.addAttribute("pelicula", new Pelicula());
		return "pelicula/form_pelicula";
	}
	
	@PostMapping("/actualizarpelicula")
	public String peliculaActualizar(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult result, 
			Model model, @RequestParam("file") MultipartFile caratula, RedirectAttributes flash, SessionStatus status) {
		
		String accion = (pelicula.getId() == null) ? "Crear" : "Modificar";
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Nueva película");
			model.addAttribute("accion", accion);
			model.addAttribute("info", "Corregir los errores del formulario !!");
			return "pelicula/form_pelicula";
		}
		
		if (!caratula.isEmpty()) {
			String nomUnico = UUID.randomUUID().toString() + "_" + caratula.getOriginalFilename();
			
			Path rutaRelUploads = Paths.get("uploads").resolve(nomUnico);
			Path rutaAbsUploads = rutaRelUploads.toAbsolutePath();
			
			log.info("*** rutaRelUploads: " + rutaRelUploads);
			log.info("*** rutaAbsUploads: " + rutaAbsUploads);
			
			try {
				Files.copy(caratula.getInputStream(), rutaAbsUploads);
				
				flash.addFlashAttribute("info", "Fue cargada la carátula de la película " 
					+ pelicula.getTitulo() + " [" + nomUnico + "]");
				pelicula.setCaratula(nomUnico);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		peliculaService.actualizarPelicula(pelicula);
		status.setComplete();
		flash.addFlashAttribute("success", accion + " película, proceso exitoso !!");
		return "redirect:/videotienda/peliculas";
	}
	
	@GetMapping("/consultarpelicula/{id}")
	public String peliculaConsultar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
		Pelicula pelicula = peliculaService.buscarPeliculaPorId(id);
		if (pelicula == null) {
			flash.addFlashAttribute("error", "El registro de la película no existe en la BD !!");
			return "redirect:/videotienda/peliculas";
		}
		model.addAttribute("titulo", "Consulta detalle de película");
		model.addAttribute("pelicula", pelicula);
		
		return "pelicula/consulta_pelicula";
	}
	
	@GetMapping("/eliminarpelicula/{id}")
	public String peliculaEliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			peliculaService.eliminarPeliculaPorId(id);
			flash.addFlashAttribute("success", "Registro de película eliminado con éxito !!");
		}
		return "redirect:/videotienda/peliculas";
	}
	
	@GetMapping("/modificarpelicula/{id}")
	public String peliculaFormModificar(@PathVariable(value = "id") Long id, 
			Model model, RedirectAttributes flash) {
		Pelicula pelicula = null;
		if (id > 0) {
			pelicula = peliculaService.buscarPeliculaPorId(id);
			if (pelicula == null) {
				flash.addFlashAttribute("error", "El registro de la película no existe en la BD !!");
				return "redirect:/videotienda/peliculas";
			}
		}
		else {
			flash.addFlashAttribute("error", "El ID de la película debe ser positivo !!");
			return "redirect:/videotienda/peliculas";
		}
		model.addAttribute("accion", "Modificar");
		model.addAttribute("titulo", "Modificar info. de la pelicula");
		model.addAttribute("pelicula", pelicula);
		return "pelicula/form_pelicula";
	}	
}
