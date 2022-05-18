package stackAndQueue;

public class stack <V> {
	
	private int maxSize;
	private int counter = 0;
	private V[] array;
	
	public stack(int maxSize) {
		this.maxSize = maxSize;
		array = (V[]) new Object[this.maxSize];
	}
	
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
