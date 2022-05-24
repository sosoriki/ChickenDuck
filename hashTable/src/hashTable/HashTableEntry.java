package hashTable;
import java.util.Map.Entry;

public class HashTableEntry<K, V> implements Entry<K, V> {
	
	private K key;
	private V value;
	private boolean isAvailable = false;
	
	public HashTableEntry(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public boolean isAvailable(){
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;	
	}

	
	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public V getValue() {
		return this.value;
	}

	@Override
	public V setValue(V value) {
		V returnValue = this.value;
		this.value = value;
		return returnValue;
	}
	
	@Override
	public int hashCode(){
		int hashCode = 5;
		return key.hashCode() * hashCode;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof HashTableEntry) {
			return this.key == ((HashTableEntry)o).key;
		}
		return false;
	}

}
