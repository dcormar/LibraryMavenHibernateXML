package com.davidcortijo.persistencia.impl;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.davidcortijo.modelo.Autor;

public class AutoresDAO {
		
	/*private ConnectionMgr connectionMgr;

	public ConnectionMgr getConnectionMgr() {
		return connectionMgr;
	}

	public void setConnectionMgr(ConnectionMgr connectionMgr) {
		this.connectionMgr = connectionMgr;
	}*/
	
	//private JdbcTemplate plantilla;
    //private RowMapper<Autor> autorMapper;
	
	private HibernateTemplate template;

    public List<Autor> mostrarTodos(){
    	String query = "select a from Autor a";
        return (List<Autor>) template.find(query);
    }

	/*public JdbcTemplate getPlantilla() {
		return getJdbcTemplate();
	}

	public void setPlantilla(JdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}*/

	/*public RowMapper<Autor> getAutorMapper() {
		return autorMapper;
	}*/

	/*public void setAutorMapper(RowMapper<Autor> autorMapper) {
		this.autorMapper = autorMapper;
	}*/

	public Autor consultarAutor(String nombre) {
		String query = "select a from Autor a WHERE a.nombre = '" + nombre + "'";
		return (Autor) template.find(query).get(0);
	}

	public void altaAutor(Autor autor) {
		//String sql = "insert into AUTORES values (?,?,?)";
		template.save(autor);
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
}
