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
import org.w3c.dom.UserDataHandler;
import clases.AppLibreria;
import clases.Libro;
import clases.UsuarioCliente;
import clasesAbstractas.Usuario;
import excepciones.E_UsuarioInvalido;

public class IG_VentanaPrincipalCliente extends JFrame implements ActionListener
{
	//	ATRIBUTOS.	
	
	private AppLibreria app;
	private String usuario;
	private String titulo;
	private int anioEdicion;
	private String genero;
	private String autor;
	private JMenuBar menuBar; //	Creo la barra.
	private JMenu menuOpciones, menuAcercaDe; //	Cada campo que hay en la barra.
	private JMenu menuBuscarLibro, menuDevolver; //	Cada sub-men� dentro de menuOpciones.
	private JMenuItem miDevolverLista, miDevolverLibro, miNuevo, miSalir; //	Cada opci�n dentro de menuOpciones.
	private JMenuItem miPorTitulo, miPorAnio, miPorGenero, miPorAutor; //	Cada opci�n dentro de menuBuscarLibro.
	private JMenuItem miCreadores; //	Cada opci�n dentro de menuAcercaDe.
	private JLabel labelTitulo, labelAnio, labelGenero, labelAutor;
	private JTextField textTitulo, textAnio, textGenero, textAutor;
	private JButton botonAlquilar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	//	CONSTRUCTOR.
	
	public IG_VentanaPrincipalCliente ()
	{	
		this.app = IG_Bienvenida.app;
		usuario = IG_Bienvenida.usuario;
		
		setLayout(null);
		setTitle("Ventana Principal Buscar Libro - Usuario");
		getContentPane().setBackground(new Color(230, 178, 99));
		
		//	LA BARRA.
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(230, 178, 99));
		menuBar.setForeground(new Color(0,0,0));
		setJMenuBar(menuBar);
				
		//	LOS MENUS DE LA BARRA.
		
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
				
		menuDevolver = new JMenu("Devolver");
		menuDevolver.setBackground(new Color(230, 178, 99));
		menuDevolver.setFont(new Font("Andale Mono", 1, 14));
		menuDevolver.setForeground(new Color(0,0,0));
		menuOpciones.add(menuDevolver);
		
		menuBuscarLibro = new JMenu("Buscar Libro");
		menuBuscarLibro.setBackground(new Color(230, 178, 99));
		menuBuscarLibro.setFont(new Font("Andale Mono", 1, 14));
		menuBuscarLibro.setForeground(new Color(0,0,0));
		menuOpciones.add(menuBuscarLibro);
				
		//	LAS OPCIONIES DENTRO DE CADA MENU DE LA BARRA.
		//	MENU_OPCIONES.
		
		miDevolverLista = new JMenuItem("Lista Alquilados");
		miDevolverLista.setFont(new Font("Andale Mono", 1, 14));
		miDevolverLista.setForeground(new Color(0,0,0));
		menuDevolver.add(miDevolverLista);
		miDevolverLista.addActionListener(this);
		
		miDevolverLibro = new JMenuItem("Devolver Libro");
		miDevolverLibro.setFont(new Font("Andale Mono", 1, 14));
		miDevolverLibro.setForeground(new Color(0,0,0));
		menuDevolver.add(miDevolverLibro);
		miDevolverLibro.addActionListener(this);
		
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
				
		//	MENU_BUSCARLIBRO.
		
		miPorTitulo = new JMenuItem("Por T�tulo");
		miPorTitulo.setFont(new Font("Andale Mono", 1, 14));
		miPorTitulo.setForeground(new Color(0,0,0));
		menuBuscarLibro.add(miPorTitulo);
		miPorTitulo.addActionListener(this);
				
		miPorAnio = new JMenuItem("Por A�o de Edici�n");
		miPorAnio.setFont(new Font("Andale Mono", 1, 14));
		miPorAnio.setForeground(new Color(0,0,0));
		menuBuscarLibro.add(miPorAnio);
		miPorAnio.addActionListener(this);
				
		miPorGenero = new JMenuItem("Por G�nero");
		miPorGenero.setFont(new Font("Andale Mono", 1, 14));
		miPorGenero.setForeground(new Color(0,0,0));
		menuBuscarLibro.add(miPorGenero);
		miPorGenero.addActionListener(this);
				
		miPorAutor = new JMenuItem("Por Autor");
		miPorAutor.setFont(new Font("Andale Mono", 1, 14));
		miPorAutor.setForeground(new Color(0,0,0));
		menuBuscarLibro.add(miPorAutor);
		miPorAutor.addActionListener(this);
				
		//	MENU_ACERCADE.
		
		miCreadores = new JMenuItem("Creadores");
		miCreadores.setFont(new Font("Andale Mono", 1, 14));
		miCreadores.setForeground(new Color(0,0,0));
		menuAcercaDe.add(miCreadores);
		miCreadores.addActionListener(this);
		
