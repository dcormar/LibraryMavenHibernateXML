package com.davidcortijo.cliente;

import org.springframework.context.ApplicationContext;

//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.davidcortijo.modelo.Autor;
import com.davidcortijo.modelo.Editorial;
import com.davidcortijo.modelo.Libro;

//import com.davidcortijo.configuracion.SpringConfigurationAuto;

import com.davidcortijo.negocio.impl.AutoresDTO;
import com.davidcortijo.negocio.impl.EditorialesDTO;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-embeddedDB-HibernateTemplate.xml");
		//ConfigurableApplicationContext  para poder usar los metodos preDestroy, etc.
		//ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationInyec_EmbeddedDB.class);
		
		EditorialesDTO editorialesDto = (EditorialesDTO) context.getBean("editorialesDTO");
		editorialesDto.buscarEditorial("221232323-G");
				
		System.out.println("Se va a dar de alta una editorial...");
		Editorial editorial1 = (Editorial) context.getBean("editorial1");
		editorialesDto.insertarEditorial(editorial1);
		
		
		AutoresDTO autoresDto = (AutoresDTO) context.getBean("autoresDTO");
		Autor autor1 = (Autor) context.getBean("autor1");
		
		System.out.println("Se va a dar de alta un nuevo autor...");
		autoresDto.insertarAutor(autor1);
		//autoresDto.consultarAutores();
			
		autoresDto.buscarAutor("Rigoberto Corbatinos");
		
		//comprobamos que el autor que se ha insertado, así como la info asociada, se ha insertado
		autoresDto.buscarAutor(autor1.getNombre());
		
		//context.close();
	}

}
