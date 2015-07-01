package model;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Los objetos de esta clase se van a almacenar en listas que juntas representan el vecindario N(v) de un vertice v.
 * El vecindario de N(v) se divide en dos.  Por una parte, esta la lista H(v) de los vecinos mayores o iguales a v
 * y por otra esta L(v) que es una lista L(v, 1), L(v, 2), ..., L(v, k) donde cada L(v, i) contiene los vecinos
 * de v que tienen grado i (no se guardan las listas que sean vacias).
 * 
 * Cada NeighborDescriptor representa un vecino w de v que mantiene toda la informacion necesaria para
 * que sea eficiente eliminar v de N(w) cuando se tiene acceso a w en N(v).  En particular, se mantiene 
 * el nombre de cada w en N(v), la ubicacion de v en la lista de N(w) que lo contiene y la ubicacion de la lista
 * de N(w) que lo contiene.
 */
class NeighborDescriptor {
	/**
	 * Representa el numero de un vecino w.
	 */
	public Integer neighbor;
	
	/**
	 * Es un puntero directo a la posicion de v en la lista de N(w) que lo contiene.
	 */
	public ListIterator<NeighborDescriptor> self_pointer;
	
	/**
	 * Es un puntero directo a la lista de N(w) que contiene a v.
	 */
	public ListIterator<LinkedList<NeighborDescriptor>> list_pointer;
	
}
