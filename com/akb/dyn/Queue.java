package com.akb.dyn;

public class Queue<V> extends DataStructure<V>{
	
	public Queue (Dyncache<V> d) {
		super(d);
	}

	public void push (V value) {
		d.items.put(d.items.size(), value); 
	}
}