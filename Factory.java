/**
Universidad del Valle de Guatemala
Algoritmos y Estructura de Datos
Hoja de Trabajo 9
Natanael Girón (20029)
Ma. Isabel Solano (20504)
Clase Factory
**/

import java.util.HashMap;

public class Factory{
	public SearchInterface<K,V> elegir(int i){
		switch(i){
			case 1:{
				return new HashMap<K,V>();
			}
			case 2:{
				return new SplayTree<K,V>();
			}
			default:{
				return null;
			}
		}
	}
}