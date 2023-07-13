package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.estudiante.modelo.Materia;
import com.uce.edu.demo.estudiante.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {

	@Autowired
	private IMateriaService iMateriaService;
	
	@GetMapping(path="/buscar")
	public Materia consultarPorCodigo() {
		String codigo="E001";
		return this.iMateriaService.buscarPorCodigo(codigo);
	}
	
	@PostMapping(path="/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.iMateriaService.guardar(materia);
	}
	
}
