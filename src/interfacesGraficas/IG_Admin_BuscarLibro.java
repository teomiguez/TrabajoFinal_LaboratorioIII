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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import clases.AppLibreria;
import clases.Libro;

public class IG_Admin_BuscarLibro extends JFrame implements ActionListener
{
	// ATRIBUTOS
	private AppLibreria app;
	
	private int id;
	private String titulo;
	private int anioEdicion;
	private String genero;
	private String autor;
	private String descripcion;
	
	private JMenuBar menuBar; // creo la barra
	private JMenu menuOpciones, menuAcercaDe; // cada campo que hay en la barra
	private JMenu menuBuscarLibro, menuBuscarUsuario; // cada submenu dentro de menuOpciones
	private JMenuItem miCrearLibro, miNuevo, miSalir; // cada opcion dentro de menuOpciones
	private JMenuItem miPorId, miPorTitulo, miPorAnio, miPorGenero, miPorAutor; // cada opcion dentro de menuBuscarLibro
	private JMenuItem miPorUsuario, miPorEmail; // cada opcion dentro de menuBuscarUsuario
	private JMenuItem miCreadores; // cada opcion dentro de menuAcercaDe
	
	private JLabel labelId, labelTitulo, labelAnio, labelGenero, labelAutor, labelDescripcion;
	private JTextField textId, textTitulo, textAnio, textGenero, textAutor;
	
