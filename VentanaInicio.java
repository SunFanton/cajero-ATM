package cajeroAutomatico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Marco
public class VentanaInicio extends MarcoGeneral implements ActionListener{
	
	private LaminaGeneral lamina;
	private JPanel franja;
	private JLabel cuenta,
				   pin;
	private JTextField nCuenta;
	private JPasswordField nPin;
	private JButton botonOk,
					botonIngresar;
	
	public VentanaInicio() {
		
		super();
		
		//Lamina Central
		lamina = new LaminaGeneral();
		lamina.setLayout(null);
		
		cuenta = new JLabel("Ingrese Nº de cuenta");
		cuenta.setFont(new Font("Arial",1,28));
		cuenta.setForeground(new Color(7,22,84));
		cuenta.setBounds(30,70,380,35);
		
		nCuenta = new JTextField(25);
		nCuenta.setFont(new Font("Arial",1,24));
		nCuenta.setForeground(new Color(7,22,84));
		nCuenta.setBounds(350,70,260,35);
		
		botonOk = new JButton("Ok");
		botonOk.setFont(new Font("Arial",1,21));
		botonOk.setOpaque(true);
		botonOk.setBorderPainted(false);
		botonOk.setForeground(new Color(7,22,84));
		botonOk.setBackground(new Color(225,225,225));
		botonOk.setBounds(355,120,80,35);
		botonOk.addActionListener(this);
		
		pin = new JLabel("Ingrese PIN");
		pin.setFont(new Font("Arial",1,28));
		pin.setForeground(new Color(109,109,109));
		pin.setBounds(150,200,160,35);
		
		nPin = new JPasswordField(25);
		nPin.setFont(new Font("Arial",1,24));
		nPin.setBackground(Color.LIGHT_GRAY);
		nPin.setEnabled(false);
		nPin.setBounds(350,200,200,35);
		
		botonIngresar = new JButton("Ingresar");
		botonIngresar.setFont(new Font("Arial",1,21));
		botonIngresar.setOpaque(true);
		botonIngresar.setBorderPainted(false);
		botonIngresar.setForeground(new Color(7,22,84));
		botonIngresar.setBackground(new Color(225,225,225));
		botonIngresar.setBounds(355,250,150,35);
		botonIngresar.setEnabled(false);
		botonIngresar.addActionListener(this);
		
		lamina.add(cuenta);
		lamina.add(nCuenta);
		lamina.add(botonOk);
		lamina.add(pin);
		lamina.add(nPin);
		lamina.add(botonIngresar);
		
		//-----------------------------------------
		//Lamina inferior
		franja = new JPanel();
		franja.setBackground(new Color(7,22,84));
		
		
		add(lamina,BorderLayout.CENTER);
		add(franja,BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//Metodo para gestionar los eventos
	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource()==botonOk) {
			
			String cuent = nCuenta.getText();
			char[] caracter = cuent.toCharArray();
			int letra = 0;
			
			for(int i=0;i<caracter.length;i++) {
				if(Character.isLetter(caracter[i]))
					letra++;
			}
			
			if(cuent.equals("") || letra!=0) {
				JOptionPane.showMessageDialog(VentanaInicio.this,"Debes ingresar el número de cuenta con dígitos");
				nCuenta.setText("");
			}
			else {
				pin.setForeground(new Color(7,22,84));
				nPin.setEnabled(true);
				nPin.setBackground(Color.WHITE);
				botonIngresar.setEnabled(true);
			}
		}
		
		else if(e.getSource()==botonIngresar) {
			
			String pass = String.valueOf(nPin.getPassword());
			char[] caracter = pass.toCharArray();
			int letra = 0;
			
			for(int i=0;i<caracter.length;i++) {
				if(Character.isLetter(caracter[i]))
					letra++;
			}
			
			if(pass.length()!=4 || letra!=0) {
				JOptionPane.showMessageDialog(VentanaInicio.this,"Debes ingresar tu PIN de 4 dígitos numéricos");
				nPin.setText("");
			}
			else {
				VentanaMenu ventanaMenu = new VentanaMenu();
				dispose();
			}
		}
		
	}
	
	//Método main
	public static void main(String[] args) {
		
		VentanaInicio ventanaInicio = new VentanaInicio();
	}

}


