package model;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

public class Grafo {
	
	//Primero el vector con listas que guardan los vecinos
	//grafo no dirigido
	private Vector<LinkedList<Integer>>vertices = new Vector<LinkedList<Integer>>();
	
	public Grafo(){
	}
	
	public void addArista(int v1, int v2){
		addVecino(v1,v2);
		addVecino(v2,v1);	
	}
	
	
	private void addVecino(int vertice, int vecino){
		LinkedList<Integer> vecinosV1 = getVecinos(vertice);
		vecinosV1.add(vecino);
	}
	
	public void addVertice(){
		int index = vertices.size();
		LinkedList<Integer> listaNueva = new LinkedList<Integer>();
		vertices.insertElementAt(listaNueva, index);
	}
	
	public boolean contieneVertice(int vertice){
		return vertices.size() > vertice;
	}
	
	
	public boolean sonAdyacentes(int verticeA, int verticeB){
		 LinkedList<Integer> listaA = getVecinos(verticeA);
		 return listaA.contains(verticeB);
	}

	private LinkedList<Integer> getVecinos(int verticeA) {
		LinkedList<Integer> listaA = vertices.elementAt(verticeA);
		return listaA;
	}
	
	private void borrarArista(int vertice, ListIterator<Integer> iter){
		boolean borrado = false;
		while(iter.hasNext() || borrado ){
			if(iter.next() == vertice){
				iter.remove();
				borrado= true;
			}
		}
	}
	
	public void borrarArista(int verticeA, int verticeB){
		ListIterator<Integer>iter = getVecinos(verticeA).listIterator();
		ListIterator<Integer>iterB = getVecinos(verticeB).listIterator();
		borrarArista(verticeB, iter); //borrar verticeB, de los vecinos de A
		borrarArista(verticeA,iterB); // borrar verticeA, de los vecinos de B
		
	}
	
	
	public void borrarVertice(int vertice){
		ListIterator<Integer> iter = getVecinos(vertice).listIterator();
		while(iter.hasNext()){
			int vecino = iter.next();
			ListIterator<Integer>iterVecino = vertices.elementAt(vecino).listIterator();
			borrarArista(vertice,iterVecino);
		}		
	
		vertices.set(vertice, null);
	}
	
	
	public static void main(String[] args) {
		
		Grafo g = new Grafo();
		g.addVertice(); // vertice 0
		g.addVertice(); //vertice 1
		g.addVertice(); //vertice 2
		g.addVertice(); //vertice 3
		g.addVertice(); //vertice 4
		
		//arista vertice 0
		
		g.addArista(0, 1);
		
		//arista vertice 1
		g.addArista(1, 3);
		g.addArista(1, 2);
		
		//arista vertice 2
		g.addArista(2, 3);
		
		
		System.out.println("son adyacentes 3 2  " +g.sonAdyacentes(3, 2));
		
	
		g.borrarVertice(1);
		//g.borrarArista(3, 2);
		
		System.out.println("son adyacentes 3 2" +g.sonAdyacentes(3,2));
		
		
	}
	
	

}
