package com.akb.dyn;

public class Stack<V> extends DataStructure<V> {

	public Stack (Dyncache<V> d) {
		super(d);
	}

	public void push (V value) {
		shift(1);
		d.items.put(0, value); 
	}
}
