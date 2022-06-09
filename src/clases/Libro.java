package clases;

public class Libro extends ObraImpresa
{
	
	// Atributos
	
	private String titulo;
	private int anioEdicion;
	private String genero; // ver enum
	private String autor;
	private String descripcion;
	
	// Constructor
	
	public Libro (int id, int stock, String titulo, int anioEdicion, String genero, String autor, String descripcion)
	{
		super(id, stock);
		
		this.titulo = titulo;
		this.anioEdicion = anioEdicion;
		this.genero = genero;
		this.autor = autor;
		this.descripcion = descripcion;
	}
	
	// Getters
	
	public String getTitulo() {  return titulo;  }
	public int getAnioEdicion() {  return anioEdicion;  }
	public String getGenero() {  return genero;  }
	public String getAutor() {  return autor;  }
	public String getDescripcion() {  return descripcion;  }
		
	// Setters
	
	public void setDescripcion(String descripcion) {  this.descripcion = descripcion;  }
		
	// Metodos
		
	// Overrides necesarios → equals - toString

}
