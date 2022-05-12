package linkedList;

/**
 * 
 * list interface that extends
 * collection
 * @author Kendrick Pham
 *
 * @param <T>
 */

public interface list<T> extends collection<T> {
	public void add(T item, int index);
	public T get(int index);
	public int indexOf(Object item);
	public T remove(int index);

}
