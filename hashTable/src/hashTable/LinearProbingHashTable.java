package hashTable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashTable<K, V> implements GradableMap<K, V> {
	
	private Object[] entries;
	private double loadFactor;
	private int size;
	
	public LinearProbingHashTable(){
		this.size = 11;
		this.loadFactor = 0.75;
		entries = new Object[11];
	}
	
	public LinearProbingHashTable(int size){
		this.size = size;
		this.loadFactor = 0.75;
		entries = new Object[size];
	}

	public LinearProbingHashTable(int size, double loadFactor){
		this.size = size;
		this.loadFactor = loadFactor;
		entries = new Object[size];
	}
	
	@Override
	public void clear() {
		Arrays.fill(entries, null);
		this.size = 0;
		entries = new Object[this.size];
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		if(this.size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashTableEntry<K, V>[] getArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSize(int size) {
		this.size = size;
		
	}

}
