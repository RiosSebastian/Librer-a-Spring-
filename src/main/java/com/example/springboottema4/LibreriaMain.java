package com.example.springboottema4;

import com.example.springboottema4.entity.Libros;
import com.example.springboottema4.repository.LibrosRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibreriaMain {

	public static void main(String[] args) {

		ApplicationContext contex=SpringApplication.run(LibreriaMain.class, args);
		/*LibrosRepository repository = contex.getBean(LibrosRepository.class);

		//CREAR libro
		Libros libros1 = new Libros(null, "La odisea","homer", "500" , "hshshshshhshsh");
		Libros libros2 = new Libros(null, "El principito","homer", "500" , "hshshshshhshsh");

		//ALMACENAR Libro
		System.out.println("numero de libros en la base de datos " + repository.findAll().size());
		repository.save(libros1);
		repository.save(libros2);
		System.out.println("numero de libros en la base de datos " + repository.findAll().size());

		//BORRAR libro
		//repository.deleteById(1l);
		System.out.println("numero de libros en la base de datos " + repository.findAll().size());*/
	}

}
