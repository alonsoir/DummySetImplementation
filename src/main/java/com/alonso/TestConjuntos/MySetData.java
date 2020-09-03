package com.alonso.TestConjuntos;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MySetData<E> extends AbstractSet<E> implements Set<E>,Cloneable, java.io.Serializable {

	private static final long serialVersionUID = 4546602283055667750L;
	// en caso de que serialicemos el objeto que contiene esa variable transient, su valor no se serializará.
	// es decir, en caso de que querramos guardar a disco el contenido de este objeto, cuando querramos recuperarlo,
	// esos datos no estarán.
	private transient Map<E,Object> myMap;
	private Object DUMMYOBJECT = new Object();
	
	public MySetData() {
		myMap = new HashMap<E, Object>();
	}
	
	public boolean add(E someObject) {
		return myMap.put(someObject, DUMMYOBJECT) == null;
	}
	
	public E get(E someObject) {
		return myMap.get(someObject) == DUMMYOBJECT ? someObject : null;
		
	}
	public boolean isEmpty() {
		return myMap.size() == 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return ((Iterator<E>) myMap.entrySet().iterator());
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return myMap.entrySet().size();
	}

	public void sorted() {
				
		myMap.entrySet().stream().forEachOrdered(System.out::println);
	}
	
	public void unsorted() {
		myMap.entrySet().stream().forEach(System.out::println);
	}

	public boolean drop(Object someObject) {
		return myMap.remove(someObject, DUMMYOBJECT);
	}
}
