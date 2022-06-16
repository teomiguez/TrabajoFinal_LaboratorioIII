package clases;

import clasesAbstractas.Usuario;

public class UsuarioCliente extends Usuario {

	// ATRIBUTOS

	// private coleccionAlquilados
	private boolean bajaLogica;

	// CONSTRUCTOR

	public UsuarioCliente(String name, String password, String email) {
		super(name, password, email);
		// new de coleccion
		this.setBajaLogica(false);
	}

	// GETTERS

	public boolean isBajaLogica() {
		return bajaLogica;
	}

	// SETTERS

	public void setBajaLogica(boolean bajaLogica) {
		this.bajaLogica = bajaLogica;
	}

	// METODOS

	// OVERRIDERS NECESARIOS → equals - toString
	
	@Override
	public boolean equals(Object obj) {
		
		Usuario aux = (Usuario)obj; // CASTEO
		
		if (this.getEmail().equals(aux.getEmail())) // COMPARO
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}

}
