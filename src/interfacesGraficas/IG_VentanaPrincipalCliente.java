package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.AppLibreria;

public class IG_VentanaPrincipalCliente extends JFrame implements ActionListener
{
	// ATRIBUTOS
	private AppLibreria app;
	
	private String id;
	private String titulo;
	private String anioEdicion;
	private String genero;
	private String autor;
	
	private JMenuBar menuBar; // creo la barra
	private JMenu menuOpciones, menuAcercaDe; // cada campo que hay en la barra
	private JMenu menuBuscarLibro; // cada submenu dentro de menuOpciones
	private JMenuItem miDevolver, miNuevo, miSalir; // cada opcion dentro de menuOpciones
	private JMenuItem miPorId, miPorTitulo, miPorAnio, miPorGenero, miPorAutor; // cada opcion dentro de menuBuscarLibro
	private JMenuItem miCreadores; // cada opcion dentro de menuAcercaDe
	
	private JLabel labelId, labelTitulo, labelAnio, labelGenero, labelAutor;
	private JTextField textId, textTitulo, textAnio, textGenero, textAutor;
	
	JButton botonAlquilar;
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	
	// CONSTRUCTOR
	public IG_VentanaPrincipalCliente ()
	{
		app = IG_Bienvenida.appLibreria;
		
		setLayout(null);
		setTitle("Ventana Principal Buscar Libro - Usuario");
		getContentPane().setBackground(new Color(230, 178, 99));
		
		// LA BARRA
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(230, 178, 99));
		menuBar.setForeground(new Color(0,0,0));
		setJMenuBar(menuBar);
				
		// LOS MENUS DE LA BARRA
		menuOpciones = new JMenu("Opciones");
		menuOpciones.setBackground(new Color(230, 178, 99));
		menuOpciones.setFont(new Font("Andale Mono", 1, 14));
		menuOpciones.setForeground(new Color(0,0,0));
		menuBar.add(menuOpciones);
				
		menuAcercaDe = new JMenu("Acerca de");
		menuAcercaDe.setBackground(new Color(230, 178, 99));
		menuAcercaDe.setFont(new Font("Andale Mono", 1, 14));
		menuAcercaDe.setForeground(new Color(0,0,0));
		menuBar.add(menuAcercaDe);
				
		menuBuscarLibro = new JMenu("Buscar Libro");
		menuBuscarLibro.setBackground(new Color(230, 178, 99));
		menuBuscarLibro.setFont(new Font("Andale Mono", 1, 14));
		menuBuscarLibro.setForeground(new Color(0,0,0));
		menuOpciones.add(menuBuscarLibro);
				
		// LAS OPCIONIES DENTRO DE CADA MENU DE LA BARRA
		// MENU_OPCIONES
		miDevolver = new JMenuItem("Devolver");
		miDevolver.setFont(new Font("Andale Mono", 1, 14));
		miDevolver.setForeground(new Color(0,0,0));
		menuOpciones.add(miDevolver);
		miDevolver.addActionListener(this);
		
		miNuevo = new JMenuItem("Nuevo");
		miNuevo.setFont(new Font("Andale Mono", 1, 14));
		miNuevo.setForeground(new Color(0,0,0));
		menuOpciones.add(miNuevo);
		miNuevo.addActionListener(this);
				
		miSalir = new JMenuItem("Salir");
		miSalir.setFont(new Font("Andale Mono", 1, 14));
		miSalir.setForeground(new Color(0,0,0));
		menuOpciones.add(miSalir);
		miSalir.addActionListener(this);
				
		// MENU_BUSCARLIBRO
				
		miPorId = new JMenuItem("Por Id");
		miPorId.setFont(new Font("Andale Mono", 1, 14));
		miPorId.setForeground(new Color(0,0,0));
		menuBuscarLibro.add(miPorId);
		miPorId.addActionListener(this);
				
		miPorTitulo = new JMenuItem("Por Titulo");
		miPorTitulo.setFont(new Font("Andale Mono", 1, 14));
		miPorTitulo.setForeground(new Color(0,0,0));
		menuBuscarLibro.add(miPorTitulo);
		miPorTitulo.addActionListener(this);
				
		miPorAnio = new JMenuItem("Por Año Edicion");
		miPorAnio.setFont(new Font("Andale Mono", 1, 14));
		miPorAnio.setForeground(new Color(0,0,0));
		menuBuscarLibro.add(miPorAnio);
		miPorAnio.addActionListener(this);
				
		miPorGenero = new JMenuItem("Por Genero");
		miPorGenero.setFont(new Font("Andale Mono", 1, 14));
		miPorGenero.setForeground(new Color(0,0,0));
		menuBuscarLibro.add(miPorGenero);
		miPorGenero.addActionListener(this);
				
		miPorAutor = new JMenuItem("Por Autor");
		miPorAutor.setFont(new Font("Andale Mono", 1, 14));
		miPorAutor.setForeground(new Color(0,0,0));
		menuBuscarLibro.add(miPorAutor);
		miPorAutor.addActionListener(this);
				
