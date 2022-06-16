package json;

import app.JsonUtiles;
import clases.AppLibreria;

public class ControladoraJson {
	
	// ACA TRBAJAMOS CON JSON

	private String fuente;
	
	public ControladoraJson()
	{
		fuente = JsonUtiles.leer("file");
	}
}
