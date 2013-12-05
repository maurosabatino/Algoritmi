package sabatino.esercizio13.searchTree;

public class Elem<K extends Comparable<K>,E extends ObjectWhitKey<K>>implements ObjectWhitKey<K>{
	E elem;
	K key;
	
	public Elem(E elem){
		this.elem=elem;
		this.key=elem.key();
	}
	@Override
	public K key() {
		return key=elem.key();
	}
	public String toString() {
    return key + " " + elem;
  }
}
