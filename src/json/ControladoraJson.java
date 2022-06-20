package json;

import java.util.HashMap;

import org.json.JSONObject;

import clases.AppLibreria;
import clases.Libro;
import genericidad.ListaGenerica;

public class ControladoraJson { 
	
	// ACA TRBAJAMOS CON JSON
	
	// ATRIBUTOS
	private AppLibreria app;
	
	// CONSTRUCTOR
	public ControladoraJson(AppLibreria app)
	{
		this.app = app;
	}
	
	// METODOS
	public JSONObject json_obrasImpresas() // GENERAR JSON DE obrasImpresas
	{
		JSONObject json = new JSONObject();
		
		// cuerpo
		
		return json;
		
	}
}
