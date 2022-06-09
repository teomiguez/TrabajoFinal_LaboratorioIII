package clases;

public class UsuarioCliente extends Usuario
{
	
	// Atributos
	
	// private coleccionAlquilados
	private boolean bajaLogica;
	
	// Constructor
		
	public UsuarioCliente (String name, String password, String email)
	{
		super(name, password, email);
		// new de coleccion
		this.bajaLogica = false;
	}
	
	// Getters
		
	// Setters
		
	// Metodos
	
	// Overrides necesarios → equals - toString

}
