/**
Universidad del Valle de Guatemala
Algoritmos y Estructura de Datos
Hoja de Trabajo 9
Natanael Girón (20029)
Ma. Isabel Solano (20504)
Clase Factory
**/


public class Factory {

	public SearchInterface<String,String> elegir(int i){
		switch(i){
			case 2:{
				return new HashMap<>();
			}
			case 1:{
				return new SplayTree<>();
			}
			default:{
				return null;
			}
		}
	}
}