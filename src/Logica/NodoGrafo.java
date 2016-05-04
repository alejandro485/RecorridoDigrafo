package Logica;

public class NodoGrafo {
	public int pocX;
	public int pocY;
	public int padre;
	public int seq;
	public int ver;
	public boolean visto;
	public Nodo n;
	
	public NodoGrafo(int v, int x, int y) {
		n=new Nodo(v);
		ver=v+1;
		pocX=x;
		pocY=y;
		padre=0;
		seq=0;
		visto=false;
	}
}
