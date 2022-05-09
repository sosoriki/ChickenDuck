package arrayList;

/**
 * 
 * Arraylist class that creates
 * the methods for an arraylist
 * @author Kendrick Pham
 *
 */

public class arrayList <T> implements list <T>{
	
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private int capacity;
	private int size = 0;
	private T[] array;
	
	/**
	 * 
	 * Constructors
	 * @param initialCapacity
	 * 
	 */
	
	public arrayList() {
		this.capacity = DEFAULT_INITIAL_CAPACITY;
		this.size = 0;
		array = (T[]) new Object[this.capacity];
	}
	
	public arrayList(int initialCapacity) {
		this.capacity = initialCapacity;
		this.size = 0;
		array = (T[]) new Object[this.capacity];
	}
	
	/**
	 * 
	 * Methods include add,
	 * clear, contains, get,
	 * indexOf, isEmpty, and size
	 * @param item
	 * @param index
	 */

	public void add(T item, int index) {
		if(index < 0 || index > size) {										//checks if there is a valid index
			System.out.printf("Invalid index\n");
			return;
		}
		else if(index == size) {											//adds at index
			this.add(item, index);
		}
		else {
			if(this.size == this.capacity) {								//check if there is space to put it in and if not, makes an arraylist doubled in size
				this.capacity*=2;
				T[] temp = (T[]) new Object [this.capacity];
				for(int i = 0; i < array.length; i++) {
					temp[i] = array[i];
				}
				array = temp;
			}
			for(int i = size; i > index; i--) {
				array[i] = array [i-1];
			}
			array[index] = item;
			size++;															//updates size
		}
		
	}

	public void clear() {
		for(int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;															//sets size back to zero because cleared array
		
	}

	public boolean contains(Object item) {
		for(int i = 0; i < size; i++) {
			Object check = array[i];
			if(item == check) {
				return true;												//returns true if the array contains the object
			}
		}
		return false;
	}

	public T get(int index) {
		if(index < 0 || index > size) {										//checking if index exists
			return null;
		}
		return array[index];
	}
	
	public int indexOf(Object item) {
		if(item == null) {															//used so we can use else statement
			for(int i = 0; i < size; i++) {
				if(array[i] == null) {
					return i;
				}
			}
		}
		else {																		//checks if value exists in array and we print out the index
			for(int i = 0; i < size; i++) {
				if(array[i] == item) {												
					System.out.printf("Value %d is in index %d\n", item, i);
					return i;
				}
			}
		}
		System.out.printf("Value %d does not exist in array list\n", item);
		return -1;
	}

	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		return this.size;
	}
	

}
