package com.akb.dyn;

import java.util.HashMap;

public class Dyncache<V> {

	HashMap<Integer, V> items;
	private Mode OPMODE = null;
	private Stack<V> stack;
	private Queue<V> queue;

	enum Mode {
		STACK, Q
	}

	public Dyncache (Mode OPMODE) {
		this.OPMODE = OPMODE;
		this.items = new HashMap<Integer, V>();
		stack = new Stack<V>(this);
		queue = new Queue<V>(this);
	}

	public void push (V val) {
		if (OPMODE == Mode.STACK) stack.push(val);
		else queue.push(val);
	}

	public V pop () {
		return stack.pop(); // pop is eq in queue && stack
	}

	void setItems (HashMap<Integer, V> items) {
		this.items = items;
	}

	int size() {
		return items.size();
	}

	public Mode getMode () {
		return OPMODE;
	}

	public void setMode (Mode OPMODE) {
		this.OPMODE = OPMODE;
	}

	public String popAll() {
		String list = "[ "+items.get(0);
		for (int k=1; k<size(); k++)
			list += ", " + items.get(k);
		list += "]";
		//items.clear();
		return list; 
	}
}