package com.akb.dyn;

import java.util.HashMap;

public abstract class DataStructure<V> {
	
	protected Dyncache<V> d;
	protected HashMap<Integer, V> items;

	public DataStructure (Dyncache<V> d) {
		this.d = d;
	}

	public abstract void push (V value);

	public V pop () {
		V val = d.items.get(0);
		shift(-1);
		return val;
	}

	public int getLength() {
		return d.items.size();
	}

	protected void shift (int offset) {
		if (offset == 0) return;
		else if (offset <= -1) {
			for (int i = offset*-1; i < d.size(); i++)
				d.items.put(i+offset, d.items.get(i));

			for (int i = d.size()-1; offset != 0; offset++, i--)
				d.items.remove(i);
		} else {
			for (int i = d.size()-1; i >= 0; i--)
				d.items.put(i+offset, d.items.get(i));
			for (; offset>0; offset--)
				d.items.remove(offset-1);
		}
	}
}
