package Logica;

public class ArbolEnario {
	public NodoEnario cabeza;
	public final char FINP='}';
	
	public ArbolEnario() {
		// TODO Auto-generated constructor stub
		cabeza=new NodoEnario('0');
		cabeza.hijo=new NodoEnario(FINP);
	}
	
	public void agregarPalabra(String pa) {
		char[] palabra = pa.toCharArray();
		NodoEnario o = cabeza;
		NodoEnario p = null;
		NodoEnario q = null;
		NodoEnario r = null;
		for (int i = 0; i < palabra.length; i++) {
			q = o.hijo;
			p = new NodoEnario(palabra[i]);
			while (q != null) {
				if (q.valor > p.valor) {
					p.hermano = q;
					if (r == null) {
						o.hijo = p;
					} else {
						r.hermano = p;
					}
					q = p;
					for (int j = i + 1; j < palabra.length; j++) {
						p = new NodoEnario(palabra[j]);
						q.hijo = p;
						q = q.hijo;
					}
					r=new NodoEnario(FINP);
					p.hijo = r;// agrega finalizador a la frase
					return;
				} else if (q.valor < p.valor) {// avance en el nivel actual
					r = q;
					q = q.hermano;
				} else {// el caracter actual esta ya en el nivel
					r=null;
					o = q;
					break;
				}
			}
			if (q == null) {
				r.hermano = p;
				q = p;
				for (int j = i + 1; j < palabra.length; j++) {
					p = new NodoEnario(palabra[j]);
					q.hijo = p;
					q = q.hijo;
				}
				p.hijo = new NodoEnario(FINP);// agrega finalizador a la palabra
				return;
			}
		}
		q=q.hijo;
		while(q!=null){
			r=q;
			q=q.hermano;
		}
		if(r.valor!=FINP){
			p = new NodoEnario(FINP);
			r.hermano=new NodoEnario(FINP);
		}
	}
	
	public boolean buscarPalabra(String p){
		p+="}";
		char[] palabra=p.toCharArray();
		NodoEnario q=cabeza.hijo;
		for(int i=0; i<palabra.length;i++){
			while(q!=null){
				if(q.valor==palabra[i]){
					q=q.hijo;
					break;
				}
				else{
					q=q.hermano;
				}
			}
			if(q==null && palabra[i]!='}')
				return false;
		}
		return true;
	}
	
}
