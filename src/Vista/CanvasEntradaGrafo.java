package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Logica.Nodo;
import Logica.NodoGrafo;

public class CanvasEntradaGrafo extends Canvas {
	
	private static final long serialVersionUID = 1L;
	private Image imagen;
	private Graphics graficas;
	private NodoGrafo[] lista;
	private int cantN;
	
	public CanvasEntradaGrafo() {
		// TODO Auto-generated constructor stub
		lista=null;
	}
	
	public void setLista(NodoGrafo[] lista, int n){
		cantN=n;
		this.lista=lista;
		repaint();
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
		imagen = createImage(this.getWidth(), this.getHeight());
		graficas= imagen.getGraphics();
		graficas.setColor(Color.white);
		graficas.fillRect(0, 0, this.getWidth(), this.getHeight());
		if(lista!=null){
			pintarLista();
		}
		g.drawImage(imagen, 0, 0, this);
	}
	
	private void pintarLista(){
		NodoGrafo ng,ay;
		Nodo b;
		for(int i=0; i<cantN; i++){
			ng=lista[i];
			b=ng.n;
			while(b!=null){
				ay=lista[b.valor];
				graficas.setColor(Color.black);
				graficas.drawLine(ng.pocX, ng.pocY, ay.pocX, ay.pocY);
				b=b.siguiente;
			}
		}
		for(int i=0;i<cantN;i++){
			ng=lista[i];
			graficas.setColor(Color.white);
			graficas.fillOval(ng.pocX-10, ng.pocY-10, 20, 20);
			graficas.setColor(Color.black);
			graficas.drawOval(ng.pocX-10, ng.pocY-10, 20, 20);
			graficas.drawString(ng.ver+"", ng.pocX-2, ng.pocY+3);
		}
	}
}
