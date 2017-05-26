package com.davidcortijo.persistencia.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.davidcortijo.modelo.Direccion;
import com.davidcortijo.modelo.Editorial;

public class DireccionesDAO {

	/*private ConnectionMgr connectionMgr;

	public ConnectionMgr getConnectionMgr() {
		return connectionMgr;
	}

	public void setConnectionMgr(ConnectionMgr connectionMgr) {
		this.connectionMgr = connectionMgr;
	}*/
	
	private HibernateTemplate template;
	
	//private JdbcTemplate plantilla;
    //private RowMapper<Direccion> direccionMapper;

    public List<Direccion> mostrarTodos(){
    	String query = "select D from Direccion d";
        return (List<Direccion>) template.find(query);
    }

	/*public JdbcTemplate getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(JdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}
	 */
	/*public RowMapper<Direccion> getDireccionMapper() {
		return direccionMapper;
	}

	public void setDireccionMapper(RowMapper<Direccion> direccionMapper) {
		this.direccionMapper = direccionMapper;
	}*/

	public Direccion consultarDireccion(String calle) {
		String query = "select d from Direccion d WHERE d.calle = '" + calle + "'";
		return (Direccion) template.find(query).get(0);
	}

	public void altaDireccion(Direccion direccion) {
		template.save(direccion);
	}
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
}
