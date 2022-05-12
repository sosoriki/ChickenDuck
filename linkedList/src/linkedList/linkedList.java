package linkedList;

import java.util.Iterator;

/**
 * 
 * doubly linked list class
 * most methods taken from 
 * previous projects
 * other methods added
 * from assignment instructions
 * @author Kendrick Pham
 *
 * @param <T>
 */

public class linkedList<T> implements list<T>{
	
	private node<T> head;
	private node<T> tail;
	private int size;
	
	/**
	 * 
	 * class methods of add,
	 * remove, clear, contains,
	 * etc.
	 * 
	 * @param item
	 * @param index
	 */
	
	public void add(T item) {							//the addFirst method, if no index is given, the item is added first
		node<T> temp = new node<T>(item);
		temp.next = head;
		temp.prev = null;
		if(head != null) {
			head.prev = temp;
		}
		head = temp;
		if(tail == null) {
			tail = temp;
		}
		size++;
	}
	
	public void add(T item, int index) {				//adds at the index provided
		node<T> temp = new node<T>(item);
		if(head == null) {
			head = temp;
			tail = temp;
		}
		else if(index == 0) {
			temp.next = head;
			head.prev = temp;
			head = temp;
		}
		else if(index == size) {
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
		}
		else{
			node<T> ref = head;
			for(int i = 1; i < index; i++) {
				ref = ref.next;
			}
			temp.next = ref.next;
			ref.next = temp;
			temp.prev = ref;
			temp.next.prev = temp;
		}
		size++;
	}
	
	public void addLast(T item) {								//adding to the end of the list
		node<T> temp = new node<T>(item);
		temp.next = tail;
		temp.prev = tail;
		tail.next = temp;
		tail = tail.next;
		size++;
	}
	
	public T remove(Object item) {
		if(head != null) {
			if(head.next == null) {
				head = null;
				tail = null;
			}
			else {
				head.next.prev = null;
				head = head.next;
			}
		}
		size--;
		return null;
	}
	
	public T remove(int index) {								//remooving given index
		if(head == null) {
			return null;
		}
		else {
			node<T> temp = head;								//loops through until we get to index
			for(int i = 1; i < index; i++) {
				temp = temp.next;
			}
			if(temp == head) {
				head = temp.next;
			}
			else if(temp == tail) {
				tail = tail.prev;
			}
			else {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
			}
		}
		size--;
		return null;
	}
	
	public T removeFirst() {									//removes first node of list
		node<T> temp = head;
		if(head == null) {										//basically if list is empty
			return null;
		}
		else {													//removes head and assigns new head
			head = head.next;
			if(head != null) {
				head.prev = null;
			}
		}
		size--;
		return null;
	}
	
	public T removeLast() {										//removes last node of list
		node<T> temp = tail;
		if(head != null) {										//if head has a node and is the only element, head becomes null
			if(head.next == null) {
				head = null;
			}
		}
		else {													//working through to delete last element
			tail.prev.next = null;
		}
		tail = tail.prev;
		temp.prev = null;
		size--;
		return null;
	}
	
	public T get(int index) {									//iterates through list until we get to index to return value at index
		int count = 0;
		node<T> iterator = head;								//iterator that starts at head
		while(iterator != null) {
			if(count == index) {								//iterates until count = index
				return iterator.data;
			}
			count++;
			iterator = iterator.next;
		}
		return null;
	}
	
	public T getFirst() {										//returns head which is the first element
		return head.data;
	}
	
	public T getLast() {										//returns the tail which is the last element
		return tail.data;
	}

	public void clear() {										//clears list
		node<T> temp;
		while(head != null) {
			temp = head;
			head = head.next;
			temp = null;
		}
		size = 0;
	}

	public boolean contains(Object item) {						//iterates through list to find if item exists
		node<T> iterator = head;
		while(iterator != tail) {								//iteration ends if iterator is equal to the tail
			if(iterator.data == item) {							//iterating and checking the iterator's data if it equals item
				return true;
			}
			iterator = iterator.next;
		}
		return false;
	}
	
	public int indexOf(Object item) {							//looking for index of a certain item, returns -99999 if not found
		node<T> iterator = head;								//iterator for method starts at head
		int indexCount = 0;
		while(iterator != null) {								//iterates through while incrementing indexCount until item is found
			if(iterator == item) {
				return indexCount;
			}
			indexCount++;
		}
		return -99999;
	}

	public boolean isEmpty() {									//returns empty if no head
		return head == null;
	}

	public int size() {											//returns size we been incrementing or decrementing
		return this.size;
	}

	public Iterator<T> iterator() {								//i don't know what to do with this
		return null;
	}

}
