package clasesAbstractas;

import java.io.Serializable;

public abstract class Usuario implements Serializable
{
	// ATRIBUTOS.
	
	private String name;
	private String password;
	private String email;
	
	// CONSTRUCTOR.
			
	public Usuario (String name, String password, String email)
	{
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	// GETTERS.
	
	public String getName()
	{  
		return name;  
	}
	
	public String getPassword() 
	{  
		return password;  
	}
	
	public String getEmail()
	{  
		return email;  
	}
	
	// SETTERS.
	
	public void setName(String name)
	{  
		this.name = name;  
	}
	
	public void setPassword(String password) 
	{  
		this.password = password; 
	}
	
	// METODOS:
	// OVERRIDERS NECESARIOS.
	
	@Override
	public boolean equals(Object obj)
	{
		Usuario aux = (Usuario)obj;
		
		if(this.email.equals(aux.email))
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
		return "Usuario {" + "\n" +
				"usuario: " + this.getName() + "\n" +
				"email: " + this.getEmail() + "\n" +
				"password: " + this.getPassword() + "\n" +
				"}";
	}	
}