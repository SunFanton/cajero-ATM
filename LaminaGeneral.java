package cajeroAutomatico;

import javax.swing.*;
import java.awt.*;

public class LaminaGeneral extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
			
	        super.paintComponent(g);
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        int ancho = getWidth();
	        int alto = getHeight();
	        Color color1 = new Color(255,255,255);
	        Color color2 = new Color(7,22,84);
	        GradientPaint gp = new GradientPaint(0, 0, color1, 0, alto, color2);
	        g2.setPaint(gp);
	        g2.fillRect(0, 0, ancho, alto);
	}
}
