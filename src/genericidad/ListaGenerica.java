package genericidad;

import clases.Libro;
import clases.ObraImpresa;
import interfaces.I_BuscarLibro;

public class ListaGenerica <E extends ObraImpresa> implements I_BuscarLibro
{
	
	// Atributos
	
	// coleccion<E>
	
	// Constructor
	
	public ListaGenerica ()
	{
		// el new de la coleccion
	}
		
	// Getters
		
	// Setters
		
	// Metodos
	
	public void agregarObra (E obra)
	{
		// cuerpo
	}
	
	public void sacarObra (int id)
	{
		// cuerpo
	}
	
	public ObraImpresa buscarObra (int id)
	{
		ObraImpresa aux;
		
		// cuerpo
		
		return aux;
	}
	
	public StringBuilder listar ()
	{
		StringBuilder lista = new StringBuilder();
		
		// cuerpo
		
		return lista;
	}
	
	// Overrides necesarios
	
	@Override
	public Libro buscarLibroPor_Titulo(String titulo) {
		
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Libro buscarLibroPor_AnioEdicion(int anioEdicion) {
		
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Libro buscarLibroPor_Autor(String autor) {
		
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Libro buscarLibroPor_Genero(String genero) {
		
		// TODO Auto-generated method stub
		
		return null;
	}

}
