package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

public class Graph {
	
//	private Vector<VertexDescriptor> vertices = new Vector<VertexDescriptor>();
	
	private LinkedList<VertexDescriptor> vertexes = new LinkedList<VertexDescriptor>();
	
	/**
	 * Constructor de un grafo vacio
	 */
	public Graph(){
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
		vertexes.addFirst(new VertexDescriptor());
		
		return new Vertex(id, vertexes.listIterator());
	}

	/**
	 * Elimina el vertice v del grafo si el mismo pertenece al grafo.
	 * Si no pertenece no hace nada.
	 * 
	 * @param v vertice a eliminar
	 */
	public void removeVertex(Integer v){
		VertexDescriptor vertexToDelete = vertexes.elementAt(vertex);
		Iterator<Integer> iter = vertexToDelete.().iterator();
		
		// borrarse de los vecinos
		while(iter.hasNext()){
			Integer i = iter.next();
			VertexDescriptor node = vertexes.elementAt(i);
			node.borrarVecino(vertex);
			System.out.println("complete exitosamente " +i);
		}		
		vertexes.remove(vertex);
	}
	
	/**
	 * Agrega la arista vw al grafo.  Si la arista ya existe, no se agrega.
	 * 
	 * @param v uno de los vertices de la arista
	 * @param w el otro vertice de la arista
	 */
	public void addEdge(Vertex v, Vertex w){
		VertexDescriptor vd = v.getPointer().next();
		VertexDescriptor wd = w.getPointer().next();
		
		ListIterator<LinkedList<NeighborDescriptor>> iterLow = vd.lowNeighborhood.listIterator();
		while (iterLow.hasNext()) {
			LinkedList<NeighborDescriptor> degreeNeighbors = iterLow.next();
			ListIterator<NeighborDescriptor> iter          = degreeNeighbors.listIterator();
			while (iter.hasNext()) {
				NeighborDescriptor nd = iter.next();
				ListIterator<LinkedList<NeighborDescriptor>> listNvPointer = nd.list_pointer;
				LinkedList<NeighborDescriptor> listNv       = listNvPointer.next();
				ListIterator<NeighborDescriptor> iterListNv = listNv.listIterator();
				// listNv es la lista que representa donde esta v en su vecino
				VertexDescriptor vdx = vertexes.get(nd.neighbor);							
				// Comparamos los grados de v y su vecino para saber si v esta en low,
				// si esta en high no hacemos nada
				if (vdx.degree > vd.degree) {
					while (iterListNv.hasNext()) {
						NeighborDescriptor xnd = iterListNv.next();
						// Sabiendo que está en low necesitamos iterar la lista, buscar a v y borrarlo
						if (xnd.neighbor == v.getId()) {
							iterListNv.remove();
							break;
						}
					}
					
				}
			}
		}
		increaseDegree(vd, wd);
	}

	private void increaseDegree(VertexDescriptor vd, VertexDescriptor wd) {
		vd.degree =+ vd.degree + 1;
		wd.degree =+ wd.degree + 1;
	}

	
	/**
	 * Elimina la arista vw del grafo.  Si no pertenece al grafo, no hace nada
	 * 
	 * @param v uno de los vertices de la arista
	 * @param w el otro vertice de la arista
	 */
	public void removeEdge(Integer v, Integer w){
		VertexDescriptor v1 = vertexes.elementAt(v);
		v1.borrarVecino(w);
		
		VertexDescriptor v2 = vertexes.elementAt(w);
		v2.borrarVecino(v);
			
	}

	
	/**
	 * @return cantidad de vertices del grafo
	 */
	public Integer vertexCount() {
		return vertexes.size();
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
	public VertexIterator iterNeighbors(Integer v) {
		
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
		
		Graph g = new Graph();
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