		// MENU_ACERCADE
		miCreadores = new JMenuItem("Creadores");
		miCreadores.setFont(new Font("Andale Mono", 1, 14));
		miCreadores.setForeground(new Color(0,0,0));
		menuAcercaDe.add(miCreadores);
		miCreadores.addActionListener(this);
		
		// ETIQUETAS.-
			
		labelId = new JLabel("ID");
		labelTitulo = new JLabel("Titulo");
		labelAnio = new JLabel("Año");
		labelGenero = new JLabel("Genero");
		labelAutor = new JLabel("Autor");
				
		labelId.setBounds(40,-10,200,100);
		labelId.setFont(new Font("Andale Mono", 3, 18));
		labelId.setForeground(new Color(0,0,0));
		add(labelId);
		
		labelTitulo.setBounds(25,30,200,100);
		labelTitulo.setFont(new Font("Andale Mono", 3, 18));
		labelTitulo.setForeground(new Color(0,0,0));
		add(labelTitulo);
		
		labelAnio.setBounds(30,70,200,100);
		labelAnio.setFont(new Font("Andale Mono", 3, 18));
		labelAnio.setForeground(new Color(0,0,0));
		add(labelAnio);
		
		labelGenero.setBounds(20,110,200,100);
		labelGenero.setFont(new Font("Andale Mono", 3, 18));
		labelGenero.setForeground(new Color(0,0,0));
		add(labelGenero);
		
		labelAutor.setBounds(30,150,200,100);
		labelAutor.setFont(new Font("Andale Mono", 3, 18));
		labelAutor.setForeground(new Color(0,0,0));
		add(labelAutor);
				
		// CUADROS DE TEXTO.-
				
		textId = new JTextField();
		textTitulo = new JTextField();
		textAnio = new JTextField();
		textGenero = new JTextField();
		textAutor = new JTextField();
				
		textId.setBounds(90,25,150,30);
		textId.setBackground(new Color(254,254,254));
		textId.setFont(new Font("Verdana", 0, 14));
		add(textId);
		
		textTitulo.setBounds(90,65,150,30);
		textTitulo.setBackground(new Color(254,254,254));
		textTitulo.setFont(new Font("Verdana", 0, 14));
		add(textTitulo);
		
		textAnio.setBounds(90,105,150,30);
		textAnio.setBackground(new Color(254,254,254));
		textAnio.setFont(new Font("Verdana", 0, 14));
		add(textAnio);
		
		textGenero.setBounds(90,145,150,30);
		textGenero.setBackground(new Color(254,254,254));
		textGenero.setFont(new Font("Verdana", 0, 14));
		add(textGenero);
		
		textAutor.setBounds(90,185,150,30);
		textAutor.setBackground(new Color(254,254,254));
		textAutor.setFont(new Font("Verdana", 0, 14));
		add(textAutor);
		
		// BOTONES
		
		botonAlquilar = new JButton("Alquilar");
		botonAlquilar.setBackground(new Color(255,255,255));
		botonAlquilar.setFont(new Font("Andale Mono", 1, 14));
		botonAlquilar.setBounds(90,270,120,40);
		botonAlquilar.addActionListener(this);
		botonAlquilar.setEnabled(false);
		add(botonAlquilar);
				
		// TEXTAREA Y SCROLLPANE.-
			
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Andale Mono", 3, 18));
		textArea.setText(""); // LO QUE CONTIENE EL TEXTAREA → MODIFICA CON LOS != BOTONES (BUSQUEDA)
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(300,15,570,410);
		add(scrollPane);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == miDevolver)
		{
			// listar librosAlquilados - seleccionar para devolver
		}
		if (e.getSource() == miNuevo)
		{
			textId.setText("");
			textTitulo.setText("");
			textAnio.setText("");
			textGenero.setText("");
			textAutor.setText("");
		}
		if (e.getSource() == miSalir)
		{
			IG_Bienvenida bienvenida = new IG_Bienvenida(this.app);
			
			bienvenida.setBounds(0, 0, 350, 300);
			bienvenida.setVisible(true);
			bienvenida.setResizable(false);
			bienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		if (e.getSource() == miPorId || e.getSource() == miPorTitulo || e.getSource() == miPorAnio || e.getSource() == miPorGenero || e.getSource() == miPorAutor)
		{
			if (e.getSource() == miPorId)
			{
				// trabajo - busco
			}
			if (e.getSource() == miPorTitulo)
			{
				// trabajo - busco
			}
			if (e.getSource() == miPorAnio)
			{
				// trabajo - busco
			}
			if (e.getSource() == miPorGenero)
			{
				// trabajo - busco
			}
			if (e.getSource() == miPorAutor)
			{
				// trabajo - busco
			}
		}
		if (e.getSource() == miCreadores)
		{
			IG_Creadores creadores = new IG_Creadores();
			
			creadores.setBounds(0, 0, 350, 275);
			creadores.setVisible(true);
			creadores.setResizable(false);
			creadores.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}
}