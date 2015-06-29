package model;

import java.util.LinkedList;

public class Nodo {

//	public LinkedList<Integer> vecinos = new LinkedList<Integer>();
//	public Vector<ListIterator<Integer>> vectorIterador = new Vector(20);
	
	private ConjuntoAcotado conjunto = new ConjuntoAcotado(20);
	
	public LinkedList<Integer>getVecinos(){
		return conjunto.getElements();
	}
	
	public void agregarVecino(int vertice){
		conjunto.agregar(vertice);
	}
	
	
	public boolean esVecino(int vertice){
		return conjunto.pertenece(vertice);
	}
	
	public void borrarVecino(int vertice){
		conjunto.eliminar(vertice);
	}
}


