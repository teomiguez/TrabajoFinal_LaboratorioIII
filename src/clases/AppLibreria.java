package clases;

import java.io.Serializable;
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

public class AppLibreria implements Serializable
{
	//	ATRIBUTOS.
	
	private HashMap<String, ListaGenerica<Libro>> obrasImpresas; //	String -> genero.
	private ArrayList<Libro> librosAlquilados;
	private TreeMap <String,UsuarioCliente> clientes;
	
	//	CONSTRUCTORES.
	
	public AppLibreria()
	{	
		this.obrasImpresas = new HashMap<>();
		this.librosAlquilados = new ArrayList<>();
		this.clientes = new TreeMap<>();
	}
	
	//	GETTERS.
	
	public HashMap<String, ListaGenerica<Libro>> getObrasImpresas() 
	{  
		return obrasImpresas;  
	}
	
	// 	M�TODOS: 
	//	LOGIN USUARIO. 
	
	public boolean loginUsuario(String usuario, String password) throws E_UsuarioInvalido, E_ContraseniaInvalida 
	{
		boolean rta = false;
		int intentos = 0;
		
		if(this.buscarUsuario_EnClientes(usuario) != null)
		{
			UsuarioCliente user = this.buscarUsuario_EnClientes(usuario);
				
			if (this.verificarBajaLogica(user)) 
			{
				if(this.verificarPassword(user, password, intentos));
				{
					rta = true;
				}
			}
		}
		
		return rta;
	}
		
	
	//	REGISTRAR USUARIO.
	
	public boolean registerUsuario(String email, String usuario, String password) throws E_UsuarioExistente
	{
		boolean rta = false;
		
		UsuarioCliente user = this.crearUsuario(email, usuario, password);
		
		if(!this.buscarUsuarioParaAgregar(usuario))
		{
			this.agregarUsuario(user);
			rta = true;
		}
		
		return rta;
	}
	
	// BUSCAR MAYOR ID
	
	public int buscarMayorId()
	{
		int idex = 0;
		
		for (int i = 1; i < 100000000; i++) // LA CHANCHADA DEL DIA
		{
			Libro lib = this.buscarPorID_EnObrasImpresas(i);
			
			if (lib == null)
				return i;
		}
		
		return idex;
	}
	
	//	CREAR USUARIO.

	public UsuarioCliente crearUsuario(String email, String usuario, String password)
	{
		UsuarioCliente user = new UsuarioCliente(usuario, password, email);
		
		return user;
	}
	
	//	CREAR LIBRO.
	
	public Libro crearLibro(int id, int stock, String titulo, int anioEdicion, String genero, String autor, String descripcion)
	{
		Libro libro = new Libro(id, stock, titulo, anioEdicion, genero, autor, descripcion);
		
		return libro;
	}
	
	//	AGREGAR USUARIO/LIBRO.
	
	public boolean agregarUsuario(UsuarioCliente user)
	{
		boolean rta = false;
		
		try 
		{
			if(!this.buscarUsuarioParaAgregar(user.getName()))
			{
				this.clientes.put(user.getName(), user);
				rta = true;
			}
		} 
		catch(E_UsuarioExistente e) 
		{
			System.out.println(e.getMessage());
		}
		
		return rta;
	}
	
	public boolean agregarLibro(Libro libro)
	{
		boolean rta = false;
		
		if(this.buscarPorID_EnObrasImpresas(libro.getId()) == null)
		{
			if(this.obrasImpresas.containsValue(libro.getGenero())) //	Si contiene el genero.
			{
				ListaGenerica <Libro> lista = this.buscarPorGenero_EnObrasImpresas(libro.getGenero());
				lista.agregarObra(libro);
				this.obrasImpresas.replace(libro.getGenero(), lista);
				rta = true;
			}
			else //	Si no lo contiene.
			{
				ListaGenerica <Libro> lista2 = new ListaGenerica<Libro>();
				lista2.agregarObra(libro);
				this.obrasImpresas.put(libro.getGenero(), lista2);
				rta = true;
			}
		}
		
		return rta;
	}
	
