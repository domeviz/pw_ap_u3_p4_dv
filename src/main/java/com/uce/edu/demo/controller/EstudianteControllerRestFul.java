package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	
	//GET
	@GetMapping(path="/{cedula}")
	public ResponseEntity<Estudiante> consultarPorCedula(@PathVariable String cedula) {
		Estudiante estudiante=this.estudianteService.buscarPorCedula(cedula);

		return ResponseEntity.status(227).body(estudiante);
	}

	@GetMapping(path="/status/{cedula}")
	public ResponseEntity<Estudiante> consultarPorCedulaStatus(@PathVariable String cedula) {
		Estudiante estudiante=this.estudianteService.buscarPorCedula(cedula);

		return ResponseEntity.status(HttpStatus.OK).body(estudiante);
	}
	

	@GetMapping
	public ResponseEntity<List<Estudiante>> buscarTodos() {
		List<Estudiante> estudiantes=this.estudianteService.buscarTodos();
		HttpHeaders cabeceras=new HttpHeaders();
		cabeceras.add("Detalle mensaje","Ciudadanos consultados exitosamente");
		return new ResponseEntity<>(estudiantes,cabeceras,228);		
	}
	
	@PostMapping
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	@PutMapping(path="/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante,@PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}
	
	@PatchMapping(path="/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante,@PathVariable Integer identificador) {
		Estudiante estu1=this.estudianteService.buscarPorID(identificador);
		estu1.setCedula(estudiante.getCedula());
		this.estudianteService.actualizar(estu1);
	}

	@DeleteMapping(path="/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}
	
	@GetMapping(path="/buscarTodosPorProvincia")
	public List<Estudiante> buscarTodosPorProvincia(@RequestParam String provincia) {
		return this.estudianteService.buscarTodosPorProvincia(provincia);	
	}
}
