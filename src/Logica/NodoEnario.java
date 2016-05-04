package Logica;

public class NodoEnario {
	public char valor;
	public NodoEnario hijo;
	public NodoEnario hermano;
	
	public NodoEnario(char v) {
		valor=v;
		hijo=null;
		hermano=null;
	}
}
