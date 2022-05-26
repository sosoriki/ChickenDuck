package hashTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashTable<K, V> implements GradableMap<K, V> {
	
	private HashTableEntry[] entries;
	private double loadFactor;
	private int size;
	
	public LinearProbingHashTable(){
		this.size = 11;
		this.loadFactor = 0.75;
		entries = new HashTableEntry[11];
	}
	
	public LinearProbingHashTable(int size){
		this.size = size;
		this.loadFactor = 0.75;
		entries = new HashTableEntry[size];
	}

	public LinearProbingHashTable(int size, double loadFactor){
		this.size = size;
		this.loadFactor = loadFactor;
		entries = new HashTableEntry[size];
	}
	
	@Override
	public void clear() {
		Arrays.fill(entries, null);
		this.size = 0;
		entries = new HashTableEntry[this.size];
	}

	@Override
	public boolean containsKey(Object arg0) {
		int iterator = 0;
		while(iterator < entries.length){
			if (entries[iterator].getKey() == ((HashTableEntry) arg0)) {
				return true;
			}
			iterator++;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		int iterator = 0;
		while(iterator < entries.length){
			if (entries[iterator].getValue() == ((HashTableEntry) arg0)) {
				return true;
			}
			iterator++;
		}
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
		Set<K> set = new HashSet<K>();
		for(int i = 0; i < entries.length; i++) {
			set.add((K) entries[i].getKey());
		}
		return set;
	}

	@Override
	public V put(K key, V value) {
		if(key == null) throw new IllegalArgumentException("NullPointerException");
		if(value == null) {
			System.out.printf("Value was null!\n");
			return null;
		}
		HashTableEntry entry = new HashTableEntry(key, value);
		if((int)key > this.size) {
			int index = (int)key % size;
			for(int i = 0; i < entries.length; i++) {
				if(i == index) {
					if(entries[i] != null) {
						index++;
					}
					else if((String)entries[i].getValue() == "-") {
						entries[i] = entry;
					}
					else {
						entries[i] = entry;
					}
				}
			}
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		otherMap.forEach((K,V) -> put(K,V));
		
	}

	@Override
	public V remove(Object key) {
		if((int)key > size) {
			int index = (int)key % size;
			entries[index].setValue("-");
		}
		else {
			entries[(int)key].setValue("-");
		}
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Collection<V> values() {
		Collection<V> collection = new ArrayList<V>();
		for(int i = 0; i < entries.length; i++) {
			collection.add((V) entries[i].getValue());
		}
		return collection;
	}

	@Override
	public HashTableEntry<K, V>[] getArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		this.entries = array;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

}
