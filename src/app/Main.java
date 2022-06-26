package app;

import archivos.ControladorArchivos;
import clases.AppLibreria;
import interfacesGraficas.IG_Bienvenida;
import json.ControladoraJson;



/**
*
*          Proyecto: Trabajo Practico Final - Laboratorio III
*
*                  Inetgrantes del grupo:
*                                          - Miguez De Araujo, Teo.
*                                          - Sulpizio, Caarla Valentina.
*                                          - Vigano, Juan Cruz.
*
*/

public class Main 
{
	public static void main(String[] args) 
	{
		AppLibreria app = new AppLibreria();
		
		//app = ControladorArchivos.leerArchivo("file.dat");
		
		ventanaBienvenida();
		
		ControladorArchivos.guardarArchivo("file.dat", app);
		
		System.out.println(ControladoraJson.generarJson_obrasImpresas(app.getObrasImpresas()).toString());
	}
	
	public static void ventanaBienvenida()
	{
		IG_Bienvenida bienvenida = new IG_Bienvenida();
		
		bienvenida.setBounds(0, 0, 350, 300);
		bienvenida.setVisible(true);
		bienvenida.setResizable(false);
		bienvenida.setLocationRelativeTo(null);
	}
	
}