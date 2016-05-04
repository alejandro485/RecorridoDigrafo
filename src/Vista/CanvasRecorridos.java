package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Logica.NodoEnario;

public class CanvasRecorridos extends Canvas {

	private static final long serialVersionUID = 1L;
	private Image imagen;
	private Graphics graficas;
	private NodoEnario cabAncho, cabProfundo;
	private int difX, difY;
	
	public CanvasRecorridos() {
		// TODO Auto-generated constructor stub
		cabAncho=null;
		cabProfundo=null;
		difX=30;
		difY=30;
	}
	
	public void setCabezas(NodoEnario ca, NodoEnario cp){
		cabAncho=ca;
		cabProfundo=cp;
		repaint();
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g) {
		imagen = createImage(this.getWidth(), this.getHeight());
		graficas= imagen.getGraphics();
		graficas.setColor(Color.white);
		graficas.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(imagen, 0, 0, this);
		if(cabAncho!=null){
			graficas.setColor(Color.black);
			graficas.drawString("Recorrido a lo ancho", 40, 50);
			pintarArbol(cabAncho,40,70,40,70);
		}
		if(cabProfundo!=null){
			graficas.setColor(Color.black);
			graficas.drawString("Recorrido a lo profundo", 340, 50);
			pintarArbol(cabProfundo, 340, 70, 340, 70);
		}
		g.drawImage(imagen, 0, 0, this);
	}
	
	private int pintarArbol(NodoEnario n, int pocX, int pocY, int pocAX,
			int pocAY) {
		int a;
		if (n != null) {
			graficas.setColor(Color.black);
			graficas.drawLine(pocX + 1, pocY + 1, pocAX + 1, pocAY + 1);
			graficas.drawLine(pocX, pocY, pocAX, pocAY);
			graficas.drawLine(pocX - 1, pocY - 1, pocAX - 1, pocAY - 1);
			a=pintarArbol(n.hijo, pocX, pocY + difY, pocX, pocY);
			graficas.setColor(Color.white);
			graficas.fillRect(pocX, pocY - 20, 20, 20);
			graficas.setColor(Color.black);
			graficas.drawString(n.valor + "", pocX + 5, pocY - 5);
			a+=pintarArbol(n.hermano, a+ pocX+difX, pocY, pocX, pocY);
			if(n.hermano!=null)
				a+=difX;
			return a;
		}
		return 0;
	}
}
