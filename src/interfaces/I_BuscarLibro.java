package interfaces;

import clases.Libro;

public interface I_BuscarLibro {
	
	// INTERFAZ CON != FORMAS DE BUSCAR UN LIBRO
	
	Libro buscarLibroPor_Titulo (String titulo);
	Libro buscarLibroPor_AnioEdicion (int anioEdicion);
	Libro buscarLibroPor_Autor (String autor);
	Libro buscarLibroPor_Genero (String genero);

}
