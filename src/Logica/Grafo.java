package Logica;

import java.util.Stack;

public class Grafo {
	public final int CAN=10;
	public int nodos;
	public NodoGrafo[] listaAdyacencia;
	private int seq;
	private ArbolEnario recAncho;
	private ArbolEnario recProfundo;
	
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
	
	public NodoEnario recorridoProfundo(int v){
		seq=1;
		for(int i=0;i<nodos;i++){
			listaAdyacencia[i].padre=0;
			listaAdyacencia[i].seq=0;
			listaAdyacencia[i].visto=false;
		}
		DFS(v);
		recProfundo=new ArbolEnario();
		formarArbol(recProfundo);
		return recProfundo.cabeza;
	}
	
	private void DFS(int in){
		listaAdyacencia[in].seq=seq++;
		Nodo nd=listaAdyacencia[in].n.siguiente;
		while(nd!=null){
			if(listaAdyacencia[nd.valor].seq==0){
				listaAdyacencia[nd.valor].padre=listaAdyacencia[in].ver;
				DFS(nd.valor);
			}
			nd=nd.siguiente;
		}
	}
	
	public NodoEnario recorridoAncho(int in){
		seq=1;
		for(int i=0; i<nodos; i++){
			listaAdyacencia[i].padre=0;
			listaAdyacencia[i].seq=0;
			listaAdyacencia[i].visto=false;
		}
		GFS(in);
		recAncho=new ArbolEnario();
		formarArbol(recAncho);
		return recAncho.cabeza;
	}
	
	private void GFS(int v){
		Nodo ay;
		NodoGrafo ng;
		Stack<NodoGrafo> c=new Stack<NodoGrafo>();
		listaAdyacencia[v].seq=seq++;
		c.push(listaAdyacencia[v]);
		while(!c.isEmpty()){
			ng=c.get(0);
			c.remove(0);
			ay=ng.n.siguiente;
			while(ay!=null){
				if(listaAdyacencia[ay.valor].seq==0){
					listaAdyacencia[ay.valor].seq=seq++;
					listaAdyacencia[ay.valor].padre=ng.ver;
					c.push(listaAdyacencia[ay.valor]);
				}
				ay=ay.siguiente;
			}
		}
	}
	
	private void formarArbol(ArbolEnario ae){
		int j=0;
		do{
			for(int i=nodos-1; i>=0;i--){
				if(listaAdyacencia[i].seq==nodos-j){
					ae.agregarPalabra(recLista(i));
				}
			}
			j++;
		}while(!listaRecorrida());
	}
	
	private String recLista(int v){
		if(v<0){
			return "";
		}
		listaAdyacencia[v].visto=true;
		return recLista(listaAdyacencia[v].padre-1)+listaAdyacencia[v].ver;
	}
	
	private boolean listaRecorrida(){
		boolean v=true;
		for(int i=0;i<nodos;i++){
			v=(listaAdyacencia[i].visto && v);
		}
		return v;
	}
	
}
