package model;

import java.util.LinkedList;

class VertexDescriptor {

//	public LinkedList<Integer> vecinos = new LinkedList<Integer>();
//	public Vector<ListIterator<Integer>> vectorIterador = new Vector(20);
	
	public Integer degree = 0;
	public LinkedList<NeighborDescriptor> highNeighborhood = new LinkedList<NeighborDescriptor>();
	public LinkedList<LinkedList<NeighborDescriptor>> lowNeighborhood = new LinkedList<LinkedList<NeighborDescriptor>>();
			
}


