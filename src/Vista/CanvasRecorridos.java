package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class CanvasRecorridos extends Canvas {

	private static final long serialVersionUID = 1L;
	private Image imagen;
	private Graphics graficas;
	
	public void update(Graphics g) {
		imagen = createImage(this.getWidth(), this.getHeight());
		graficas= imagen.getGraphics();
		graficas.setColor(Color.orange);
		graficas.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(imagen, 0, 0, this);
	}
}
