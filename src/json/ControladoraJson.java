package json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import clases.Libro;
import genericidad.ListaGenerica;

public class ControladoraJson {

	public static JSONObject generarJson_obrasImpresas(HashMap<String, ListaGenerica<Libro>> map)
	{
		JSONObject json = new JSONObject(); // la raiz (jsonObject)

		Iterator<Entry<String, ListaGenerica<Libro>>> filas = map.entrySet().iterator();
		while (filas.hasNext()) 
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();

			JSONArray arrayLibros = new JSONArray(); // array de los libros
				
			ListaGenerica<Libro> aux = new ListaGenerica<>();
			aux = unaFila.getValue();
				
			for (int i = 0; i < aux.size(); i++) 
			{
				
				JSONObject obj = new JSONObject(); // un jsonObject por cada libro
			
				// hacer el put de cada atributo
			
				arrayLibros.put(obj); // agregamos el "libro" al array
				
			}
			
			try 
			{
				json.put(unaFila.getKey(), arrayLibros);
			} 
			catch (JSONException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		// cuerpo

		return json;

	}
}