		//	ETIQUETAS.
		
		labelTitulo = new JLabel("T�tulo");
		labelAnio = new JLabel("A�o");
		labelGenero = new JLabel("G�nero");
		labelAutor = new JLabel("Autor");
		
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
				
		//	CUADROS DE TEXTO.
		
		textTitulo = new JTextField();
		textAnio = new JTextField();
		textGenero = new JTextField();
		textAutor = new JTextField();
		
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
		
		//	BOTONES.
		
		botonAlquilar = new JButton("Alquilar");
		botonAlquilar.setBackground(new Color(255,255,255));
		botonAlquilar.setFont(new Font("Andale Mono", 1, 14));
		botonAlquilar.setBounds(90,270,120,40);
		botonAlquilar.addActionListener(this);
		botonAlquilar.setEnabled(false);
		add(botonAlquilar);
				
		//	TEXTAREA Y SCROLLPANE.
			
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Andale Mono", 3, 18));
		textArea.setText(""); //	LO QUE CONTIENE EL TEXTAREA MODIFICA CON LOS != BOTONES (BUSQUEDA).
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(300,15,570,410);
		add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if((textAnio.getText().trim().length()) != 0)
		{
			anioEdicion = Integer.parseInt(textAnio.getText().trim());
		}
		
		titulo = textTitulo.getText().trim();
		genero = textGenero.getText().trim();
		autor = textAutor.getText().trim();
		
		if(e.getSource() == miDevolverLista)
		{
			try 
			{
				textArea.setText((this.app.buscarUsuario_EnClientes(usuario)).getAlquilados().listar().toString());
				System.out.println((this.app.buscarUsuario_EnClientes(usuario)).getAlquilados().listar());
			}
			catch(E_UsuarioInvalido ex) 
			{
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
			
		}
		if(e.getSource() == miNuevo)
		{
			miNuevo();
		}
		else if(e.getSource() == miSalir)
		{
			IG_Bienvenida bienvenida = new IG_Bienvenida(this.app);
			bienvenida.setBounds(0, 0, 350, 350);
			bienvenida.setVisible(true);
			bienvenida.setResizable(false);
			bienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		else if(e.getSource() == miDevolverLibro)
		{
			if(textTitulo.getText().trim().length() != 0)
			{
				try 
				{
					UsuarioCliente user = this.app.buscarUsuario_EnClientes(usuario);
					
					if(user.getAlquilados().buscarLibroPor_Titulo(titulo) != null)
					{
						// TERMINAR.
					}
				}
				catch(E_UsuarioInvalido ex) 
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ERROR - Deb�s llenar el campos necesario para la busqueda.");
			}
		}
		else if(e.getSource() == miPorTitulo || e.getSource() == miPorAnio || e.getSource() == miPorGenero || e.getSource() == miPorAutor)
		{
			if(e.getSource() == miPorTitulo)
			{	
				if(textTitulo.getText().trim().length() != 0)
				{
					Libro lib = this.app.buscarPorTitulo_EnObrasImpresas(titulo);
					
					if(lib != null)
					{
						textArea.setText(lib.toString());		
						
						if(lib.getBajaLogica() == false)
						{
							botonAlquilar.setEnabled(true);
						}
						else if(e.getSource() == botonAlquilar)
						{
							this.app.alquilarLibro(lib.getId(), usuario);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ERROR - El libro no est�.");
					}
					miNuevo();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR - Deb�s llenar los campos necesario para la busqueda.");
				}
			}
			else if(e.getSource() == miPorAnio)
			{
				if(textAnio.getText().trim().length() != 0)
				{
					textArea.setText(this.app.buscarPorGenero_EnObrasImpresas(genero).listar().toString());
					System.out.println(this.app.buscarPorGenero_EnObrasImpresas(genero).listar());
					miNuevo();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR - Deb�s llenar los campos necesario para la busqueda.");
				}
			}
			else if(e.getSource() == miPorGenero)
			{
				if(textGenero.getText().trim().length() != 0)
				{
					textArea.setText(this.app.buscarPorGenero_EnObrasImpresas(genero).toString());
					System.out.println(this.app.buscarPorGenero_EnObrasImpresas(genero).toString());
					miNuevo();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR - Deb�s llenar los campos necesario para la busqueda.");
				}
			}
			else if(e.getSource() == miPorAutor)
			{
				if(textAutor.getText().trim().length() != 0)
				{
					textArea.setText(this.app.buscarPorAutor_EnObrasImpresas(autor).listar().toString());
					System.out.println(this.app.buscarPorAutor_EnObrasImpresas(autor).listar());
					miNuevo();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR - Deb�s llenar los campos necesario para la busqueda.");
				}
			}
		}
		else if(e.getSource() == miCreadores)
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
		textTitulo.setText("");
		textAnio.setText("");
		textGenero.setText("");
		textAutor.setText("");
	}
}