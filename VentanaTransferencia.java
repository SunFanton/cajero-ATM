package cajeroAutomatico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Marco
public class VentanaTransferencia extends MarcoGeneral implements ActionListener{
	
	private LaminaGeneral lamina;
	private JPanel laminaBotones,
				   laminaCentro,
				   laminaTitulo;
	private JLabel titulo,
				   pregunta,
				   importe,
				   listo;
	private JTextField nCuenta,
					   imp;
	private JButton transferir,
					ok;
	private BotonesMenus volver,
						 imprimir;
	public VentanaTransferencia() {
		
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
		titulo = new JLabel("Transferencia");
		titulo.setFont(new Font("Arial",1,42));
		titulo.setForeground(new Color(8,23,84));
		laminaTitulo.add(titulo);
								
		//----------------------------------
		//Lamina Centro
						
		laminaCentro = new JPanel();
		laminaCentro.setOpaque(false);
		laminaCentro.setLayout(null);
						
		pregunta = new JLabel("Nº de cuenta a transferir");
		pregunta.setFont(new Font("Arial",1,30));
		pregunta.setForeground(new Color(8,23,84));
		pregunta.setBounds(25,20,380,35);
						
		importe = new JLabel("Coloque el importe  $ ");
		importe.setFont(new Font("Arial",1,30));
		importe.setForeground(new Color(8,23,84));
		importe.setBounds(70,85,350,35);
		importe.setVisible(false);
						
		listo = new JLabel("LISTO!");
		listo.setFont(new Font("Arial",1,30));
		listo.setForeground(new Color(0,0,0,0));
		listo.setBounds(275,140,100,35);
						
		nCuenta = new JTextField(25);
		nCuenta.setFont(new Font("Arial",1,24));
		nCuenta.setForeground(new Color(8,23,84));
		nCuenta.setBounds(380,20,200,35);
		
		ok = new JButton("Ok");
		ok.setFont(new Font("Arial",1,12));
		ok.setOpaque(true);
		ok.setBackground(new Color(225,225,225));
		ok.setBounds(585,20,50,35);
		ok.addActionListener(this);
						
		imp = new JTextField(25);
		imp.setFont(new Font("Arial",1,24));
		imp.setForeground(new Color(8,23,84));
		imp.setEditable(false);
		imp.setBounds(380,85,200,35);
		imp.setVisible(false);
		imp.setBorder(BorderFactory.createEmptyBorder());		
		
		transferir = new JButton("Transferir");
		transferir.setFont(new Font("Arial",1,24));
		transferir.setOpaque(true);
		transferir.setForeground(new Color(7,22,84));
		transferir.setBackground(new Color(225,225,225));
		transferir.setBounds(380,140,150,35);
		transferir.setEnabled(false);
		transferir.addActionListener(this);
						
		laminaCentro.add(pregunta);
		laminaCentro.add(importe);
		laminaCentro.add(listo);
		laminaCentro.add(nCuenta);
		laminaCentro.add(ok);
		laminaCentro.add(imp);
		laminaCentro.add(transferir);
						
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
		
		//Boton Ok
		if(e.getSource()==ok) {
			
			char[] caracter = nCuenta.getText().toCharArray();
			int letra = 0;
			
			for(int i=0;i<caracter.length;i++) {
				if(Character.isLetter(caracter[i]))
					letra++;
			}
			
			if(nCuenta.getText().equals("") || letra!=0) {
				JOptionPane.showMessageDialog(VentanaTransferencia.this,"Por favor, ingresa la cuenta con dígitos numéricos");
				nCuenta.setText("");
			}	
			else {
				transferir.setEnabled(true);
				importe.setVisible(true);
				imp.setVisible(true);
				imp.setEditable(true);
			}
		}
		
		//Boton Transferir
		if(e.getSource()==transferir) {
			
			char[] caracter = imp.getText().toCharArray();
			int letra = 0;
			
			for(int i=0;i<caracter.length;i++) {
				if(Character.isLetter(caracter[i]))
					letra++;
			}
			
			
			if(imp.getText().equals("") || letra!=0) {
				JOptionPane.showMessageDialog(VentanaTransferencia.this,"Por favor, ingresa el monto con dígitos numéricos");
				imp.setText("");
			}	
			else {
				int monto = Integer.parseInt(imp.getText());
				boolean operacion = GestorCuenta.restarDinero(monto);
				if(operacion) {
					listo.setForeground(new Color(0,255,18));
					imprimir.setEnabled(true);
					transferir.setEnabled(false);
				}
				else {
					JOptionPane.showMessageDialog(VentanaTransferencia.this,"No se ha podido realizar la operación");
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
		
		VentanaTransferencia ventana = new VentanaTransferencia();
	}

}
