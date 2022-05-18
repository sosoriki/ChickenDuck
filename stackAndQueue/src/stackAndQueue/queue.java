package stackAndQueue;

public class queue <V> {
	
	private int maxSize;
	private int counter = 0;
	private V[] array;
	
	public queue(int maxSize) {
		this.maxSize = maxSize;
		array = (V[]) new Object[this.maxSize];
	}
	
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
