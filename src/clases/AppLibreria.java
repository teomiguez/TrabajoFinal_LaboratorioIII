package clases;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import java.util.TreeMap;

import excepciones.E_EmailInvalido;
import excepciones.E_ContraseniaInvalida;
import excepciones.E_UsuarioExistente;
import excepciones.E_UsuarioInvalido;
import genericidad.ListaGenerica;

public class AppLibreria
{
	// ATRIBUTOS
	
	private HashMap<String, ListaGenerica<Libro>> obrasImpresas; // String -> genero
	private ArrayList<Libro> librosAlquilados;
	private TreeMap <String,UsuarioCliente> clientes;
	
	
	// CONSTRUCTORES
	
	public AppLibreria ()
	{
		// HACEMOS LOS NEW
		
		this.obrasImpresas = new HashMap<>();
		this.librosAlquilados = new ArrayList<>();
		this.clientes = new TreeMap<>();
		
		// CARGAMOS LAS COLECIONES CON LOS ARCHIVOS
		
		
	}
	
	// GETTERS
	
	// SETTERS
	
	
	// --------------------------
	//   METODO - LOGIN USUARIO
	// --------------------------
	
	public boolean loginUsuario(String usuario, String password)
	{
		boolean rta = false;
		int intentos = 0;
		
		try 
		{
			if (this.buscarUsuario_EnClientes(usuario) != null)
			{
				UsuarioCliente user = this.buscarUsuario_EnClientes(usuario);
				
				if (this.verificarPassword(user, password, intentos));
					rta = true;
			}
		} catch (E_UsuarioInvalido e) 
		{
			System.out.println(e.getMessage());
		} catch (E_ContraseniaInvalida e) 
		{
			System.out.println(e.getMessage());
		}
		
		return rta;
	}
	
	// ------------------------------
	//   METODO - REGISTRAR USUARIO
	// ------------------------------
	
	public boolean registerUsuario(String email, String usuario, String password)
	{
		boolean rta = false;
		
		UsuarioCliente user = this.crearUsuario(email, usuario, password);
		
		try 
		{
			if (!this.buscarUsuarioParaAgregar(usuario))
			{
				this.agregarUsuario(user);
				rta = true;
			}
		} catch (E_UsuarioExistente e) 
		{
			System.out.println(e.getMessage());
		}
		
		return rta;
	}
	
	// --------------------------
	//   METODO - CREAR USUARIO
	// --------------------------
	
	public UsuarioCliente crearUsuario(String email, String usuario, String password)
	{
		UsuarioCliente user = new UsuarioCliente(usuario, password, email);
		
		return user;
	}
	
	// ------------------------
	//   METODO - CREAR LIBRO
	// ------------------------
	
	public Libro crearLibro(int id, int stock, String titulo, int anioEdicion, String genero, String autor, String descripcion)
	{
		Libro libro = new Libro(id, stock, titulo, anioEdicion, genero, autor, descripcion);
		
		return libro;
	}
	
	// -----------------------------------
	//   METODOS - AGREGAR USUARIO/LIBRO
	// -----------------------------------
	
