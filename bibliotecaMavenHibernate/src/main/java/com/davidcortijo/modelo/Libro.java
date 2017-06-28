package com.davidcortijo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("libro")
public class Libro implements Serializable{
	
	@Value("3344589134NE")
	String isbn;
	@Value("La efimera presencia de las palomas")
	String titulo;
	@Autowired
	Set <Autor> autores;
	@Autowired
	Editorial editorial;
	@Value("2007")
	int publicacion;
	@Value("14.99")
	BigDecimal precio;
	@Value("Un thriller psicologico con gran impacto en el hemisferio sur")
	String descripcion;
	
	
	
	public Libro() {
		super();
		System.out.println("Creando bean Libro: " + Integer.toHexString(System.identityHashCode(this))+ " - " + this);
	}
	
	
	public Libro(String isbn, String titulo, Set<Autor> autores, Editorial editorial, int publicacion, BigDecimal precio,
			String descripcion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autores = autores;
		this.editorial = editorial;
		this.publicacion = publicacion;
		this.precio = precio;
		this.descripcion = descripcion;
	}


	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Set<Autor> getAutores() {
		return autores;
	}
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public int getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autores=" + autores + ", editorial=" + editorial
				+ ", publicacion=" + publicacion + ", precio=" + precio + ", descripcion=" + descripcion + "]";
	}
	public void initLibro () {
		System.out.println("Inicializando libro");
	}
	public void destroyLibro () {
		System.out.println("Destruyendo libro");
	}
	
	//Metodo de sincronizacion de autores
	public void addAutor (Autor a) {
		autores.add(a);
		a.getLibros().add(this);
	}
}
