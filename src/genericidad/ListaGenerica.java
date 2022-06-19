package genericidad;

import java.util.HashSet;
import java.util.Iterator;

import clases.Libro;
import clasesAbstractas.ObraImpresa;
import interfaces.I_BuscarLibro;

public class ListaGenerica <E extends ObraImpresa> implements I_BuscarLibro
{
	// ATRIBUTOS
	
	private HashSet<E>lista; 
	
	// CONSTRUCTOR
	
	public ListaGenerica ()
	{
		this.lista = new HashSet<>();
	}

	// METODOS
	
	public void agregarObra (E obra)
	{
		boolean flag = false;
		Iterator<E> it = this.lista.iterator();
		
		while (it.hasNext()) // ITERO PARA RECORRER
		{
			if (it.next().getId() == obra.getId()) // COMPARO LAS IDs PARA VER SI NO ESTA DE BAJA
			{
				it.next().setBajaLogica(true); // SI LO ENCUENTRO LO "AGREGO"
				flag = true; // USO UN FLAG PARA VER SI ESTABA O NO
				
			}
		}
		if (flag == false) // SI NO ESTABA LO AGREGO
			this.lista.add(obra);
	}
	
	public void sacarObra (int id)
	{
		Iterator<E> it = this.lista.iterator();
		
		while (it.hasNext()) // ITERO PARA RECORRER
		{
			if (it.next().getId() == id) // COMPARO LAS IDs
			{
				it.next().setBajaLogica(false); // SI LO ENCUENTRO LO "SACO"
			}
		}
	}
	
	public E buscarObra_PorId (int id)
	{
		
		Iterator<E> it = this.lista.iterator();
		E aux = null;
		
		while (it.hasNext()) // BUSCO POR ID
		{
			if (it.next().getId() == id) // SI LO ENCUENTRO LO CARGO EN OBRA
			{
				aux = it.next();
			}
		}
		
		return aux;
	}
	
	public StringBuilder listar ()
	{
		StringBuilder lista = new StringBuilder();
		
		// cuerpo
		
		return lista;
	}
	
	// OVERRIDERS NECESARIOS
	
	@Override
	public Libro buscarLibroPor_Titulo(String titulo) {

		Libro lib = null;
		
		Iterator<Libro> it = (Iterator<Libro>) this.lista.iterator();
		
		while (it.hasNext())
		{
			if (it.next().getTitulo().equals(titulo))
			{
				lib = it.next();
			}
		}
		
		return lib;
	}

	@Override
	public ListaGenerica<Libro> buscarLibrosPor_AnioEdicion(int anioEdicion) {
		
		ListaGenerica<Libro> lista = new ListaGenerica<>();
		
		Iterator<Libro> it = (Iterator<Libro>) this.lista.iterator();
		
		while (it.hasNext())
		{
			if (it.next().getAnioEdicion() == anioEdicion)
			{
				lista.agregarObra(it.next());
			}
		}
		
		return lista;
	}

	@Override
	public ListaGenerica<Libro> buscarLibrosPor_Autor(String autor) {
		
		ListaGenerica<Libro> lista = new ListaGenerica<>();
		
		Iterator<Libro> it = (Iterator<Libro>) this.lista.iterator();
		
		while (it.hasNext())
		{
			if (it.next().getAutor().equals(autor))
			{
				lista.agregarObra(it.next());
			}
		}
		
		return lista;
	}

	@Override
	public ListaGenerica<Libro> buscarLibrosPor_Genero(String genero) {

		ListaGenerica<Libro> lista = new ListaGenerica<>();
		
		Iterator<Libro> it = (Iterator<Libro>) this.lista.iterator();
		
		while (it.hasNext())
		{
			if (it.next().getGenero().equals(genero))
			{
				lista.agregarObra(it.next());
			}
		}
		
		return lista;
	}
	
}
