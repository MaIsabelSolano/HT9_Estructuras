
/**
Universidad del Valle de Guatemala
Algoritmos y Estructura de Datos
Hoja de Trabajo 9
Natanael Girón (20029)
Ma. Isabel Solano (20504)
Clase HashMap
**/

import java.util.ArrayList;

public class HashMap<Key extends Comparable<Key>, Value> implements SearchInterface<Key, Value> {

	private ArrayList<Key> keys = new ArrayList<Key>();
	private ArrayList<Value> values = new ArrayList<Value>();

	@Override
	public void put(Key key, Value value) {
		keys.add(key);
		values.add(value);
	}

	@Override
	public boolean contains(Key key) {
		boolean result = keys.contains(key);
		return result;
	}

	@Override
	public Value get(Key key) {
		int index = -1;

		// Búsqueda del indice de la llave.
		for (int i = 0; i < keys.size(); i++) {
			if (keys.get(i).equals(key)) {
				index = i;
			}
		}

		// Retorno del valor agregado.
		if (index != -1) {
			Value value = values.get(index);
			return value;
		}

		return null;
	}

	public ArrayList<Key> getKeys() {
		return keys;
	}

  public int size() {
    return keys.size();
  }


	public Value remove(Key key) {
		int index = -1;

		// Búsqueda del indice de la llave.
		for (int i = 0; i < keys.size(); i++) {
			if (keys.get(i).equals(key)) {
				index = i;
				keys.remove(i);
			}
		}

		// Retorno del valor removido.
		if (index != -1) {
			Value value = values.remove(index);
			return value;
		}

		return null;
	}

}