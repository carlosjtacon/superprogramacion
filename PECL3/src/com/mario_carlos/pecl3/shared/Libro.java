package com.mario_carlos.pecl3.shared;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Libro implements Serializable {
	
	@Persistent
	private String titulo;
	@Persistent
	private String autores;
	@Persistent
	private String edicion;
	@Persistent
	private String resumen;
	@Persistent
	private String editor;
	@Persistent
	private String fecha_p;
	@Persistent
	private String paginas;
	@PrimaryKey
	@Persistent
	private String isbn;
	@Persistent
	private String enlace;
	@Persistent
	private String materia;
	@Persistent
	private String portada;
	@Persistent
	private String copias;
	
	
	public Libro(String titulo, String autores, String edicion,
			String resumen, String editor, String fecha_p, String paginas,
			String isbn, String enlace, String materia, String portada,
			String copias) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.edicion = edicion;
		this.resumen = resumen;
		this.editor = editor;
		this.fecha_p = fecha_p;
		this.paginas = paginas;
		this.isbn = isbn;
		this.enlace = enlace;
		this.materia = materia;
		this.portada = portada;
		this.copias = copias;
	}
	public Libro() {
		super();
		this.titulo = "";
		this.autores = "";
		this.edicion = "";
		this.resumen = "";
		this.editor = "";
		this.fecha_p = "";
		this.paginas = "";
		this.isbn = "";
		this.enlace = "";
		this.materia = "";
		this.portada = "";
		this.copias = "";
	}
	//getters and setters 
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getFecha_p() {
		return fecha_p;
	}
	public void setFecha_p(String fecha_p) {
		this.fecha_p = fecha_p;
	}
	public String getPaginas() {
		return paginas;
	}
	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getPortada() {
		return portada;
	}
	public void setPortada(String portada) {
		this.portada = portada;
	}
	public String getCopias() {
		return copias;
	}
	public void setCopias(String copias) {
		this.copias = copias;
	}
	
	
}
