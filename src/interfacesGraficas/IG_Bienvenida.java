package interfacesGraficas;

import javax.swing.*;

import clases.AppLibreria;
import excepciones.E_ContraseniaInvalida;
import excepciones.E_UsuarioInvalido;

import java.awt.event.*;
import java.awt.*;

public class IG_Bienvenida extends JFrame implements ActionListener
{
	// ATRIBUTOS
	public static AppLibreria app;
	
	public static String usuario; // se pasa por != interfaces
	private String password;
	
	private JTextField textField1;
	private JTextField textField2;
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	private JButton boton1;
	private JButton boton2;
	
	// CONSTRUCTOR
	public IG_Bienvenida (AppLibreria appLibreria) 
	{	
		this.app = appLibreria;
		
		setLayout(null);
		setTitle("Bienvenida - login");
		getContentPane().setBackground(new Color(230, 178, 99));
		
		label1 = new JLabel("Usuario");
		label2 = new JLabel("Contraseña");
		label3 = new JLabel("AppLibreria");
		
		label1.setBounds(60,50,200,100);
		label1.setFont(new Font("Andale Mono", 3, 18));
		label1.setForeground(new Color(0,0,0));
		add(label1);
		
		label2.setBounds(30,100,200,100);
		label2.setFont(new Font("Andale Mono", 3, 18));
		label2.setForeground(new Color(0,0,0));
		add(label2);
		
		label3.setBounds(30,-60,300,200);
		label3.setFont(new Font("Comic Sans MS", 3, 46));
		label3.setForeground(new Color(0,0,0));
		add(label3);
		
		textField1 = new JTextField();
		textField1.setBounds(140,85,150,30);
		textField1.setBackground(new Color(254,254,254));
		textField1.setFont(new Font("Verdana", 0, 14));
		add(textField1);
		
		textField2 = new JTextField();
		textField2.setBounds(140,135,150,30);
		textField2.setBackground(new Color(254,254,254));
		textField2.setFont(new Font("Verdana", 0, 14));
		add(textField2);
		
		boton1 = new JButton("Registrarse");
		boton1.setBackground(new Color(255,255,255));
		boton1.setFont(new Font("Andale Mono", 1, 14));
		boton1.setBounds(30,200,120,40);
		boton1.addActionListener(this);
		add(boton1);
		
		boton2 = new JButton("Ingresar");
		boton2.setBackground(new Color(254,254,254));
		boton2.setFont(new Font("Andale Mono", 1, 14));
		boton2.setBounds(180,200,120,40);
		boton2.addActionListener(this);
		add(boton2);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == boton1)
		{
			IG_Registro registro = new IG_Registro();
			
			registro.setBounds(0, 0, 370, 500);
			registro.setVisible(true);
			registro.setResizable(false);
			registro.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		if (e.getSource() ==  boton2)
		{
			usuario = textField1.getText().trim();
			password = textField2.getText().trim();
			
			if (usuario.equals("") || password.equals("")) // si algun campo esta vacio (no tiene texto)
			{
				JOptionPane.showMessageDialog(null, "ERROR - Llenar los campos de texto para ingresar"); // mando un mensaje
			}
			if (!usuario.equals("") & !password.equals(""))
			{
				if (usuario.equals("admin") & password.equals("admin")) // si es admin
				{
					IG_Admin_BuscarLibro ventanaAdmin = new IG_Admin_BuscarLibro();
					
					ventanaAdmin.setBounds(0, 0, 900, 500);
					ventanaAdmin.setVisible(true);
					ventanaAdmin.setResizable(false);
					ventanaAdmin.setLocationRelativeTo(null);
					this.setVisible(false); // para que bienvenida no se vea (se cierre)
				}
				else
				{
					boolean entra = false;
					
					try 
					{
						entra = this.app.loginUsuario(usuario, password);
					}
					catch(E_UsuarioInvalido ex) 
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} 
					catch(E_ContraseniaInvalida ex) 
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
					if (entra == true)
					{		
						IG_VentanaPrincipalCliente ventanaCliente = new IG_VentanaPrincipalCliente();
						
						ventanaCliente.setBounds(0, 0, 900, 500);
						ventanaCliente.setVisible(true);
						ventanaCliente.setResizable(false);
						ventanaCliente.setLocationRelativeTo(null);
						this.setVisible(false);
					}
				}
			}
		}
	}
	
}
