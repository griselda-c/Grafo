package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class Grafo {
	
//	private Vector<VertexDescriptor> vertices = new Vector<VertexDescriptor>();
	
	private LinkedList<VertexDescriptor> vertices = new LinkedList<VertexDescriptor>();
	
	/**
	 * Constructor de un grafo vacio
	 */
	public Grafo(){
	}
	
	/**
	 * Inserta un nuevo vertice al grafo y retorna el numero del indice agregado.
	 * 
	 * En caso de querer utilizar otro tipo de identificadores para los vertices,
	 * se necesita algun tipo de diccionario externo.  En este proyecto no tomamos
	 * este problema en cuenta
	 * 
	 * @return numero del vertice agregado
	 */
	public Vertex addVertex(Integer id){
		vertices.addFirst(new VertexDescriptor());
		
		return new Vertex(id, vertices.listIterator());
	}

	/**
	 * Elimina el vertice v del grafo si el mismo pertenece al grafo.
	 * Si no pertenece no hace nada.
	 * 
	 * @param v vertice a eliminar
	 */
	public void removeVertex(Integer v){
		VertexDescriptor verticeABorrar = vertices.elementAt(vertice);
		Iterator<Integer> iter = verticeABorrar.getVecinos().iterator();
		
		// borrarse de los vecinos
		while(iter.hasNext()){
			Integer i = iter.next();
			VertexDescriptor nodo = vertices.elementAt(i);
			nodo.borrarVecino(vertice);
			System.out.println("complete exitosamente " +i);
		}		
		vertices.remove(vertice);
	}
	
	/**
	 * Agrega la arista vw al grafo.  Si la arista ya existe, no se agrega.
	 * 
	 * @param v uno de los vertices de la arista
	 * @param w el otro vertice de la arista
	 */
	public void addEdge(Integer v, Integer w){
		VertexDescriptor vertice1 = vertices.elementAt(v1);
		vertice1.agregarVecino(v2); 
		
		VertexDescriptor vertice2 = vertices.elementAt(v2);
		vertice2.agregarVecino(v1);
	}

	
	/**
	 * Elimina la arista vw del grafo.  Si no pertenece al grafo, no hace nada
	 * 
	 * @param v uno de los vertices de la arista
	 * @param w el otro vertice de la arista
	 */
	public void removeEdge(Integer v, Integer w){
		VertexDescriptor vertice1 = vertices.elementAt(vertice);
		vertice1.borrarVecino(vertice2);
		
		VertexDescriptor v2 = vertices.elementAt(vertice2);
		v2.borrarVecino(vertice);
			
	}

	
	/**
	 * @return cantidad de vertices del grafo
	 */
	public Integer vertexCount() {
		return vertices.size();
	}
	
	/**
	 * 
	 * @param v
	 * @return grado de un vertex
	 */
	public Integer degree(Vertex v) {
		return v.getDescriptor().degree;
	}
	
	/**
	 * Pertenencia de la arista vw
	 * 
	 * @param v
	 * @param w
	 * @return true si la arista pertenece al grafo.
	 */
	public boolean hasEdge(Vertex v, Vertex w){
		Vertex max = v, min = w;
		if(degree(v) < degree(w)) {
			max = w; min = v;
		}
		
		for (NeighborDescriptor nd : min.getDescriptor().highNeighborhood) {
			if(nd.neighbor == max.getId()) return true;
		}
		
		return false;
	}

	
	/**
	 * Retorna un iterador a los vecinos de v
	 * 
	 * @param args
	 */
	public VertexIterator iterNeighbors() {
		
	}
	
	/**
	 * Retorna un iterador a los vecinos de v que tienen grado al menos d(v)
	 * 
	 * @param v
	 * @return iterador a los vecinos de v.
	 */
	public VertexIterator iterHighNeighbors(Integer v) {
		
		
	}
	
	/**
	 * Retorna un iterador que nos permite recorrer N'(v)
	 * 
	 * @param v
	 * @return
	 */
	public EdgeIterator iterEdgeNeighbors(Integer v) {
		
		
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
