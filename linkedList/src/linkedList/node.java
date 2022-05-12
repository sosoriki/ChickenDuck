package linkedList;

import linkedList.node;

/**
 * 
 * node class that creates 
 * the node and its data
 * with next and prev
 * @author Kendrick Pham
 *
 * @param <T>
 */

public class node <T> {
	public T data;
	public node<T> next;
	public node<T> prev;
	public node(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
