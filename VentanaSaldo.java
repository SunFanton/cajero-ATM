package cajeroAutomatico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Marco
public class VentanaSaldo extends MarcoGeneral implements ActionListener{
	
	private LaminaGeneral lamina;
	private JLabel titulo,
				   frase,
				   saldo;
	private JPanel laminaBotones,
				   laminaTitulo,
				   laminaCentro;
	private BotonesMenus volver,
						 imprimir;
	
	public VentanaSaldo() {
		
		super();
		
		lamina = new LaminaGeneral();
		lamina.setLayout(new BorderLayout());
		
		//Lamina Botones (inferior)
		laminaBotones = new JPanel();
		laminaBotones.setOpaque(false);
		laminaBotones.setLayout(new GridLayout(1,2,10,10));
		
		volver = new BotonesMenus("Volver al Menú");
		volver.addActionListener(this);
		
		imprimir = new BotonesMenus("Imprimir comprobante");
		
		laminaBotones.add(volver);
		laminaBotones.add(imprimir);
		
		//----------------------------------
		//Lamina Titulo (superior)
		laminaTitulo = new JPanel();
		laminaTitulo.setOpaque(false);
		titulo = new JLabel("Consulta de saldo");
		titulo.setFont(new Font("Arial",1,42));
		titulo.setForeground(new Color(8,23,84));
		laminaTitulo.add(titulo);
		
		//----------------------------------
		//Lamina Centro
		laminaCentro = new JPanel();
		laminaCentro.setOpaque(false);
		laminaCentro.setLayout(new BoxLayout(laminaCentro,BoxLayout.Y_AXIS));
		
		frase = new JLabel("Su saldo disponible en la cuenta es: ");
		frase.setFont(new Font("Arial",1,30));
		frase.setForeground(new Color(8,23,84));
		frase.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		saldo = new JLabel("$ "+ GestorCuenta.obtenerSaldo());
		saldo.setFont(new Font("Arial",1,35));
		saldo.setForeground(new Color(8,23,84));
		saldo.setOpaque(true);
		saldo.setBackground(new Color(225,225,225));
		saldo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		laminaCentro.add(Box.createVerticalGlue());
		laminaCentro.add(frase);
		laminaCentro.add(Box.createVerticalGlue());
		laminaCentro.add(saldo);
		laminaCentro.add(Box.createVerticalGlue());
		
		//--------------------------------------
		lamina.add(laminaTitulo,BorderLayout.NORTH);
		lamina.add(laminaCentro,BorderLayout.CENTER);
		lamina.add(laminaBotones,BorderLayout.SOUTH);
		
		add(lamina,BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==volver) {
			
			VentanaMenu ventanaMenu = new VentanaMenu();
			this.setVisible(false);
		}
		
	}
	
	//A descartar
	public static void main(String[] args) {
		
		VentanaSaldo ventana = new VentanaSaldo();
	}
	
}
