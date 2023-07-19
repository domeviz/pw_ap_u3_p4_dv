package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.estudiante.modelo.Horario;
import com.uce.edu.demo.estudiante.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestFul {

	@Autowired
	private IHorarioService iHorarioService;
	
	//GET
	@GetMapping(path="/{codigo}")
	public Horario consultarPorCodigo(@PathVariable String codigo) {
		return this.iHorarioService.buscarPorCodigo(codigo);
	}

	@GetMapping
	public List<Horario> buscarTodos() {
		return this.iHorarioService.buscarTodos();	
	}
	
	@PostMapping
	public void guardar(@RequestBody Horario horario) {
		this.iHorarioService.guardar(horario);
	}
	
	@PutMapping(path="/{identificador}")
	public void actualizar(@RequestBody Horario horario,@PathVariable Integer identificador) {
		horario.setId(identificador);
		this.iHorarioService.actualizar(horario);
	}
	
	@PatchMapping(path="/{identificador}")
	public void actualizarParcial(@RequestBody Horario horario,@PathVariable Integer identificador) {
		Horario h1=this.iHorarioService.buscarPorID(identificador);
		h1.setCodigo(horario.getCodigo());
		this.iHorarioService.actualizar(h1);
	}

	@DeleteMapping(path="/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iHorarioService.borrar(id);
	}
}
