package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import clases.AppLibreria;
import excepciones.E_UsuarioExistente;

public class IG_Registro extends JFrame implements ActionListener, ChangeListener
{
	// ATRIBUTOS
	private AppLibreria app;
	
	private String usuario;
	private String email;
	private String password;
	
	private String textoUsuario;
	private String textoEmail;
	private String textoPassword;
	
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	
	private JLabel label;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	private JCheckBox check1;
	
	private JButton boton1;
	private JButton boton2;
	
	// CONSTRUCTOR
	public IG_Registro ()
	{
		this.app = IG_Bienvenida.app;
		
		setLayout(null);
		setTitle("Registro");
		getContentPane().setBackground(new Color(230, 178, 99));
		
		label = new JLabel("Registro de Usuario");
		label1 = new JLabel("Usuario");
		label2 = new JLabel("Email");
		label3 = new JLabel("Contraseña");
		
		label.setBounds(20,-10,350,100);
		label.setFont(new Font("Comic Sans MS", 3, 32));
		label.setForeground(new Color(0,0,0));
		add(label);
		
		label1.setBounds(30,50,200,100);
		label1.setFont(new Font("Andale Mono", 3, 18));
		label1.setForeground(new Color(0,0,0));
		add(label1);
		
		label2.setBounds(30,100,200,100);
		label2.setFont(new Font("Andale Mono", 3, 18));
		label2.setForeground(new Color(0,0,0));
		add(label2);
		
		label3.setBounds(30,100,300,200);
		label3.setFont(new Font("Andale Mono", 3, 18));
		label3.setForeground(new Color(0,0,0));
		add(label3);
		
		textField1 = new JTextField();
		textField1.setBounds(145,85,150,30);
		textField1.setBackground(new Color(254,254,254));
		textField1.setFont(new Font("Verdana", 0, 14));
		add(textField1);
		
		textField2 = new JTextField();
		textField2.setBounds(145,135,150,30);
		textField2.setBackground(new Color(254,254,254));
		textField2.setFont(new Font("Verdana", 0, 14));
		add(textField2);
		
		textField3 = new JTextField();
		textField3.setBounds(145,185,150,30);
		textField3.setBackground(new Color(254,254,254));
		textField3.setFont(new Font("Verdana", 0, 14));
		add(textField3);
		
		check1 = new JCheckBox("Acepto los Terminos y Condiciones");
		check1.setBackground(new Color(230, 178, 99));
		check1.setBounds(60,225,230,40);
		check1.addChangeListener(this);
		add(check1);
		
		boton1 = new JButton("Registrarme");
		boton1.setBackground(new Color(255,255,255));
		boton1.setFont(new Font("Andale Mono", 1, 14));
		boton1.setBounds(180,270,120,40);
		boton1.addActionListener(this);
		boton1.setEnabled(false);
		add(boton1);
		
		boton2 = new JButton("Volver");
		boton2.setBackground(new Color(255,255,255));
		boton2.setFont(new Font("Andale Mono", 1, 14));
		boton2.setBounds(40,270,120,40);
		boton2.addActionListener(this);
		boton2.setEnabled(true);
		add(boton2);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == boton1)
		{
			textoUsuario = textField1.getText().trim();
			textoEmail = textField2.getText().trim();
			textoPassword = textField3.getText().trim();
			
			if (!textoUsuario.equals("") & !textoEmail.equals("") & !textoPassword.equals(""))
			{
				boolean registro = false;
				
				try 
				{
					registro = this.app.registerUsuario(textoEmail, textoUsuario, textoPassword);
				} 
				catch (E_UsuarioExistente e1) 
				{
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				if (registro == true)
				{	
					IG_Bienvenida bienvenida = new IG_Bienvenida(this.app);
					
					bienvenida.setBounds(0, 0, 350, 300);
					bienvenida.setVisible(true);
					bienvenida.setResizable(false);
					bienvenida.setLocationRelativeTo(null);
					this.setVisible(false);
				}
				
			}
			if (textoUsuario.equals("") || textoEmail.equals("") || textoPassword.equals(""))
			{
				JOptionPane.showMessageDialog(null, "ERROR - Llenar los campos de texto para ingresar");
			}
		}
		if (e.getSource() == boton2)
		{
			IG_Bienvenida bienvenida = new IG_Bienvenida(this.app);
			
			bienvenida.setBounds(0, 0, 350, 300);
			bienvenida.setVisible(true);
			bienvenida.setResizable(false);
			bienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) 
	{
		if (check1.isSelected() == true)
		{
			boton1.setEnabled(true);
		}
		else
		{
			boton1.setEnabled(false);
		}
	}

}
