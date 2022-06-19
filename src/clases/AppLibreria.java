package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import java.util.TreeMap;

import genericidad.ListaGenerica;

public class AppLibreria
{
	// ATRIBUTOS
	
	public HashMap<String, ListaGenerica<Libro>> obrasImpresas; // String -> genero
	public ArrayList<Libro> librosAlquilados;
	public TreeMap <String,UsuarioCliente> clientes;
	
	
	// CONSTRUCTORES
	
	public AppLibreria ()
	{
		// HACEMOS LOS NEW
		
		this.obrasImpresas = new HashMap<>();
		this.librosAlquilados = new ArrayList<>();
		this.clientes = new TreeMap<>();
		
		// CARGAMOS LAS COLECIONES CON LOS ARCHIVOS
		
		
	}
		
	// --------------------
	//   METODOS - LISTAR
	// --------------------
	
	// LISTAR obrasImpresas
	
	public StringBuilder listar_obrasImpresas()
	{
		
	}
	
	// LISTAR librosAlquilados
	
	public StringBuilder listar_obrasImpresas()
	{
		
	}
	
	// LISTAR clientes
	
	public StringBuilder listar_obrasImpresas()
	{
		
	}
	
	// --------------------
	//   METODOS - BUSCAR
	// --------------------
	
	// -----------------------------
	//    BUSCAR EN obrasImpresas
	// -----------------------------
	
	// buscar por titulo
	
	public Libro buscarPorTitulo_EnObrasImpresas(String titulo)
	{
		Libro libro = null;
		
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			
			if (libro == null)
				libro = unaFila.getValue().buscarLibroPor_Titulo(titulo);
		}
		
		return libro;
	}
	
	// buscar por anioEdicion
	
	public ListaGenerica<Libro> buscarPorAnioEdicion_EnObrasImpresas(int anioEdicion)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			
			lista = unaFila.getValue().buscarLibrosPor_AnioEdicion(anioEdicion);
		}
		
		return lista;
	}
	
	// buscar por genero
	
	public ListaGenerica<Libro> buscarPorGenero_EnObrasImpresas(String genero)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			
			if (unaFila.getKey().equals(genero))
				lista = unaFila.getValue();
		}
		
		return lista;
	}
	
	// buscar por autor
	
	public ListaGenerica<Libro> buscarPorAutor_EnObrasImpresas(String autor)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			
			lista = unaFila.getValue().buscarLibrosPor_Autor(autor);
		}
		
		return lista;
	}
	
	
	// -------------------------------
	//    BUSCAR EN librosAlquilados
	// -------------------------------
	
	// buscar por titulo
	
	public Libro buscarPorTitulo_EnlibrosAlquilados(String titulo)
	{
		Libro libro = null;
		
		for( int i=0 ; i<this.librosAlquilados.size() ; i++)
		{
			if (this.librosAlquilados.get(i).getTitulo().equals(titulo))
				libro = this.librosAlquilados.get(i);
		}
		
		return libro;
	}
	
	// buscar por anioEdicion
	
	public ListaGenerica<Libro> buscarPorAnioEdicion_EnlibrosAlquilados(int anioEdicion)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		
		for( int i=0 ; i<this.librosAlquilados.size() ; i++)
		{
			if (this.librosAlquilados.get(i).getAnioEdicion() == anioEdicion)
				lista.agregarObra(this.librosAlquilados.get(i));
		}
		
		return lista;
	}
	
	// buscar por genero
	
	public ListaGenerica<Libro> buscarPorGenero_EnlibrosAlquilados(String genero)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		
		for( int i=0 ; i<this.librosAlquilados.size() ; i++)
		{
			if (this.librosAlquilados.get(i).getGenero().equals(genero))
				lista.agregarObra(this.librosAlquilados.get(i));
		}
		
		return lista;
	}
	
	// buscar por autor
	
	public ListaGenerica<Libro> buscarPorAutor_EnlibrosAlquilados(String autor)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		
		for( int i=0 ; i<this.librosAlquilados.size() ; i++)
		{
			if (this.librosAlquilados.get(i).getAutor().equals(autor))
				lista.agregarObra(this.librosAlquilados.get(i));
		}
		
		return lista;
	}
	
	// -----------------------------
	//    BUSCAR EN clientes
	// -----------------------------
	
	// buscar por usuario
	
	public UsuarioCliente buscarUsuario_EnClientes(String usario)
	{
		UsuarioCliente usuario = null;
		
		Iterator<Entry<String, UsuarioCliente>> filas = this.clientes.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Map.Entry<String, UsuarioCliente> unaFila = filas.next();
			
			if (unaFila.getKey().equals(usario))
				usuario = unaFila.getValue();
		}
		return usuario;
	}
	
	// buscar por email
	
	public UsuarioCliente buscarUsuarioPorEmail_EnClientes(String email)
	{
		UsuarioCliente usuario = null;
		
		Iterator<Entry<String, UsuarioCliente>> filas = this.clientes.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Map.Entry<String, UsuarioCliente> unaFila = filas.next();
			
			if (unaFila.getValue().getEmail().equals(email))
				usuario = unaFila.getValue();
		}
		return usuario;
	}
	
}
