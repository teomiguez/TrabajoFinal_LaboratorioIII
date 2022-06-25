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

public class IG_Admin_BuscarUsuario extends JFrame implements ActionListener
{
	// ATRIBUTOS
	private AppLibreria app;
	
	private String usuario;
	private String email;
	
	private JMenuBar menuBar; // creo la barra
	private JMenu menuOpciones, menuAcercaDe; // cada campo que hay en la barra
	private JMenu menuBuscarLibro, menuBuscarUsuario; // cada submenu dentro de menuOpciones
	private JMenuItem miNuevo, miSalir; // cada opcion dentro de menuOpciones
	private JMenuItem miPorId, miPorTitulo, miPorAnio, miPorGenero, miPorAutor; // cada opcion dentro de menuBuscarLibro
	private JMenuItem miPorUsuario, miPorEmail; // cada opcion dentro de menuBuscarUsuario
	private JMenuItem miCreadores; // cada opcion dentro de menuAcercaDe
	
	private JLabel labelUsuario, labelEmail;
	private JTextField textUsuario, textEmail;
	
	private JButton botonBaja, botonAlta;
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	
	// CONSTRUCTOR
	public IG_Admin_BuscarUsuario ()
	{
		app = IG_Bienvenida.appLibreria;
		
		setLayout(null);
		setTitle("Ventana Principal Buscar Usuario - Admin");
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
		
		menuBuscarUsuario = new JMenu("Buscar Usuario");
		menuBuscarUsuario.setBackground(new Color(230, 178, 99));
		menuBuscarUsuario.setFont(new Font("Andale Mono", 1, 14));
		menuBuscarUsuario.setForeground(new Color(0,0,0));
		menuOpciones.add(menuBuscarUsuario);
		
		// LAS OPCIONIES DENTRO DE CADA MENU DE LA BARRA
		// MENU_OPCIONES
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
		
		// MENU_BUSCARUSUARIO
		
		miPorUsuario = new JMenuItem("Por Usuario");
		miPorUsuario.setFont(new Font("Andale Mono", 1, 14));
		miPorUsuario.setForeground(new Color(0,0,0));
		menuBuscarUsuario.add(miPorUsuario);
		miPorUsuario.addActionListener(this);
		
		miPorEmail = new JMenuItem("Por Email");
		miPorEmail.setFont(new Font("Andale Mono", 1, 14));
		miPorEmail.setForeground(new Color(0,0,0));
		menuBuscarUsuario.add(miPorEmail);
		miPorEmail.addActionListener(this);
		
		// MENU_ACERCADE
		miCreadores = new JMenuItem("Creadores");
		miCreadores.setFont(new Font("Andale Mono", 1, 14));
		miCreadores.setForeground(new Color(0,0,0));
		menuAcercaDe.add(miCreadores);
		miCreadores.addActionListener(this);
		
		// ETIQUETAS.-
		
		labelUsuario = new JLabel("Usuario");
		labelEmail = new JLabel("Email");
		
		labelUsuario.setBounds(40,-10,200,100);
		labelUsuario.setFont(new Font("Andale Mono", 3, 18));
		labelUsuario.setForeground(new Color(0,0,0));
		add(labelUsuario);
		
		labelEmail.setBounds(40,50,200,100);
		labelEmail.setFont(new Font("Andale Mono", 3, 18));
		labelEmail.setForeground(new Color(0,0,0));
		add(labelEmail);
		
		// CUADROS DE TEXTO.-
		
		textUsuario = new JTextField();
		textEmail = new JTextField();
		
		textUsuario.setBounds(120,25,150,30);
		textUsuario.setBackground(new Color(254,254,254));
		textUsuario.setFont(new Font("Verdana", 0, 14));
		add(textUsuario);
		
		textEmail.setBounds(120,85,150,30);
		textEmail.setBackground(new Color(254,254,254));
		textEmail.setFont(new Font("Verdana", 0, 14));
		add(textEmail);
		
		// BOTONES
		
		botonAlta = new JButton("Dar Alta");
		botonAlta.setBackground(new Color(255,255,255));
		botonAlta.setFont(new Font("Andale Mono", 1, 14));
		botonAlta.setBounds(20,150,120,40);
		botonAlta.addActionListener(this);
		botonAlta.setEnabled(false);
		add(botonAlta);
		
		botonBaja = new JButton("Dar Baja");
		botonBaja.setBackground(new Color(255,255,255));
		botonBaja.setFont(new Font("Andale Mono", 1, 14));
		botonBaja.setBounds(165,150,120,40);
		botonBaja.addActionListener(this);
		botonBaja.setEnabled(false);
		add(botonBaja);
		
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
		if (e.getSource() == miNuevo)
		{
			if (this.getTitle().equals("Ventana Principal Buscar Usuario - Admin"))
			{
				textUsuario.setText("");
				textEmail.setText("");
			}
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
			IG_Admin_BuscarLibro ventanaAdmin = new IG_Admin_BuscarLibro();
			
			ventanaAdmin.setBounds(0, 0, 900, 500);
			ventanaAdmin.setVisible(true);
			ventanaAdmin.setResizable(false);
			ventanaAdmin.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		if (e.getSource() == miPorUsuario || e.getSource() == miPorEmail)
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
