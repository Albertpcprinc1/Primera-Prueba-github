package com.hibernate.ferreteria;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.ferreteria.Repositorios.Repo_Articulos;
import com.hibernate.ferreteria.entity.articulos;

@SpringBootApplication
public class FerreteriaApplication implements CommandLineRunner{


	@Autowired
	private Repo_Articulos repositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(FerreteriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion iniciada correctamente");
		List<articulos>articulos = repositorio.findAll();
		//articulos.stream().forEach(articulos -> System-out.println(articulos)
		articulos.stream().forEach(System.out::println);
	}

}
