package cajeroAutomatico;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

//Marco
public class VentanaMenu extends MarcoGeneral implements ActionListener{
	
	private LaminaGeneral lamina;
	private JButton consulta,
					extraccion,
					depositar,
					transferir;
	
	public VentanaMenu() {
		
		lamina = new LaminaGeneral();
		
		lamina.setLayout(new GridLayout(2,2,25,25));
		
		consulta = crearBoton("Consulta de saldo");
		extraccion = crearBoton("Extracción");
		depositar = crearBoton("Depositar en cuenta");
		transferir = crearBoton("Transferencia");
		
		lamina.add(consulta);
		lamina.add(extraccion);
		lamina.add(depositar);
		lamina.add(transferir);
		
		add(lamina,BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Método para construir los botones
	public JButton crearBoton(String nom) {
		
		JButton boton = new JButton(nom);
		boton.setFont(new Font("Arial",1,28));
		boton.setForeground(new Color(8,23,84));
		boton.setBackground(new Color(225,225,225));
		boton.setOpaque(true);
		boton.setBorder(new LineBorder(Color.WHITE));
		boton.addActionListener(this);

		return boton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==consulta) {
			VentanaSaldo ventanaSaldo = new VentanaSaldo();
			this.setVisible(false);
		}
		
		if(e.getSource()==extraccion) {
			VentanaExtraccion ventanaExtraccion = new VentanaExtraccion();
			this.setVisible(false);
		}
		
		if(e.getSource()==depositar) {
			VentanaDepositar ventanaDepositar = new VentanaDepositar();
			this.setVisible(false);
		}
		
		if(e.getSource()==transferir) {
			VentanaTransferencia ventanaTransferencia = new VentanaTransferencia();
			this.setVisible(false);
		}
	}

	//A descartar
	public static void main(String[] args) {
		
		VentanaMenu ventana = new VentanaMenu();
	}
}


