package json;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.json.JSONObject;

import app.JsonUtiles;
import clases.AppLibreria;
import clases.Libro;
import clases.UsuarioCliente;
import clasesAbstractas.ObraImpresa;
import genericidad.ListaGenerica;

public class ControladoraJson { 
	
	// ACA TRBAJAMOS CON JSON
	
	// ATRIBUTOS
	private HashMap<String, ListaGenerica<Libro>> map;
	
	// CONSTRUCTOR
	public ControladoraJson(HashMap map)
	{
		this.map = map;
	}
	
	// METODOS
	public static JSONObject json_obrasImpresas()
	{
		JSONObject json = new JSONObject();
		
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.map.entrySet().iterator();
		
		// GENERAR JSON DEL HASMAP (obrasImpresas)
		
		return json;
		
	}
}
