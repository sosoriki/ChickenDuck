package linkedList;

/**
 * 
 * collection interfacce
 * @author Kendrick Pham
 *
 * @param <T>
 */

public interface collection<T> extends Iterable<T> {
	public void add(T item);
	public void clear();
	public boolean contains(Object item);
	public boolean isEmpty();
	public T remove(Object item);
	public int size();

}
