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
	public static boolean guardarArchivo(String file, AppLibreria app)
	{
		boolean seGuardo = false;
		
		try 
		{
			FileOutputStream fileOutputStream = new FileOutputStream(file); 
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);  
			objectOutputStream.writeObject(app);
			objectOutputStream.close();
			seGuardo = true;
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		return seGuardo; 
	}
	
	public static AppLibreria leerArchivo(String file)
	{
		AppLibreria aux = new AppLibreria();
		
		try 
		{
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			aux = (AppLibreria) objectInputStream.readObject();
			objectInputStream.close();
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		} 
		catch(ClassNotFoundException e) 
		{	
			e.printStackTrace();
		}
		
		return aux;
	}	
}