package clasesAbstractas;

public abstract class ObraImpresa
{
	// ATRIBUTOS
	
	private int id;
	private boolean bajaLogica;
	private int inStock;
	private int inAlquiler;
	
	// CONSTRUCTOR
	
	public ObraImpresa (int id, int stock)
	{
		this.id = id;
		this.bajaLogica = false;
		this.inStock = stock;
		this.inAlquiler = 0;
	}
	
	
	// GETTERS
	
	public int getId() {  return id;  }
	public boolean getBajaLogica() {  return bajaLogica;  }
	public int getInStock() {  return inStock;  }
	public int getInAlquiler() {  return inAlquiler;  }
	
	// SETTERS
	
	public void setBajaLogica(boolean bajaLogica) {  this.bajaLogica = bajaLogica;  }
	public void setInStock(int inStock) {  this.inStock = inStock;  }
	public void setInAlquiler(int inAlquiler) {  this.inAlquiler = inAlquiler;  }
	
	// METODOS
	
	// OVERRIDERS NECESARIOS → equals - toString
	
	@Override
	public boolean equals(Object obj) 
	{
		ObraImpresa aux = (ObraImpresa)obj; // CASTEO
		
		if (this.id == aux.id) // COMPARO
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		
		return "Obra Impresa {" + "\n" + 
				"ID: " + this.getId() + "\n" + 
				"En Stock: " + this.getInStock() + "\n" + 
				"En Alquiler:" + this.getInAlquiler() + "\n" + 
				"}";
	}
	
}