	private JButton botonBaja, botonAlta;
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPaneDes;
	private JTextArea textArea;
	private JTextArea textAreaDes;
	
	
	// CONSTRUCTOR
	public IG_Admin_BuscarLibro ()
	{	
		this.app = IG_Bienvenida.app;
		
		setLayout(null);
		setTitle("Ventana Principal Buscar Libro - Admin");
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
		miCrearLibro = new JMenuItem("Nuevo Libro");
		miCrearLibro.setFont(new Font("Andale Mono", 1, 14));
		miCrearLibro.setForeground(new Color(0,0,0));
		menuOpciones.add(miCrearLibro);
		miCrearLibro.addActionListener(this);
		
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
		
		labelId = new JLabel("ID");
		labelTitulo = new JLabel("Titulo");
		labelAnio = new JLabel("Año");
		labelGenero = new JLabel("Genero");
		labelAutor = new JLabel("Autor");
		labelDescripcion = new JLabel("Descripcion");
		
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
		
		labelDescripcion.setBounds(20,185,200,100);
		labelDescripcion.setFont(new Font("Andale Mono", 3, 18));
		labelDescripcion.setForeground(new Color(0,0,0));
		add(labelDescripcion);
		
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
		
		botonAlta = new JButton("Dar Alta");
		botonAlta.setBackground(new Color(255,255,255));
		botonAlta.setFont(new Font("Andale Mono", 1, 14));
		botonAlta.setBounds(20,370,120,40);
		botonAlta.addActionListener(this);
		botonAlta.setEnabled(false);
		add(botonAlta);
		
		botonBaja = new JButton("Dar Baja");
		botonBaja.setBackground(new Color(255,255,255));
		botonBaja.setFont(new Font("Andale Mono", 1, 14));
		botonBaja.setBounds(165,370,120,40);
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
		
		textAreaDes = new JTextArea();
		textAreaDes.setEditable(true);
		textAreaDes.setFont(new Font("Verdana", 0, 14));
		textAreaDes.setText("");
		scrollPaneDes = new JScrollPane(textAreaDes);
		scrollPaneDes.setBounds(50,250,200,100);
		add(scrollPaneDes);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if ((textId.getText().trim().length()) != 0)
		{
			id = Integer.parseInt(textId.getText().trim());
		}
		
		if ((textAnio.getText().trim().length()) != 0)
		{
			anioEdicion = Integer.parseInt(textAnio.getText().trim());
		}
		
		titulo = textTitulo.getText().trim();
		genero = textGenero.getText().trim();
		autor = textAutor.getText().trim();
		descripcion = textAreaDes.getText().trim();
		
		if (e.getSource() == miCrearLibro)
		{
			if (!textTitulo.equals("") & !textAnio.equals("") & !textGenero.equals("") & !textAutor.equals("") & !textAreaDes.equals(""))
			{
				this.app.agregarLibro(this.app.crearLibro(50, titulo, anioEdicion, genero, autor, descripcion));
				
				miNuevo();
			}
			if (textTitulo.equals("") || textAnio.equals("") || textGenero.equals("") || textAutor.equals("") || textAreaDes.equals(""))
			{
				JOptionPane.showMessageDialog(null, "ERROR - Debes llenar los campos necesarios para crear un libro");
			}
		}
		if (e.getSource() == miNuevo)
		{
			if (this.getTitle().equals("Ventana Principal Buscar Libro - Admin"))
			{
				miNuevo();
			}
		}
		if (e.getSource() == miSalir)
		{
			IG_Bienvenida bienvenida = new IG_Bienvenida(this.app);
			
			bienvenida.setBounds(0, 0, 350, 350);
			bienvenida.setVisible(true);
			bienvenida.setResizable(false);
			bienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		if (e.getSource() == miPorId || e.getSource() == miPorTitulo || e.getSource() == miPorAnio || e.getSource() == miPorGenero || e.getSource() == miPorAutor)
		{			
			if (e.getSource() == miPorId)
			{
				if (textId.equals(""))
				{
					JOptionPane.showMessageDialog(null, "ERROR - Debes llenar el campos necesario para la busqueda");
				}
				if (!textId.equals(""))
				{	
					Libro lib = this.app.buscarPorID_EnObrasImpresas(id);
					textArea.setText(lib.toString());
					
					if (lib.getBajaLogica() == true)
						botonAlta.setEnabled(true);
					if (lib.getBajaLogica() == false)
						botonBaja.setEnabled(true);
					
					miNuevo();
				}
			}
			if (e.getSource() == miPorTitulo)
			{	
				if (textTitulo.equals(""))
				{
					JOptionPane.showMessageDialog(null, "ERROR - Debes llenar el campos necesario para la busqueda");
				}
				if (!textTitulo.equals(""))
				{
					Libro lib = this.app.buscarPorTitulo_EnObrasImpresas(titulo);
					textArea.setText(lib.toString());
					
					if (lib.getBajaLogica() == true)
						botonAlta.setEnabled(true);
					if (lib.getBajaLogica() == false)
						botonBaja.setEnabled(true);
					
					// NO PUEDO HACER QUE EL PROGRAMA ESPERE A QUE SE PULSE ALGO...
					
					if (e.getSource() == botonAlta)
					{
						this.app.darDeAlta_Libro(lib.getId());
					}
					if (e.getSource() == botonAlta)
					{
						this.app.darDeBaja_Libro(lib.getId());
					}
					
					miNuevo();
					
				}
			}
			if (e.getSource() == miPorAnio)
			{
				if (textAnio.equals(""))
				{
					JOptionPane.showMessageDialog(null, "ERROR - Debes llenar el campos necesario para la busqueda");
				}
				if (!textAnio.equals(""))
				{	
					textArea.setText(this.app.buscarPorGenero_EnObrasImpresas(genero).listar().toString());
					System.out.println(this.app.buscarPorGenero_EnObrasImpresas(genero).listar());
					miNuevo();
				}
			}
			if (e.getSource() == miPorGenero)
			{
				if (textGenero.equals(""))
				{
					JOptionPane.showMessageDialog(null, "ERROR - Debes llenar el campos necesario para la busqueda");
				}
				if (!textGenero.equals(""))
				{
					textArea.setText(this.app.buscarPorGenero_EnObrasImpresas(genero).listar().toString());
					System.out.println(this.app.buscarPorGenero_EnObrasImpresas(genero).listar());
					miNuevo();
				}
			}
			if (e.getSource() == miPorAutor)
			{
				if (textAutor.equals(""))
				{
					JOptionPane.showMessageDialog(null, "ERROR - Debes llenar el campos necesario para la busqueda");
				}
				if (!textAutor.equals(""))
				{
					textArea.setText(this.app.buscarPorAutor_EnObrasImpresas(autor).toString());
					miNuevo();
				}
			}
			
		}
		if (e.getSource() == miPorUsuario || e.getSource() == miPorEmail)
		{
			IG_Admin_BuscarUsuario ventanaAdmin = new IG_Admin_BuscarUsuario();
			
			ventanaAdmin.setBounds(0, 0, 900, 500);
			ventanaAdmin.setVisible(true);
			ventanaAdmin.setResizable(false);
			ventanaAdmin.setLocationRelativeTo(null);
			this.setVisible(false);
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
	
	public void miNuevo()
	{
		textId.setText("");
		textTitulo.setText("");
		textAnio.setText("");
		textGenero.setText("");
		textAutor.setText("");
		textAreaDes.setText("");
	}
}
