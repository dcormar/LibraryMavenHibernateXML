package com.davidcortijo.modelo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("editorial")
public class Editorial implements Serializable{
	@Value("Las Encinas")
	String nombre;
	@Autowired
	Direccion direccion;
	@Value("F-12231256")
	String nif;
	
	List <Libro> libros;
	
	public Editorial() {
		super();
		System.out.println("Creando bean Editorial: " + Integer.toHexString(System.identityHashCode(this))+ " - " + this);
	}
	public Editorial(String nombre, Direccion direccion, String nif) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", direccion=" + direccion + ", nif=" + nif + "]";
	}
	
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	//Metodo de sincronizacion de libros
	public void addLibro (Libro l) {
		libros.add(l);
		l.setEditorial(this);
	}
}