	public boolean agregarUsuario (UsuarioCliente user)
	{
		boolean rta = false;
		
		try 
		{
			if (!this.buscarUsuarioParaAgregar(user.getName()))
			{
				this.clientes.put(user.getName(), user);
			}
		} catch (E_UsuarioExistente e) 
		{
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	public boolean agregarLibro (Libro libro)
	{
		boolean rta = false;
		
		if (this.buscarPorID_EnObrasImpresas(libro.getId()) == null)
		{
			if(this.obrasImpresas.containsValue(libro.getGenero())) // si contiene el genero
			{
				ListaGenerica <Libro> lista = this.buscarPorGenero_EnObrasImpresas(libro.getGenero());
				lista.agregarObra(libro);
				
				this.obrasImpresas.replace(libro.getGenero(), lista);
				
				rta = true;
			}
			else // si no lo contiene
			{
				ListaGenerica <Libro> lista2 = new ListaGenerica<Libro>();
				lista2.agregarObra(libro);
				
				this.obrasImpresas.put(libro.getGenero(), lista2);
				
				rta = true;
			}
		}
		
		return false;
	}
	
	// --------------------------------------------
	//   METODOS - DAR BAJA/ALTA UN LIBRO/USUARIO
	// --------------------------------------------
		
	public boolean darDeBaja_Usuario (String user)
	{
		boolean rta = false;
		
		// cuerpo
		
		return rta;
	}
	
	public boolean darDeAlta_Usuario (String user)
	{
		boolean rta = false;
		
		// cuerpo
		
		return rta;
	}
	
	public boolean darDeBaja_Libro (int id)
	{
		boolean rta = false;
		
		// cuerpo
		
		return rta;
	}
	
	public boolean darDeAlta_Libro (int id)
	{
		boolean rta = false;
		
		// cuerpo
		
		return rta;
	}
	
	// -------------------------------
	//   METODOS - ALQUILAR/DEVOLVER
	// -------------------------------
		
	public boolean alquilarLibro (int id)
	{
		boolean rta = false;
		
		// cuerpo
		
		return rta;
	}
	
	public boolean devolverLibro (int id)
	{
		boolean rta = false;
		
		// cuerpo
		
		return rta;
	}
	
	// --------------------
	//   METODOS - LISTAR
	// --------------------
	
	// LISTAR obrasImpresas
	
	public static StringBuilder listar_obrasImpresas()
	{
		StringBuilder str = new StringBuilder();
		
		// cuerpo
		
		return str;
	}
	
	// LISTAR librosAlquilados
	
	public static StringBuilder listar_librosAlquilados()
	{
		StringBuilder str = new StringBuilder();
		
		// cuerpo
		
		return str;
	}
	
	// LISTAR clientes
	
	public static StringBuilder listar_clientes()
	{
		StringBuilder str = new StringBuilder();
		
		// cuerpo
		
		return str;	
	}
	
	// --------------------
	//   METODOS - BUSCAR
	// --------------------
	
	// -----------------------------
	//    BUSCAR EN obrasImpresas
	// -----------------------------
	
	// buscar por id
	
	public Libro buscarPorID_EnObrasImpresas(int id)
	{
		Libro libro = null;
		
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			
			if (libro == null)
				libro = unaFila.getValue().buscarObra_PorId(id);
		}
		
		return libro;
	}
	
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
	
	public UsuarioCliente buscarUsuario_EnClientes(String usario) throws E_UsuarioInvalido
	{
		UsuarioCliente usuario = null;
		
		Iterator<Entry<String, UsuarioCliente>> filas = this.clientes.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Map.Entry<String, UsuarioCliente> unaFila = filas.next();
			
			if (unaFila.getKey().equals(usario))
				usuario = unaFila.getValue();
		}
		
		if (usuario == null)
			throw new E_UsuarioInvalido("El usuario no esta registrado.-");
		
		return usuario;
	}
	
	public boolean buscarUsuarioParaAgregar(String usario) throws E_UsuarioExistente
	{
		boolean existe = false;
		
		Iterator<Entry<String, UsuarioCliente>> filas = this.clientes.entrySet().iterator();
		
		while (filas.hasNext())
		{
			Map.Entry<String, UsuarioCliente> unaFila = filas.next();
			
			if (unaFila.getKey().equals(usario))
				existe = true;;
		}
		
		if (existe == true)
			throw new E_UsuarioExistente("El usuario ya esta registrado.-");
		
		return existe;
	}
	
	// buscar por email
	
	public UsuarioCliente buscarUsuarioPorEmail_EnClientes(String email) throws E_EmailInvalido
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
	
	// verificar password
	
	public boolean verificarPassword (UsuarioCliente user, String password, int intentos) throws E_ContraseniaInvalida
	{
		if (user.getPassword().equals(password))
		{
			return true;
		}else
		{
			throw new E_ContraseniaInvalida("La password es invalida.-", intentos++);
		}
	}
	
}
