package linkedList;

import linkedList.node;

public class node <T> {
	public T data;				//data
	public node<T> next;		//link
	public node<T> prev;		//link backwards
	public node(T data) {		//constructor
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
