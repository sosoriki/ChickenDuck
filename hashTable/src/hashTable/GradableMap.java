package hashTable;
import java.util.Map;

public interface GradableMap <K, V> extends Map<K, V>{
	
	public HashTableEntry<K,V>[] getArray();
	public void setArray(HashTableEntry<K,V>[] array);
	public void setSize(int size);

}