	// CREAR Y AGREGAR LIBRO
	
	public boolean crearYagregarLibro (int stock, String titulo, int anioEdicion, String genero, String autor, String descripcion)
	{
		boolean rta = false;
		
		Libro lib = this.crearLibro(this.buscarMayorId(), stock, titulo, anioEdicion, genero, autor, descripcion);
		
		rta = this.agregarLibro(lib);
		
		return rta;
	}
	
	//	DAR BAJA/ALTA UN LIBRO/USUARIO.
		
	public boolean darDeBaja_Usuario(String user)
	{
		boolean rta = false;
		UsuarioCliente usuario = null;
		
		try 
		{
			usuario = this.buscarUsuario_EnClientes(user);
		} 
		catch(E_UsuarioInvalido e) 
		{
			System.out.println(e.getMessage());
		}
		
		if(usuario != null) 
		{
			usuario.setBajaLogica(true);
			this.clientes.put(usuario.getName(), usuario);
			rta = true;
		}
		
		return rta;
	}
	
	public boolean darDeAlta_Usuario(String user)
	{
		boolean rta = false;
		UsuarioCliente usuario = null;
		
		try 
		{
			usuario = this.buscarUsuario_EnClientes(user);
		} 
		catch(E_UsuarioInvalido e) 
		{
			System.out.println(e.getMessage());
		}
		
		if(usuario != null)
		{
			usuario.setBajaLogica(false);
			this.clientes.put(usuario.getName(), usuario);
			rta = true;
		}
		
		return rta;
	}
	
	public boolean darDeBaja_Libro(int id)
	{
		boolean rta = false;
		Libro libro = null;
		libro = this.buscarPorID_EnObrasImpresas(id);
		
		if (libro != null)
		{
			libro.setBajaLogica(true);
			this.agregarLibro(libro);
			ListaGenerica <Libro> lista = this.buscarPorGenero_EnObrasImpresas(libro.getGenero());
			lista.agregarObra(libro);
			this.obrasImpresas.replace(libro.getGenero(), lista);
			rta = true;
		}
		
		return rta;
	}
	
	public boolean darDeAlta_Libro(int id)
	{
		boolean rta = false;
		Libro libro = null;
		libro = this.buscarPorID_EnObrasImpresas(id);
		
		if(libro != null)
		{
			libro.setBajaLogica(false);
			this.agregarLibro(libro);
			ListaGenerica <Libro> lista = this.buscarPorGenero_EnObrasImpresas(libro.getGenero());
			lista.agregarObra(libro);
			this.obrasImpresas.replace(libro.getGenero(), lista);	
			rta = true;
		}
		
		return rta;
	}
	
	//	ALQUILAR/DEVOLVER.
		
	public boolean alquilarLibro(int id, String usuario)
	{
		boolean rta = false;
		UsuarioCliente user = null;
		Libro libro = null;
		int stock;
		int alquiler;
		libro = this.buscarPorID_EnObrasImpresas(id);
		
		try 
		{
			user = this.buscarUsuario_EnClientes(usuario);
		} 
		catch(E_UsuarioInvalido e) 
		{
			System.out.println(e.getMessage());
		}
		
		if(libro != null && user != null)
		{
			//	Trabajo en obrasImpresas.
			
			stock = libro.getInStock();
			
			if (stock > 0)
			{
				alquiler = libro.getInAlquiler();
				libro.setInStock(stock--);
				libro.setInAlquiler(alquiler++);
				ListaGenerica <Libro> lista = this.buscarPorGenero_EnObrasImpresas(libro.getGenero());
				lista.agregarObra(libro);
				this.obrasImpresas.replace(libro.getGenero(), lista);
				
				//	Trabajo en librosAlquilados.
				
				this.librosAlquilados.add(libro);
				
				//	Trabajo en el usuario.
				
				ListaGenerica<Libro> listaUser = user.getAlquilados();
				listaUser.agregarObra(libro);
				user.setAlquilados(listaUser);
				
				return true;
			}
			else
			{
				return false;
			}
		}
		
		return rta;
	}
	
