package com.uce.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.controller.MateriaControllerRestFul;

@SpringBootApplication
public class PwApiU3P4DvApplication implements CommandLineRunner {
	
	@Autowired
	private MateriaControllerRestFul materiaControllerRestFul;
	
	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P4DvApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}

}
