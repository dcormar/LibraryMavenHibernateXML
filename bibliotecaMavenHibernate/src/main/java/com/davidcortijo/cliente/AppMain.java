package com.davidcortijo.cliente;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.davidcortijo.configuracion.SpringConfigurationInyec_EmbeddedDB;
import com.davidcortijo.modelo.Autor;

//import com.davidcortijo.configuracion.SpringConfigurationAuto;

import com.davidcortijo.negocio.impl.AutoresDTO;
import com.davidcortijo.negocio.impl.EditorialesDTO;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-embeddedDB-HibernateTemplate.xml");
		//ConfigurableApplicationContext  para poder usar los metodos preDestroy, etc.
		//ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationInyec_EmbeddedDB.class);

		AutoresDTO autoresDto = (AutoresDTO) context.getBean("autoresDTO");
		Autor autor1 = (Autor) context.getBean("autor1");
		
		autoresDto.insertarAutor(autor1);
		//autoresDto.consultarAutores();
		
		
		autoresDto.buscarAutor("Rigoberto Corbatinos");
		//autoresDto.insertarAutor("Lamonina Johnson", "Española","Pseudónimo de una conocida escritora de autoayuda española" );
		
		//EditorialesDTO editorialesDto = (EditorialesDTO) context.getBean("editorialesDTO");
		//editorialesDto.buscarEditorial("221232323-G");
		
		
		//context.close();
	}

}
