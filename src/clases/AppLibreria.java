package clases;

import interfaces.I_BuscarLibro;

public class AppLibreria implements I_BuscarLibro
{
	// Atributos
	
	// coleccion_ObrasImpresas
	// coleccion_LibrosAlquilados → todos
	// coleccion_UsuarioCliente
	
	// Constructor
	
	public AppLibreria ()
	{
		// hacemos los new
		
		// cargamos con el archivo las colecciones?	
	}
		
	// Getters
			
	// Setters
			
	// Metodos
			
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
