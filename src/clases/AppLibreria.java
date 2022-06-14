package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import genericidad.ListaGenerica;
import interfaces.I_BuscarLibro;

public class AppLibreria implements I_BuscarLibro
{
	// Atributos
	
	public HashMap<String,ListaGenerica> obrasImpresas;
	public ArrayList<ObraImpresa> librosAlquilados;
	public TreeMap <String,String> clientes;
	
	
	// Constructor
	public AppLibreria ()
	{
		// hacemos los new
		this.obrasImpresas = new HashMap<>();
		this.librosAlquilados = new ArrayList<>();
		this.clientes = new TreeMap<>();
		// cargamos con el archivo las colecciones?	
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
