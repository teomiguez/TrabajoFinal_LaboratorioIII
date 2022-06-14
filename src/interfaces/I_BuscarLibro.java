package interfaces;

import clases.Libro;

public interface I_BuscarLibro {
	
	// INTERFAZ CON != FORMAS DE BUSCAR UN LIBRO
	
	Libro buscarLibroPor_Titulo (String titulo);
	StringBuilder buscarLibrosPor_AnioEdicion (int anioEdicion);
	StringBuilder buscarLibrosPor_Autor (String autor);
	StringBuilder buscarLibrosPor_Genero (String genero);

}
