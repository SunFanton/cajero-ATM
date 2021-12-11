package cajeroAutomatico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MarcoSalir extends JFrame implements ActionListener{

	private JLabel logo,
				   pregunta;
	private JButton si,
					no;
	private JPanel lamina;
	
	public MarcoSalir() {
		
		setLayout(null);
		
		setTitle("¿Desea salir?");
		setSize(520,165);
		setLocationRelativeTo(null);
		setResizable(false);
		
		lamina = new JPanel();
		lamina.setSize(520,165);
		lamina.setBackground(new Color(200,200,200));
		lamina.setLayout(null);
		
		logo = new JLabel(new ImageIcon("logo2.png"));
		logo.setBounds(20,18,150,100);
		lamina.add(logo);
		
		pregunta = new JLabel("¿Desea salir de la cuenta?");
		pregunta.setFont(new Font("Arial",1,21));
		pregunta.setForeground(new Color(7,22,84));
		pregunta.setBounds(200,25,330,40);
		lamina.add(pregunta);
		
		si = new JButton("SÍ");
		si.setFont(new Font("Arial",1,21));
		si.setBackground(new Color(7,22,84));
		si.setOpaque(true);
		si.setBorderPainted(false);	
		si.setForeground(Color.WHITE);
		si.setBounds(230,68,75,35);
		si.addActionListener(this);
		lamina.add(si);
		
		no = new JButton("NO");
		no.setFont(new Font("Arial",1,21));
		no.setBackground(new Color(7,22,84));
		no.setOpaque(true);
		no.setBorderPainted(false);	
		no.setForeground(Color.WHITE);
		no.setBounds(365,68,75,35);
		no.addActionListener(this);
		lamina.add(no);
		
		add(lamina);
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==si) {
			Frame marcos[] = Frame.getFrames();
			
			for(int i=0;i<marcos.length;i++)
				marcos[i].dispose();
			
			VentanaInicio ventanaInicio = new VentanaInicio();
			
			GestorCuenta.resetearSaldo();
		}
		else if(e.getSource()==no) {
			dispose();
		}
		
	}

	
}
