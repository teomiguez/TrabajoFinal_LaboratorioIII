package clases;

public abstract class ObraImpresa
{
	// Atributos
	
	private int id;
	private boolean bajaLogica;
	private int inStock;
	private int inAlquiler;
	
	// Constructor
	
	public ObraImpresa (int id, int stock)
	{
		this.id = id;
		this.bajaLogica = false;
		this.inStock = stock;
		this.inAlquiler = 0;
	}
	
	
	// Getters
	
	public int getId() {  return id;  }
	public boolean getBajaLogica() {  return bajaLogica;  }
	public int getInStock() {  return inStock;  }
	public int getInAlquiler() {  return inAlquiler;  }
	
	// Setters
	
	public void setBajaLogica(boolean bajaLogica) {  this.bajaLogica = bajaLogica;  }
	public void setInStock(int inStock) {  this.inStock = inStock;  }
	public void setInAlquiler(int inAlquiler) {  this.inAlquiler = inAlquiler;  }
	
	// Metodos
	
	// Overrides necesarios → equals - toString

}
