/**
Universidad del Valle de Guatemala
Algoritmos y Estructura de Datos
Hoja de Trabajo 9
Natanael Girón (20029)
Ma. Isabel Solano (20504)
Clase SearchInterface
**/

public interface SearchInterface<K extends Comparable<K>, V> {	
	public void put(K llave,V valor);

	public boolean contains(K llave);

	public V get(K llave);
}