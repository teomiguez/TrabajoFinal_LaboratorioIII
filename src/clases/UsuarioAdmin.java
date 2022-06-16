package clases;

import clasesAbstractas.Usuario;

public class UsuarioAdmin extends Usuario
{
	
	// ATRIBUTOS
	
	
	// CONSTRUCTOR
		
	public UsuarioAdmin (String name, String password, String email)
		{
			super(name, password, email);
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
