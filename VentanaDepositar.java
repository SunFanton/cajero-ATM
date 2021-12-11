package cajeroAutomatico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Marco
public class VentanaDepositar extends MarcoGeneral implements ActionListener{
	
	private LaminaGeneral lamina;
	private JPanel laminaBotones,
				   laminaCentro,
				   laminaTitulo;
	private JLabel titulo,
				   pregunta,
				   importe,
				   listo;
	private JComboBox combo;
	private JTextField imp;
	private JButton depositar;
	private BotonesMenus volver,
						 imprimir;
	
	public VentanaDepositar() {
		
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
		imprimir.setEnabled(false);
		
		laminaBotones.add(volver);
		laminaBotones.add(imprimir);
		
		//----------------------------------
		//Lamina Titulo (superior)
		laminaTitulo = new JPanel();
		laminaTitulo.setOpaque(false);
		titulo = new JLabel("Depositar en cuenta");
		titulo.setFont(new Font("Arial",1,42));
		titulo.setForeground(new Color(8,23,84));
		laminaTitulo.add(titulo);
						
		//----------------------------------
		//Lamina Centro
				
		laminaCentro = new JPanel();
		laminaCentro.setOpaque(false);
		laminaCentro.setLayout(null);
				
		pregunta = new JLabel("¿Cuánto desea depositar?");
		pregunta.setFont(new Font("Arial",1,29));
		pregunta.setForeground(new Color(8,23,84));
		pregunta.setBounds(15,20,380,35);
				
		importe = new JLabel("Coloque el importe  $ ");
		importe.setFont(new Font("Arial",1,30));
		importe.setForeground(new Color(8,23,84));
		importe.setBounds(70,85,350,35);
		importe.setVisible(false);
				
		listo = new JLabel("LISTO!");
		listo.setFont(new Font("Arial",1,30));
		listo.setForeground(new Color(0,0,0,0));
		listo.setBounds(275,140,100,35);
				
		combo = new JComboBox();
		combo.setFont(new Font("Arial",1,24));
		combo.setForeground(new Color(8,23,84));
		combo.addItem("$ 1000");
		combo.addItem("$ 3000");
		combo.addItem("$ 5000");
		combo.addItem("Otro");
		combo.setEditable(false);
		combo.setBounds(410,20,200,35);
		combo.addActionListener(this);		
		
		imp = new JTextField(25);
		imp.setFont(new Font("Arial",1,24));
		imp.setForeground(new Color(8,23,84));
		imp.setBounds(410,85,200,35);
		imp.setEnabled(false);
		imp.setVisible(false);
		imp.setBorder(BorderFactory.createEmptyBorder());
				
		depositar = new JButton("Depositar");
		depositar.setFont(new Font("Arial",1,24));
		depositar.setOpaque(true);
		depositar.setForeground(new Color(7,22,84));
		depositar.setBackground(new Color(225,225,225));
		depositar.setBounds(410,140,150,35);
		depositar.addActionListener(this);
				
		laminaCentro.add(pregunta);
		laminaCentro.add(importe);
		laminaCentro.add(listo);
		laminaCentro.add(combo);
		laminaCentro.add(imp);
		laminaCentro.add(depositar);
				
		//----------------------------------
		lamina.add(laminaTitulo,BorderLayout.NORTH);
		lamina.add(laminaCentro,BorderLayout.CENTER);
		lamina.add(laminaBotones,BorderLayout.SOUTH);
		
		add(lamina,BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String eleccion = (String)combo.getSelectedItem();
		int monto = 0;
		
		//Combo
		if(eleccion.equalsIgnoreCase("Otro")) {
			importe.setVisible(true);
			imp.setVisible(true);
			imp.setEnabled(true);
		}
		else if(!eleccion.equalsIgnoreCase("Otro")) {
			importe.setVisible(false);
			imp.setText("");
			imp.setVisible(false);
			imp.setEnabled(false);
		}
		
		//Boton Depositar
		if(e.getSource()==depositar) {
			
			if(eleccion.equalsIgnoreCase("Otro")) {
				
				char[] caracter = imp.getText().toCharArray();
				int letra = 0;
				
				for(int i=0;i<caracter.length;i++) {
					if(Character.isLetter(caracter[i]))
						letra++;
				}
				
				if(imp.getText().equals("") || letra!=0) {
					JOptionPane.showMessageDialog(VentanaDepositar.this,"Por favor, ingresa un monto numérico");
					imp.setText("");
				}
				else {
					monto = Integer.parseInt(imp.getText());
				}
			}
			
			else {
				monto = Integer.parseInt(eleccion.replaceAll("[^0-9]",""));
			}
			
			if(monto!=0) {
				boolean operacion = GestorCuenta.sumarDinero(monto);
				if(operacion) {
					listo.setForeground(new Color(0,255,18));
					imprimir.setEnabled(true);
					depositar.setEnabled(false);
				}
				else {
					JOptionPane.showMessageDialog(VentanaDepositar.this,"No se ha podido realizar la operación");
					imp.setText("");
				}
			}
			
		}
		
		//Boton Volver
		if(e.getSource()==volver) {
			
			VentanaMenu ventanaMenu = new VentanaMenu();
			this.setVisible(false);
		}
		
	}
	
	//A descartar
	public static void main(String[] args) {
		
		VentanaDepositar ventana = new VentanaDepositar();
	}
	
}
