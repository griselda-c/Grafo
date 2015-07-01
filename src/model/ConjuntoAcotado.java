package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

public class ConjuntoAcotado {
	
	private LinkedList<Integer> elems = new LinkedList<Integer>();
	private Vector<ListIterator<Integer>> index = new Vector<ListIterator<Integer>>();
	
	public ConjuntoAcotado() {}
	
	public ConjuntoAcotado(Integer cota) {
		for(Integer i = 0; i < cota; ++i) {
	        index.add(elems.listIterator()); //elems.end()
	    }
	}
	
	public Boolean pertenece(Integer elem) {
		return index.elementAt(elem).hasNext();
	}
	
	public void agregar(Integer elem) {
		elems.addFirst(elem);
		index.setElementAt(elems.listIterator(), elem);
	}
	
	public void eliminar(Integer elem) {
		//elems.remove(index.elementAt(elem).next());
		ListIterator<Integer>iter = index.elementAt(elem);
		iter.next();
		iter.remove();
		index.setElementAt(elems.listIterator(elems.size()), elem); //elems.end()
	}
	
	public Boolean empty() {
		return elems.isEmpty();
	}
	
	
	public Integer size() {
		return elems.size();
	}
	
	public LinkedList<Integer> getElements(){
		return this.elems;
	}
	
	IteratorConjAcotado iterator(){
		IteratorConjAcotado iter = new IteratorConjAcotado(elems.listIterator());
		return iter;
	}
	
	static class IteratorConjAcotado implements Iterator<Integer> {
		
		ListIterator<Integer> conj;
			
			IteratorConjAcotado(ListIterator<Integer> list) {
				conj = list;
			}

			@Override
			public boolean hasNext() {
				return conj.hasNext();
			}

			@Override
			public Integer next() {
				return conj.next();
			}

			@Override
			public void remove() {
				conj.remove();
			}


		}
	
}
