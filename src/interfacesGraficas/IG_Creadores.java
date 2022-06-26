package interfacesGraficas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import clases.AppLibreria;

public class IG_Creadores extends JFrame implements ActionListener
{		
	private AppLibreria app;
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	private JButton boton1;
	
	public IG_Creadores()
	{
		this.app = IG_Bienvenida.app;
		
		setLayout(null);
		setTitle("Los Creadores");
		getContentPane().setBackground(new Color(230, 178, 99));
		
		label1 = new JLabel("- MIGUEZ DE ARAUJO, TEO");
		label2 = new JLabel("- SULPIZIO, CARLA");
		label3 = new JLabel("- VIGANO, JUAN CRUZ");
		
		label1.setBounds(20,-10,300,100);
		label1.setFont(new Font("Andale Mono", 3, 20));
		label1.setForeground(new Color(0,0,0));
		add(label1);
		
		label2.setBounds(20,40,300,100);
		label2.setFont(new Font("Andale Mono", 3, 20));
		label2.setForeground(new Color(0,0,0));
		add(label2);
		
		label3.setBounds(20,90,300,100);
		label3.setFont(new Font("Andale Mono", 3, 20));
		label3.setForeground(new Color(0,0,0));
		add(label3);
		
		boton1 = new JButton("Salir");
		boton1.setBackground(new Color(255,255,255));
		boton1.setFont(new Font("Andale Mono", 1, 16));
		boton1.setBounds(100,175,120,40);
		boton1.addActionListener(this);
		add(boton1);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == boton1)
		{
			IG_Bienvenida bienvenida = new IG_Bienvenida(this.app);
			
			bienvenida.setBounds(0, 0, 350, 300);
			bienvenida.setVisible(true);
			bienvenida.setResizable(false);
			bienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}
	
	
}
