package Logica;

public class Grafo {
	public final int CAN=10;
	public int nodos;
	public NodoGrafo[] listaAdyacencia;
	private int seq;
	
	public Grafo() {
		seq=0;
		nodos=0;
		listaAdyacencia=new NodoGrafo[CAN];
		for(int i=0 ; i<CAN ; i++){
			listaAdyacencia[i]=null;
		}
	}
	
	public void AgregarNodo(int x, int y){
		if(nodos<CAN){
			listaAdyacencia[nodos]=new NodoGrafo(nodos, x, y);
			nodos++;
		}
		else{
			System.out.println("No se puede agregar mas nodos");
		}
	}
	
	public void AgregarAdyacente(int in, int ad){
		NodoGrafo ng=listaAdyacencia[in];
		Nodo nd=ng.n;
		Nodo sg=nd.siguiente;
		while(sg!=null){
			if(sg.valor!=ad){
				nd=sg;
				sg=sg.siguiente;
			}
			else{
				return;
			}
		}
		nd.siguiente=new Nodo(ad);
	}
	
	public void recorridoAncho(int v){
		seq=1;
		visitarNodoGrafo(v);
		NodoGrafo[] g=listaAdyacencia;
		for(int i=0;i<nodos;i++){
			System.out.println(":::Fila "+i+": "+g[i].ver+" - "+g[i].padre+" - "+g[i].seq+" :::");
		}
	}
	
	private void visitarNodoGrafo(int in){
		listaAdyacencia[in].seq=seq++;
		System.out.println("Vertice actual: "+listaAdyacencia[in].ver);
		Nodo nd=listaAdyacencia[in].n.siguiente;
		while(nd!=null){
			if(listaAdyacencia[nd.valor].seq==0){
				listaAdyacencia[nd.valor].padre=listaAdyacencia[in].ver;
				visitarNodoGrafo(nd.valor);
			}
			nd=nd.siguiente;
		}
	}
	
}
