package clases;

import clasesAbstractas.Usuario;

public class UsuarioAdmin extends Usuario
{
	
	//	CONSTRUCTOR. 
		
	public UsuarioAdmin (String name, String password, String email)
	{
		super(name, password, email);
	}
		
	// 	MÉTODOS: 
	//	OVERRIDERS NECESARIOS.
	
	@Override
	public boolean equals(Object obj) 
	{	
		Usuario aux = (Usuario)obj; // Casteo.
		
		if(this.getEmail().equals(aux.getEmail())) // Comparo.
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String toString() 
	{	
		return super.toString();
	}
}