	public boolean devolverLibro(int id, String usuario)
	{
		boolean rta = false;
		UsuarioCliente user = null;
		Libro libro = null;
		int stock;
		int alquiler;
		libro = this.buscarPorID_EnObrasImpresas(id);
		
		try 
		{
			user = this.buscarUsuario_EnClientes(usuario);
		} 
		catch(E_UsuarioInvalido e) 
		{
			System.out.println(e.getMessage());
		}
		
		if(libro != null && user != null)
		{
			//	Trabajo en obrasImpresas.
			
			stock = libro.getInStock();
			alquiler = libro.getInAlquiler();
			libro.setInStock(stock++);
			libro.setInAlquiler(alquiler--);
			ListaGenerica <Libro> lista = this.buscarPorGenero_EnObrasImpresas(libro.getGenero());
			lista.agregarObra(libro);
			this.obrasImpresas.replace(libro.getGenero(), lista);
			
			// Trabajo en librosAlquilados.
			
			this.librosAlquilados.remove(libro);
			
			// Trabajo en el usuario.
			
			user.alquilados.sacarObra(id);
			
			rta = true;
		}
		
		return rta;
	}
	
	// LISTAR obrasImpresas.
	
	public StringBuilder listar_obrasImpresas()
	{
		StringBuilder str = new StringBuilder();
		//Libro libro = null; �No se usa?		
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while(filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			str.append("GENERO: " + unaFila.getKey());
			ListaGenerica<Libro> lista = unaFila.getValue();
			str.append(lista.listar());
		}
		
		return str;
	}
	
	// LISTAR librosAlquilados.
	
	public StringBuilder listar_librosAlquilados()
	{
		StringBuilder str = new StringBuilder();
		
		for(int i=0 ; i < this.librosAlquilados.size() ; i++)
		{
			str.append(this.librosAlquilados.get(i).toString());
		}
		
		return str;
	}
	
	//	BUSCAR EN obrasImpresas.	
	// 	POR id.
	
	public Libro buscarPorID_EnObrasImpresas(int id)
	{
		Libro libro = null;
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while(filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			
			if(libro == null) 
			{
				libro = unaFila.getValue().buscarObra_PorId(id);
			}
		}
		
		return libro;
	}
	
	//	POR titulo.
	
	public Libro buscarPorTitulo_EnObrasImpresas(String titulo)
	{
		Libro libro = null;
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while(filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			
			if(libro == null)
			{
				libro = unaFila.getValue().buscarLibroPor_Titulo(titulo);
			}
		}
		
		return libro;
	}
	
	//	POR anioEdicion.
	
	public ListaGenerica<Libro> buscarPorAnioEdicion_EnObrasImpresas(int anioEdicion)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while(filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			lista = unaFila.getValue().buscarLibrosPor_AnioEdicion(anioEdicion);
		}
		
