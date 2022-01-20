package co.edu.icesi.dev.sat.alert.endpoint.simulator.model;

/**
 * 
 * @author Victor Mora
 *	Pair class for the simulated endpoint model 
 * @param <K> the type of keys maintained by this Pair
 * @param <V> the type of paired values
 */
public class PairV<K,V> {

	private K key;
	
	private V value;
	
	public PairV(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
}
