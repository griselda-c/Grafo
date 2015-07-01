package model;

import java.util.Iterator;
import java.util.Vector;

public class Grafo {
	
		private Vector<Nodo>vertices = new Vector<Nodo>();
		
		public Grafo(){
		}
		
		public void addArista(int v1, int v2){
			Nodo vertice1 = vertices.elementAt(v1);
			vertice1.agregarVecino(v2); 
			
			Nodo vertice2 = vertices.elementAt(v2);
			vertice2.agregarVecino(v1);
		}
		
		
		
		public void addVertice(){
			int index = vertices.size();
			Nodo verticeNuevo = new Nodo();
			vertices.insertElementAt(verticeNuevo, index);
		}
		
		public boolean contieneVertice(int vertice){
			 return vertices.elementAt(vertice) != null;
		}
		
		
		public boolean sonAdyacentes(int verticeA, int verticeB){
			 Nodo vertice = vertices.elementAt(verticeA);
			 return vertice.esVecino(verticeB);
		}

		
		
		public void borrarArista(int vertice, int vertice2){
			Nodo vertice1 = vertices.elementAt(vertice);
			vertice1.borrarVecino(vertice2);
			
			Nodo v2 = vertices.elementAt(vertice2);
			v2.borrarVecino(vertice);
				
		}
		
		
		
		public void borrarVertice(int vertice){
			Nodo verticeABorrar = vertices.elementAt(vertice);
			Iterator<Integer> iter = verticeABorrar.getVecinos().iterator();
			
			// borrarse de los vecinos
			while(iter.hasNext()){
				Integer i = iter.next();
				Nodo nodo = vertices.elementAt(i);
				nodo.borrarVecino(vertice);
				System.out.println("complete exitosamente " +i);
			}		
			vertices.remove(vertice);
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
