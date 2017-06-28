package com.davidcortijo.persistencia.impl;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.davidcortijo.modelo.Autor;
import com.davidcortijo.modelo.Libro;

public class LibrosDAO {
	
	private HibernateTemplate template;

	 public List<Libro> mostrarTodos(){
	    	String query = "select l from Libro l";
	        return (List<Libro>) template.find(query);
	    }
	 public Libro consultarLibro(String isbn) {
			String query = "select l from Libro l WHERE l.isbn = '" + isbn + "'";
			return (Libro) template.find(query).get(0);
		}
	 
	 public List<Libro> filtrarLibrosPorUnAutor(Autor a){
	    	String query = "select l from Libro l JOIN l.autores la WHERE la.id = ?";
	        return (List<Libro>) template.find(query, a.getId());
	    }
	public void altaLibro(Libro libro) {
		template.save(libro);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
}
