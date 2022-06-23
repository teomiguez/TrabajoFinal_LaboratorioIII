package app;

import java.util.ArrayList;

/**
*
*          Proyecto: Trabajo Practico Final - Laboratorio III
*
*                  Inetgrantes del grupo:
*                                          - Miguez De Araujo, Teo
*                                          - Sulpizio, Caarla Valentina
*                                          - Vigano, Juan Cruz
*
*/

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Hello world!");
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("Hola");
		list.add("Chau");
		
		for (int i = 0; i < list.size(); i++) 
		{
			System.out.println(list.get(i));
		}
		
	}

}
