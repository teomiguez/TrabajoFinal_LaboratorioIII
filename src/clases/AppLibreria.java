package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import genericidad.ListaGenerica;
import interfaces.I_BuscarLibro;

public class AppLibreria implements I_BuscarLibro
{
	// ATRIBUTOS
	
	public HashMap<String, ListaGenerica<Libro>> obrasImpresas;
	public ArrayList<ObraImpresa> librosAlquilados;
	public TreeMap <String,String> clientes;
	
	
	// CONSTRUCTORES
	
	public AppLibreria ()
	{
		// HACEMOS LOS NEW
		
		this.obrasImpresas = new HashMap<>();
		this.librosAlquilados = new ArrayList<>();
		this.clientes = new TreeMap<>();
		
		// CARGAMOS LAS COLECIONES CON LOS ARCHIVOS
	}
		
	// METODOS
	
	public ListaGenerica buscarGenero (String genero)
	{
		ListaGenerica lista = null;
		
		Iterator<Entry<String, ListaGenerica<Libro>>> filas = obrasImpresas.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			
			if (unaFila.getKey().equals(genero))
				lista = unaFila.getValue();
		}
		
		return lista;
	}
	
	// OVERRIDERS NECESARIOS
	
	@Override
	public Libro buscarLibroPor_Titulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public StringBuilder buscarLibrosPor_AnioEdicion(int anioEdicion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public StringBuilder buscarLibrosPor_Autor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public StringBuilder buscarLibrosPor_Genero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
