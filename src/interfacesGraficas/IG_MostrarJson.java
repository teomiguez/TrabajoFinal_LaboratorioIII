package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import clases.AppLibreria;
import json.ControladoraJson;

public class IG_MostrarJson extends JFrame
{
	private AppLibreria app;
	
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	
	public IG_MostrarJson()
	{
		this.app = IG_Bienvenida.app;
		
		setLayout(null);
		setTitle("Mostrar Json");
		getContentPane().setBackground(new Color(230, 178, 99));
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Andale Mono", 3, 18));
		textArea.setText(ControladoraJson.leerArchivo());
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10,10,660,640);
		add(scrollPane);
	}
}
