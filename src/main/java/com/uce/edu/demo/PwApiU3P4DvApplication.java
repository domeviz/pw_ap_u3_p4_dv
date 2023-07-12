package com.uce.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.controller.EstudianteControllerRestFul;

@SpringBootApplication
public class PwApiU3P4DvApplication implements CommandLineRunner {

	@Autowired
	private EstudianteControllerRestFul estudianteControllerRestFul;
	
	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P4DvApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.estudianteControllerRestFul.consultarPorCedula());
	}

}
