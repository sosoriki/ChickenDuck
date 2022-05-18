package stackAndQueue;

/**
 * 
 * queue class
 * first in, first out
 * @author Kendrick Pham
 *
 * @param <V>
 */

public class queue <V> {
	
	/**
	 * 
	 * variables of the
	 * class
	 * 
	 * @param maxSize
	 * @param counter
	 * @param array
	 */
	
	private int maxSize;
	private int counter = 0;
	private V[] array;
	
	/**
	 * 
	 * constructor of the
	 * queue that makes
	 * maxSize into the size 
	 * of the array that will 
	 * be used
	 * @param maxSize
	 */
	
	public queue(int maxSize) {
		this.maxSize = maxSize;
		array = (V[]) new Object[this.maxSize];
	}
	
	/**
	 * 
	 * methods of the queue
	 * adds value into the back
	 * of the queue.
	 * removes/poll value in
	 * front of the queue.
	 * @param value
	 */
	
	public void add (V value) {
		if(counter == 0) {
			array[0] = value;
			counter++;
		}
		else {
			if(counter == maxSize) {
				System.out.printf("Queue is full!\n");
			}
			else {
				int iterator = 0;
				while(iterator != counter) {
					iterator++;
				}
				array[iterator] = value;
				counter++;
			}
		}
	}
	
	public V poll() {
		if(array.length == 0) {
			System.out.printf("Queue is empty!\n");
			return null;
		}
		else {
			V element = array[0];
			int j = 0;
			for(int i = 0; i < counter-1; i++) {
				array[i] = array[i+1];
				j++;
			}
			array[j+1] = null;
			counter--;
			return element;
		}
	}
	
	public V remove() {
		if(array.length == 0) {
			System.out.printf("Queue is empty!\n");
			return null;
		}
		else {
			V element = array[0];
			for(int i = 0; i < counter-1; i++) {
				array[i] = array[i+1];
			}
			counter--;
			return element;
		}
	}
	
	public V peek() {
		return array[0];
	}
	
	public int getMaxSize() {
		return this.maxSize;
	}
	
	public int getCurrentSize() {
		return this.counter;
	}
	
	public boolean isEmpty() {
		if(counter == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(counter == maxSize) {
			return true;
		}
		return false;
	}

}
