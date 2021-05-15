/**
Universidad del Valle de Guatemala
Algoritmos y Estructura de Datos
Hoja de Trabajo 9
Natanael Girón (20029)
Ma. Isabel Solano (20504)
Clase Factory
**/

public class HashMap{
	
  public void put(K key, V value) {
    
  }

  public boolean containsKey(K key) {
    boolean result = keys.contains(key);
    return result;
  }

  public V get(K key) {

    int index = -1;

    // Búsqueda del indice de la llave.
    for (int i = 0; i < keys.size(); i++) {
        if (keys.get(i).equals(key)) {
            index = i;
        }
    }

    // Retorno del valor agregado.
    if (index != -1) {
        V value = values.get(index);
        return value;
    }

    return null;
  }
}