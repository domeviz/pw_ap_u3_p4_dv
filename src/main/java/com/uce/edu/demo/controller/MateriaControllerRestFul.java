package com.uce.edu.demo.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.estudiante.modelo.Materia;
import com.uce.edu.demo.estudiante.service.IMateriaService;
import com.uce.edu.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {

	@Autowired
	private IMateriaService iMateriaService;
	
	@GetMapping(path="/buscar/{codigo}")
	public Materia consultarPorCodigo(@PathVariable String codigo) {
		return this.iMateriaService.buscarPorCodigo(codigo);
	}
	
	@PostMapping(path="/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.iMateriaService.guardar(materia);
	}
	
	@PutMapping(path="/actualizar/{identificador}")
	public void actualizar(@RequestBody Materia materia,@PathVariable Integer identificador) {
		materia.setId(identificador);
		this.iMateriaService.actualizar(materia);
	}

	@PatchMapping(path="/actualizarParcial/{identificador}")
	public void actualizarParcial(@RequestBody Materia materia,@PathVariable Integer identificador) {
		materia.setId(identificador);
		String codigo="E001";
		Materia m1=this.iMateriaService.buscarPorCodigo(codigo);
		m1.setCodigo(materia.getCodigo());
		this.iMateriaService.actualizar(m1);
	}
	
	@DeleteMapping(path="/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iMateriaService.borrar(id);
	}

	@GetMapping(path="/buscarTodos")
	public List<Materia> buscarTodos() {
		return this.iMateriaService.buscarTodos();
	}

	@GetMapping(path="/buscarTodosPorCarrera")
	public List<Materia> buscarTodosPorCarrera(@RequestParam String carrera) {
		return this.iMateriaService.buscarTodosPorCarrera(carrera);
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaTO> buscarPorMateria(@PathVariable Integer id) {
//		MateriaTO materiaTO=this.iMateriaService.buscarPorID(id);
//		Link myLink=linkTo(methodOn(MateriaControllerRestFul.class).buscarPorMateria(id)).withRel("materias");
//		materiaTO.add(myLink);
//		return ResponseEntity.status(HttpStatus.OK).body(materiaTO);
		return null;
	}
}
