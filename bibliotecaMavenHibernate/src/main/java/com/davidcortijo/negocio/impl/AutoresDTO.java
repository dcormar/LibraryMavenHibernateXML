package com.davidcortijo.negocio.impl;

import com.davidcortijo.modelo.Autor;
import com.davidcortijo.persistencia.impl.AutoresDAO;

public class AutoresDTO {
	private AutoresDAO dao;

    public void consultarAutores(){
        for(Autor a : dao.mostrarTodos())
            System.out.println(a.toString());
    }

    public void buscarAutor(String nombre){
    	System.out.println("Buscando autor con nombre: " + nombre);
        System.out.println("Encontrado: " + dao.consultarAutor(nombre).toString());
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
}
