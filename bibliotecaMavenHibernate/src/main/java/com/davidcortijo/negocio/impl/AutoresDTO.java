package com.davidcortijo.negocio.impl;

import com.davidcortijo.modelo.Autor;
import com.davidcortijo.persistencia.impl.AutoresDAO;
import com.davidcortijo.persistencia.impl.LibrosDAO;

public class AutoresDTO {
	private AutoresDAO dao;
	private LibrosDAO librosDao;

	public void consultarAutores(){
        for(Autor a : dao.mostrarTodos())
            System.out.println(a.toString());
    }

    public void buscarAutor(String nombre) {
    	System.out.println("Buscando autor con nombre: " + nombre);
    	Autor autor = dao.consultarAutor(nombre);
        System.out.println("Encontrado: " + autor.toString());
        System.out.println("ID: " + autor.getId());
        //se sacan asi los libros, ya que al ser diferentes entidades, sino da error a la hora de instanciar de inicio los objetos Autor (es por culpa del toString)
      	System.out.println("Libros del autor: " + librosDao.filtrarLibrosPorUnAutor(autor).toString());
    }
    
    public void insertarAutor(Autor autor) {
    	System.out.println("Intentando persistir autor: " + autor.toString());
        dao.altaAutor(autor);
        System.out.println("Autor insertado");
    }

    public AutoresDAO getDao() {
        return dao;
    }

    public void setDao(AutoresDAO dao) {
        this.dao = dao;
    }
    
    public LibrosDAO getLibrosDao() {
		return librosDao;
	}

	public void setLibrosDao(LibrosDAO librosDao) {
		this.librosDao = librosDao;
	}
}
