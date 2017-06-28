package com.davidcortijo.negocio.impl;


import com.davidcortijo.modelo.Editorial;
import com.davidcortijo.persistencia.impl.EditorialesDAO;

public class EditorialesDTO {

	private EditorialesDAO dao;

    public void consultarEditoriales(){
        for(Editorial e : dao.mostrarTodos())
            System.out.println(e.toString());
    }

    public void buscarEditorial(String nif){
        System.out.println(dao.consultarEditorial(nif).toString());
    }
    
    public void insertarEditorial(Editorial editorial){
    	System.out.println("Intentando persistir editorial: " + editorial.toString());
    	dao.altaEditorial(editorial);
        System.out.println("Editorial insertada");
    }

    public EditorialesDAO getDao() {
        return dao;
    }

    public void setDao(EditorialesDAO dao) {
        this.dao = dao;
    }
}
