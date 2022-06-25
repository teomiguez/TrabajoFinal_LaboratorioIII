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

public class ControladoraJson
{
	public static JSONObject generarJson_obrasImpresas(HashMap<String, ListaGenerica<Libro>> map) 
	{
		JSONObject json = new JSONObject(); //	La raiz (jsonObject) { }.
		Iterator<Entry<String, ListaGenerica<Libro>>> filas = map.entrySet().iterator(); // Convierte en filas.
		
		while(filas.hasNext()) 
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next(); //	Fila con la que se trabaja.
			JSONArray arrayLibros = new JSONArray(); //	Array de los libros.
			ListaGenerica<Libro> aux = new ListaGenerica<>();
			aux = unaFila.getValue();

			try
			{

				for(int i = 0; i < aux.size(); i++) 
				{
					JSONObject obj = new JSONObject(); //	Un jsonObject por cada libro.
					obj.put("titulo", aux.devolver_posicion(i).getTitulo());
					obj.put("anio_edicion", aux.devolver_posicion(i).getAnioEdicion());
					obj.put("genero", aux.devolver_posicion(i).getGenero());
					obj.put("autor", aux.devolver_posicion(i).getAutor());
					obj.put("descripcion", aux.devolver_posicion(i).getDescripcion());
					arrayLibros.put(obj); //	Agregamos el "libro" al array.
				}
				
				json.put(unaFila.getKey(), arrayLibros);
			} 
			catch(JSONException e) 
			{
				e.printStackTrace();
			}
		}

		// Cuerpo.

		return json;
	}
	
}