		return lista;
	}
	
	//	POR genero.
	
	public ListaGenerica<Libro> buscarPorGenero_EnObrasImpresas(String genero)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while(filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			
			if(unaFila.getKey().equals(genero))
			{
				lista = unaFila.getValue();
			}
		}
		
		return lista;
	}
	
	//	POR autor.
	
	public ListaGenerica<Libro> buscarPorAutor_EnObrasImpresas(String autor)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		Iterator <Entry<String, ListaGenerica<Libro>>> filas = this.obrasImpresas.entrySet().iterator();
		
		while(filas.hasNext())
		{
			Map.Entry<String, ListaGenerica<Libro>> unaFila = filas.next();
			lista = unaFila.getValue().buscarLibrosPor_Autor(autor);
		}
		
		return lista;
	}
	
	//	BUSCAR EN librosAlquilados.
	// 	POR titulo.
	
	public Libro buscarPorTitulo_EnlibrosAlquilados(String titulo)
	{
		Libro libro = null;
		
		for( int i=0 ; i<this.librosAlquilados.size() ; i++)
		{
			if(this.librosAlquilados.get(i).getTitulo().equals(titulo))
			{
				libro = this.librosAlquilados.get(i);
			}
		}
		
		return libro;
	}
	
	//	POR anioEdicion.
	
	public ListaGenerica<Libro> buscarPorAnioEdicion_EnlibrosAlquilados(int anioEdicion)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		
		for(int i=0 ; i<this.librosAlquilados.size() ; i++)
		{
			if(this.librosAlquilados.get(i).getAnioEdicion() == anioEdicion)
			{
				lista.agregarObra(this.librosAlquilados.get(i));
			}
		}
		
		return lista;
	}
	
	//	POR genero.
	
	public ListaGenerica<Libro> buscarPorGenero_EnlibrosAlquilados(String genero)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		
		for(int i=0 ; i<this.librosAlquilados.size() ; i++)
		{
			if(this.librosAlquilados.get(i).getGenero().equals(genero))
			{
				lista.agregarObra(this.librosAlquilados.get(i));
			}
		}
		
		return lista;
	}
	
	//	POR autor.
	
	public ListaGenerica<Libro> buscarPorAutor_EnlibrosAlquilados(String autor)
	{
		ListaGenerica<Libro> lista = new ListaGenerica<Libro>();
		
		for(int i=0 ; i<this.librosAlquilados.size() ; i++)
		{
			if(this.librosAlquilados.get(i).getAutor().equals(autor))
			{
				lista.agregarObra(this.librosAlquilados.get(i));
			}
		}
		
		return lista;
	}
	
	//	BUSCAR EN clientes.
	//	POR usuario.
	
	public UsuarioCliente buscarUsuario_EnClientes(String usario) throws E_UsuarioInvalido
	{
		UsuarioCliente usuario = null;
		Iterator<Entry<String, UsuarioCliente>> filas = this.clientes.entrySet().iterator();
		
		while(filas.hasNext())
		{
			Map.Entry<String, UsuarioCliente> unaFila = filas.next();
			
			if(unaFila.getKey().equals(usario))
			{
				usuario = unaFila.getValue();
			}
		}
		
		if(usuario == null)
		{
			throw new E_UsuarioInvalido("El usuario no esta registrado.-");
		}
		
		return usuario;
	}
	
	public boolean buscarUsuarioParaAgregar(String usario) throws E_UsuarioExistente
	{
		boolean existe = false;
		Iterator<Entry<String, UsuarioCliente>> filas = this.clientes.entrySet().iterator();
		
		while(filas.hasNext())
		{
			Map.Entry<String, UsuarioCliente> unaFila = filas.next();
			
			if(unaFila.getKey().equals(usario))
			{
				existe = true;
			}
		}
		
		if(existe == true)
		{
			throw new E_UsuarioExistente("El usuario ya esta registrado.-");
		}
		
		return existe;
	}
	
	//	POR email.
	
	public UsuarioCliente buscarUsuarioPorEmail_EnClientes(String email) throws E_EmailInvalido
	{
		UsuarioCliente usuario = null;
		Iterator<Entry<String, UsuarioCliente>> filas = this.clientes.entrySet().iterator();
		
		while(filas.hasNext())
		{
			Map.Entry<String, UsuarioCliente> unaFila = filas.next();
			
			if(unaFila.getValue().getEmail().equals(email))
			{
				usuario = unaFila.getValue();
			}
		}
		return usuario;
	}
	
	// VERIFICAR password.
	
	public boolean verificarPassword(UsuarioCliente user, String password, int intentos) throws E_ContraseniaInvalida
	{
		if (user.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			throw new E_ContraseniaInvalida("La password es invalida.-");
		}
	}
	
	// VERIFICAR bajaLogica
	public boolean verificarBajaLogica (UsuarioCliente user) throws E_UsuarioInvalido
	{
		if (user.isBajaLogica() == false)
		{
			return true;
		}
		else
		{
			throw new E_UsuarioInvalido("El usuario esta de baja");
		}
	}
}