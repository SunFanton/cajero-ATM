package cajeroAutomatico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarcoGeneral extends JFrame{

	private JLabel logo;
	private JButton botonSalir;

	public MarcoGeneral() {
		
		setTitle("Cajero Automático");
		setSize(670,470);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new BorderLayout());
		
		logo = new JLabel(new ImageIcon("LOGO.png"));
		
		botonSalir = new JButton("Salir");
		botonSalir.setFont(new Font("Arial",1,24));
		botonSalir.setBackground(new Color(7,22,84));
		botonSalir.setOpaque(true);
		botonSalir.setBorderPainted(false);	
		botonSalir.setForeground(Color.WHITE);
		botonSalir.addActionListener(new AccionSalir());
		
		add(logo,BorderLayout.NORTH);
		add(botonSalir,BorderLayout.SOUTH);
	}
	
	private class AccionSalir implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 
			if(e.getSource()==botonSalir) {
				
				MarcoSalir marco = new MarcoSalir();	
			}
		}
		
	}
	
}
