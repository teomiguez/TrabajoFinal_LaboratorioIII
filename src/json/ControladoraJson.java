package json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
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
		HashMap<String, ListaGenerica<Libro>> map = app.getObrasImpresas();
		
		// cuerpo
		
		return json;
		
	}
}
