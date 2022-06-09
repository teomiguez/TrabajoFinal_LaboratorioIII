package clases;

public abstract class Usuario 
{
	
	// Atributos
	
	private String name;
	private String password;
	private String email;
	
	// Constructor
		
	public Usuario (String name, String password, String email)
	{
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	// Getters
	
	public String getName() {  return name;  }
	public String getPassword() {  return password;  }
	public String getEmail() {  return email;  }
	
	// Setters
	
	public void setName(String name) {  this.name = name;  }
	public void setPassword(String password) {  this.password = password;  }
	
	// Metodos
	
	
	
	// Overrides necesarios → equals - toString
	
	@Override
	public boolean equals(Object obj) {
		Usuario aux = (Usuario)obj;
		
		if (this.email.equals(aux.email))
			return true;
		else
			return false;
	}
	
}
