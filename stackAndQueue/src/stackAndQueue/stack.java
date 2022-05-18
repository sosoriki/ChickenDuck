package stackAndQueue;

/**
 * 
 * stack class
 * last in, first out
 * @author Kendrick Pham
 *
 * @param <V>
 */

public class stack <V> {
	
	/**
	 * variables of the class
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
	 * the constructor of the
	 * stack which makes the
	 * maxSize into the size
	 * of the array that will 
	 * be used
	 * @param maxSize
	 */
	
	public stack(int maxSize) {
		this.maxSize = maxSize;
		array = (V[]) new Object[this.maxSize];
	}
	
	/**
	 * 
	 * methods of the stack
	 * push puts newest element
	 * in front.
	 * pop removes the element
	 * in front.
	 * @param element
	 */
	
	public void push (V element) {
		if(counter == 0) {
			array[0] = element;
			counter++;
		}
		else {
			if(counter == maxSize) {
				System.out.printf("Stack is full!\n");
			}
			else {
				for(int i = 0; i < counter; i++) {
					V temp = array[i];
					array[i+1] = temp;
					array[i] = element;
				}
				counter++;
			}
		}
	}
	
	public V pop() {
		if(array.length == 0) {
			System.out.printf("Stack is empty!\n");
			return null;
		}
		else {
			V element = array[0];
			for(int i = 0; i < counter; i++) {
				array[i] = array[i+1];
			}
			counter--;
			return element;
		}
	}
	
	public V peek() {
		return array[0];
	}
	
	public int currentSize() {
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
