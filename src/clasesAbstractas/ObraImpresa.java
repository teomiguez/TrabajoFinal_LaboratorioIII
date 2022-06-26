package clasesAbstractas;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ObraImpresa implements Serializable
{
	// ATRIBUTOS.
	private static AtomicInteger count = new AtomicInteger(0);
	private int id;
	private boolean bajaLogica;
	private int inStock;
	private int inAlquiler;
	
	// CONSTRUCTOR.
	
	public ObraImpresa (int stock)
	{
		this.id = count.incrementAndGet();
		this.bajaLogica = false;
		this.inStock = stock;
		this.inAlquiler = 0;
	}
	
	// GETTERS.
	
	public int getId() 
	{  
		return id;  
	}
	
	public boolean getBajaLogica() 
	{  
		return bajaLogica;  
	}
	
	public int getInStock() 
	{  
		return inStock;  
	}
	
	public int getInAlquiler() 
	{  
		return inAlquiler;  
	}
	
	// SETTERS.
	
	public void setBajaLogica(boolean bajaLogica) 
	{  
		this.bajaLogica = bajaLogica;  
	}
	
	public void setInStock(int inStock) 
	{  
		this.inStock = inStock;  
	}
	
	public void setInAlquiler(int inAlquiler) 
	{  
		this.inAlquiler = inAlquiler;  
	}
	
	//	METODOS
	
	//	OVERRIDERS NECESARIOS
	
	@Override
	public boolean equals(Object obj) 
	{
		ObraImpresa aux = (ObraImpresa)obj; //	Casteo.
		
		if(this.id == aux.id) //Comparo.
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
		return "Obra Impresa {" + "\n" + 
				"ID: " + this.getId() + "\n" + 
				"De Baja: " + this.getBajaLogica() + "\n" +
				"En Stock: " + this.getInStock() + "\n" + 
				"En Alquiler:" + this.getInAlquiler() + "\n" + 
				"}";
	}
}