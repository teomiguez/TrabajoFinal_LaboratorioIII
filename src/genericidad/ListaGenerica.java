package genericidad;

import java.util.ArrayList;

import clases.Libro;
import interfaces.I_BuscarLibro;

public class ListaGenerica <E extends Libro> implements I_BuscarLibro
{
	// ATRIBUTOS
	
	private ArrayList<E> lista; 
	
	// CONSTRUCTOR
	
	public ListaGenerica ()
	{
		this.lista = new ArrayList<>();
	}

	// METODOS
	
	public int size()
	{
		return this.lista.size();
	}
	
	public void agregarObra (E obra)
	{
		boolean flag = false;
		
		for (int i = 0; i < this.lista.size(); i++) 
		{
			
			if (this.lista.get(i).getId() == obra.getId()) // METODO "GAUCHITO" PARA EVITAR REPETIDOS
				flag = true;
			
		}
		
		if (flag != true)
			this.lista.add(obra);
		}
	
	public void sacarObra (int id)
	{
		E obra = this.buscarObra_PorId(id);
		
		this.lista.remove(obra);
	}
	
	public E buscarObra_PorId (int id)
	{
		E aux = null;
		
		for (int i = 0; i < this.lista.size(); i++) 
		{
			
			if (this.lista.get(i).getId() == id)
				aux = this.lista.get(i);
			
		}
		
		return aux;
	}
	
	public StringBuilder listar ()
	{
		StringBuilder lista = new StringBuilder();
		
		for (int i = 0; i < this.lista.size(); i++) 
		{
			
			lista.append(this.lista.get(i).toString());
			
		}
		
		return lista;
	}
	
	// OVERRIDERS NECESARIOS
	
	@Override
	public Libro buscarLibroPor_Titulo(String titulo) {

		Libro lib = null;
		
		for (int i = 0; i < this.lista.size(); i++) 
		{
			
			if (this.lista.get(i).getTitulo().equals(titulo))
				lib = this.lista.get(i);
			
		}
		
		
		return lib;
	}

	@Override
	public ListaGenerica<Libro> buscarLibrosPor_AnioEdicion(int anioEdicion) {
		
		ListaGenerica<Libro> lista = new ListaGenerica<>();
		
		for (int i = 0; i < this.lista.size(); i++) 
		{
			
			if (this.lista.get(i).getAnioEdicion() == anioEdicion)
				lista.agregarObra(this.lista.get(i));
			
		}
		
		return lista;
	}

	@Override
	public ListaGenerica<Libro> buscarLibrosPor_Autor(String autor) {
		
		ListaGenerica<Libro> lista = new ListaGenerica<>();
		
		for (int i = 0; i < this.lista.size(); i++) 
		{
			
			if (this.lista.get(i).getAutor().equals(autor))
				lista.agregarObra(this.lista.get(i));
			
		}
		
		return lista;
	}

	@Override
	public ListaGenerica<Libro> buscarLibrosPor_Genero(String genero) {

		ListaGenerica<Libro> lista = new ListaGenerica<>();
		
		for (int i = 0; i < this.lista.size(); i++) 
		{
			
			if (this.lista.get(i).getGenero().equals(genero))
				lista.agregarObra(this.lista.get(i));
			
		}
		
		return lista;
	}
	
}
