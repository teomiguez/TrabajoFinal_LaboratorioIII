package clases;

import java.io.Serializable;

import clasesAbstractas.ObraImpresa;

public class Libro extends ObraImpresa implements Serializable
{
	//	ATRIBUTOS.
	
	private String titulo;
	private int anioEdicion;
	private String genero;
	private String autor;
	private String descripcion;
	
	//	CONSTRUCTORES.
	
	public Libro(int id, int stock, String titulo, int anioEdicion, String genero, String autor, String descripcion)
	{
		super(id, stock);
		this.titulo = titulo;
		this.anioEdicion = anioEdicion;
		this.genero = genero;
		this.autor = autor;
		this.descripcion = descripcion;
	}
	
	//	GETTERS.
	
	public String getTitulo() 
	{  
		return titulo;  
	}
	
	public int getAnioEdicion() 
	{  
		return anioEdicion;  
	}
	
	public String getGenero() 
	{  
		return genero;  
	}
	
	public String getAutor() 
	{  
		return autor;  
	}
	
	public String getDescripcion() 
	{  
		return descripcion;  
	}
		
	//	SETTERS.
	
	public void setDescripcion(String descripcion) 
	{  
		this.descripcion = descripcion;  
	}
		
	// 	M�TODOS: 	
	// 	OVERRIDERS NECESARIOS.
	
	@Override
	public String toString() 
	{	
		return super.toString() + "\n" +
				"Libro {" + "\n" + 
				"Titulo: " + this.getTitulo() + "\n" + 
				"Anio de Edicion: " + this.getAnioEdicion() + "\n" + 
				"Genero: " + this.getGenero() + "\n" + 
				"Autor: " + this.getAutor() + "\n" + 
				"Descripcion: " + this.getDescripcion() + "\n" + 
				"}";
	}
}