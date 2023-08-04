package com.uce.edu.demo.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository iEstudianteRepository;
	
	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(20);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		this.iEstudianteRepository.insertar(estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.actualizar(estudiante);
	}

	@Override
	public void actualizarPorcedula(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.actualizarPorcedula(cedulaActual, cedulaNueva);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.borrar(id);
	}

	@Override
	public Estudiante buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarPorID(id);
	}

	@Override
	public List<EstudianteTO> buscarTodos() {
		// TODO Auto-generated method stub
		List<Estudiante> lista=this.iEstudianteRepository.buscarTodos();
		List<EstudianteTO> listaTO=lista.stream().map(estudiante->this.convertir(estudiante)).collect(Collectors.toList());
		return listaTO;
	}
	
	@Override
	public List<EstudianteTO> buscarTodosProvQuemada() {
		// TODO Auto-generated method stub
		//Provincia quemada
		List<Estudiante> lista=this.iEstudianteRepository.buscarTodosPorProvincia("azuay");
		List<EstudianteTO> listaTO=lista.stream().map(estudiante->this.convertir(estudiante)).collect(Collectors.toList());
		return listaTO;
	}

	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estudianteTO=new EstudianteTO();
		estudianteTO.setNombre(estudiante.getNombre());
		estudianteTO.setApellido(estudiante.getApellido());
		estudianteTO.setCedula(estudiante.getCedula());
		estudianteTO.setId(estudiante.getId());
		estudianteTO.setFechaNacimiento(estudiante.getFechaNacimiento());
		estudianteTO.setProvincia(estudiante.getProvincia());
		return estudianteTO;
	}
	@Override
	public List<Estudiante> buscarTodosPorProvincia(String provincia) {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarTodosPorProvincia(provincia);
	}

	@Override
	public List<Estudiante> buscarTodos2() {
		// TODO Auto-generated method stub
		return this.iEstudianteRepository.buscarTodos();
	}
}
