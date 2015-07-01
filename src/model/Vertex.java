package model;

import java.util.ListIterator;

public class Vertex {
	private Integer id;
	private ListIterator<VertexDescriptor> vertex_pointer;
	
	Vertex(Integer id, ListIterator<VertexDescriptor> pointer) {
		this.id = id;
		vertex_pointer = pointer;
	}
	
	public Integer getId() {
		return id;
	}

	ListIterator<VertexDescriptor> getPointer() {
		return vertex_pointer;
	}
	
	void setPointer(ListIterator<VertexDescriptor> pointer) {
		vertex_pointer = pointer;
	}
	
	VertexDescriptor getDescriptor() {
		VertexDescriptor res = vertex_pointer.next();
		vertex_pointer.previous();
		return res;
	}
}
