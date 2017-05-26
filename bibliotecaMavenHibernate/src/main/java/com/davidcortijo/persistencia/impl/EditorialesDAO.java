package com.davidcortijo.persistencia.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.davidcortijo.modelo.Autor;
import com.davidcortijo.modelo.Editorial;


public class EditorialesDAO {
	
	/*private ConnectionMgr connectionMgr;

	public ConnectionMgr getConnectionMgr() {
		return connectionMgr;
	}

	public void setConnectionMgr(ConnectionMgr connectionMgr) {
		this.connectionMgr = connectionMgr;
	}*/
	
	//private JdbcTemplate plantilla;
    //private RowMapper<Editorial> editorialMapper;
	
	private HibernateTemplate template;

    public List<Editorial> mostrarTodos(){
    	String query = "select e from Editorial e";
        return (List<Editorial>) template.find(query);
    }

	/*public JdbcTemplate getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(JdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}*/

	/*public RowMapper<Editorial> getEditorialMapper() {
		return editorialMapper;
	}

	public void setEditorialMapper(RowMapper<Editorial> editorialMapper) {
		this.editorialMapper = editorialMapper;
	}*/

	public Editorial consultarEditorial(String nif) {
		String query = "select e from Editorial e WHERE e.nif = '" + nif + "'";
		return (Editorial) template.find(query).get(0);
	}

	public void altaEditorial(Editorial editorial) {
		template.save(editorial);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
}
