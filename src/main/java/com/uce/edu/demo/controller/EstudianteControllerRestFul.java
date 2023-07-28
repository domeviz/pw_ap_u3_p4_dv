package com.uce.edu.demo.controller;

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

import com.uce.edu.demo.estudiante.modelo.Estudiante;
import com.uce.edu.demo.estudiante.service.IEstudianteService;
import com.uce.edu.demo.estudiante.service.IMateriaService;
import com.uce.edu.demo.service.to.EstudianteTO;
import com.uce.edu.demo.service.to.MateriaTO;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IMateriaService materiaService;
	
	//GET
	@GetMapping(path="/{cedula}",produces=MediaType.APPLICATION_XML_VALUE)
//	@ResponseStatus(HttpStatus.CONFLICT)
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.buscarPorCedula(cedula);
	}

	@GetMapping(path="/status/{cedula}")
	public ResponseEntity<Estudiante> consultarPorCedulaStatus(@PathVariable String cedula) {
		Estudiante estudiante=this.estudianteService.buscarPorCedula(cedula);

		return ResponseEntity.status(HttpStatus.OK).body(estudiante);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(HttpStatus.CONFLICT)
	public Estudiante guardarYConsultar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		Estudiante e= this.estudianteService.buscarPorID(estudiante.getId());
		return e;
	}
	
	@GetMapping(path = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodosHATEOAS() {
		List<EstudianteTO> lista=this.estudianteService.buscarTodos();
		for (EstudianteTO estudianteTO : lista) {
            Link myLink=linkTo(methodOn(EstudianteControllerRestFul.class).buscarPorEstudiante(estudianteTO.getCedula())).withRel("materias");

            estudianteTO.add(myLink);

        }
		return new ResponseEntity<>(lista,null,228);		
	}
	
	@GetMapping(path = "/{cedula}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> buscarPorEstudiante(@PathVariable String cedula) {
		return new ResponseEntity<>(this.materiaService.buscarPorCedulaEstudiante(cedula),null,200);
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
