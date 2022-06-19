package interfaces;

import clases.Libro;
import genericidad.ListaGenerica;

public interface I_BuscarLibro {
	
	// INTERFAZ CON != FORMAS DE BUSCAR UN LIBRO
	
	Libro buscarLibroPor_Titulo (String titulo);
	ListaGenerica<Libro> buscarLibrosPor_AnioEdicion (int anioEdicion);
	ListaGenerica<Libro> buscarLibrosPor_Autor (String autor);
	ListaGenerica<Libro> buscarLibrosPor_Genero (String genero);

}
