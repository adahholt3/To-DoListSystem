package todolist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Implementation of own ArrayList called MyArrayList - Creating a Data Structure

public class MyArrayList<T extends Comparable <T>> implements Iterable<T> {
	
	
	//attributes (backbone data structures)
	private T[]elements;		// number of spaces
	private int size = 0;	//number of actual elements
	private static final int DEFAULT_CAPACITY =10; //Static - shared between all objects	Final - the value is constant can't be changed

	@SuppressWarnings("unchecked")
	public MyArrayList() {
		elements =(T[]) new Comparable[DEFAULT_CAPACITY];	//type cast
	}
	
	private void doubleCapacity() {
		int newSize = elements.length*2;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	boolean add(T element) {
		if (size == elements.length) 
			doubleCapacity();
			
		elements[size++] = element;
		return true;
		
	}
	
	//printing the arraylist
	@Override
	public String toString() {
		
		if (size == 0)
			return "[]";
		
		String s = "[";
		
		for (int i=0; i<size; i++) {
			s+=elements[i];
			if(i<size-1)
			s+=",";
		}
		s+="]";
		return s;
		
	}
	//size method
	public int size() {
		return size;
		
	}
	//isEmpty method
	public boolean isEmpty() {
		return size ==0;
	}
	
	public void Checkindex (int index) {
		if (index < 0 || index >=size) 
			throw new IndexOutOfBoundsException("index : "+ index +" Size " + size);
		
	}
	

	//Set 
	public T set(int index,T element) {
		
		Checkindex(index);
		T oldValue = elements[index];
		elements[index] = element;
		return oldValue;
		
	}
	//get
	public T get(int index) {
		Checkindex(index);
		return elements[index];
	}
	
	private int indexOf(T element) {
		if (element == null) {
		for (int i = 0; i < size; i++) {
			if(elements[i] == null)
				return i;
		}
	}
		else {
			for (int i = 0; i < size; i++) {
			if (element.equals(elements[i]))
				return i;
			
			  }
		}
		return -1;
	}
	
	
	//remove
	public boolean remove(T element) {
		int index = indexOf(element);
		
		if (index == -1) {
			return false;
		}
		
		for (int i = index; i < size-1; i++) {
			elements[i] = elements [i+1];
			
		elements[size-1] = null;
		size--;
		return true;
		}
		return false;

	} 
	
	public boolean contains(T element) {
		return indexOf(element) >= 0;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new MyIterator();
		
	}
	
	private class MyIterator implements Iterator<T> {	//Nested Class -- if u don't want the user to know

		private int cursor = 0;
		
		@Override
		public boolean hasNext() {
			
			return cursor < size;
		}

		@Override
		public T next() {
			if (!hasNext())
			throw new NoSuchElementException();
		return elements[cursor++];
		}

	}
		
}

