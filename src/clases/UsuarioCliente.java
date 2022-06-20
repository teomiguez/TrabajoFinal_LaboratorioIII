package clases;

import clasesAbstractas.Usuario;
import genericidad.ListaGenerica;

public class UsuarioCliente extends Usuario {

	// ATRIBUTOS

	ListaGenerica<Libro> alquilados;
	private boolean bajaLogica;

	// CONSTRUCTOR

	public UsuarioCliente(String name, String password, String email) {
		super(name, password, email);
		this.alquilados = new ListaGenerica<Libro>();
		this.bajaLogica = false;
	}

	// GETTERS

	public boolean isBajaLogica() {
		return bajaLogica;
	}
	
	public ListaGenerica<Libro> getAlquilados() {
		return alquilados;
	}

	// SETTERS

	public void setBajaLogica(boolean bajaLogica) {
		this.bajaLogica = bajaLogica;
	}
	
	public void setAlquilados(ListaGenerica<Libro> alquilados) {
		this.alquilados = alquilados;
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
