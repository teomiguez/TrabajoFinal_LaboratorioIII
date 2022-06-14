package clases;

public class UsuarioCliente extends Usuario {

	// Atributos

	// private coleccionAlquilados
	private boolean bajaLogica;

	// Constructor

	public UsuarioCliente(String name, String password, String email) {
		super(name, password, email);
		// new de coleccion
		this.setBajaLogica(false);
	}

	// Getters

	public boolean isBajaLogica() {
		return bajaLogica;
	}

	// Setters

	public void setBajaLogica(boolean bajaLogica) {
		this.bajaLogica = bajaLogica;
	}

	// Metodos

	// Overrides necesarios → equals - toString

}
