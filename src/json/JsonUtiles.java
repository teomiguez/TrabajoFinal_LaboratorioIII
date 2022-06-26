package json;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtiles 
{
	public static void grabar(JSONObject json) 
	{
        try 
        {
            FileWriter file = new FileWriter("test.json");
            file.write(json.toString());
            file.flush();
            file.close();

        } 
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static String leer(String archivo)
    {
        String contenido = "";
        
        try
        {
            contenido = new String(Files.readAllBytes(Paths.get(archivo)));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        return contenido;
    }
}