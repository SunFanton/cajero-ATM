package cajeroAutomatico;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BotonesMenus extends JButton{

	public BotonesMenus(String nom) {
		
		super(nom);
		
		setFont(new Font("Arial",1,24));
		setOpaque(false);
		setContentAreaFilled(false);
		setBorder(new LineBorder(Color.WHITE));	
		setForeground(Color.WHITE);
	}
}
