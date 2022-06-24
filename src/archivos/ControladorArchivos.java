package archivos; 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import clases.AppLibreria;

public class ControladorArchivos 
{
	private String archivo;
	
	public ControladorArchivos() 
	{
		this.archivo = "Usuarios.bin";
	}
	
	public boolean guardarArchivo(AppLibreria app)
	{
		try 
		{
			FileOutputStream fileOutputStream = new FileOutputStream(this.archivo); 
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);  
			objectOutputStream.writeObject(app);
			objectOutputStream.close();
			
			return true;
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public AppLibreria leerArchivo()
	{
		AppLibreria app = new AppLibreria();
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(this.archivo);// con outPut guardamos en el archivo
			
			try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) 
			{
				app = (AppLibreria) objectInputStream.readObject();
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return app;
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		return app;
	}
}