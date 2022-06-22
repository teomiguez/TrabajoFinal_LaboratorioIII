package json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
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
	public ControladoraJson(AppLibreria app) {
		this.app = app;
	}

	// METODOS
	public JSONObject json_obrasImpresas() // GENERAR JSON DE obrasImpresas
	{
		JSONObject json = new JSONObject();
		HashMap<String, ListaGenerica<Libro>> map = app.getObrasImpresas();

		Iterator<Entry<String, ListaGenerica<Libro>>> filas = map.entrySet().iterator();
		while (filas.hasNext()) {
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			try {
				JSONArray arrayLibros = new JSONArray();
				ListaGenerica<Libro> aux = new ListaGenerica<>();
				json.put(unaFila.getKey(), aux);
				
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// cuerpo

		return json;

	}
}
