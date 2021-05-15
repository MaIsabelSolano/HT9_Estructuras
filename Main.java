/**
Universidad del Valle de Guatemala
Algoritmos y Estructura de Datos
Hoja de Trabajo 9
Natanael Girón (20029)
Ma. Isabel Solano (20504)
Clase Main
**/


import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Main {
  public static void main(String[] args) {
	  Factory factory = new Factory();
	  Scanner scan = new Scanner(System.in);
	
		
		//utiles
		private String Msgerror = ("Se ha producido un error, ingrese una opci\u00edn v\u00e1lida");

    // Archivo txt
    File file = null;
    ArrayList<Asociacion> cards = new ArrayList<Asociacion>();

    //Try-catch para errorer por posible falta de Archivo
    try{
      
      // Lectura de Archivo txt
      file = new File ("Spanish.txt");
      Scanner fileReader = new Scanner(file);

      while (fileReader.hasNextLine()){
        String line = fileReader.nextLine();
				String[] lineaSeparada = line.split(" ");
				ArrayList<String> definicionArray = new ArrayList<String>();
				String ENG = lineaSeparada[0];
				for (int i = 1; i<lineaSeparada.lengh; i++){
					//Se salta la primera palabra para que solo se guarde la definición y no la llave
					definicionArray.add(lineaSeparada[i]);
				}
				String ESP =  definicionArray.toString();
				//hala todo y el tipo de palabra que es (ej:verb)
				//la primera palabra es la def en ingles
				//la segunda palabra es la de en esp
				Asociacion temp = new Asociacion(ENG,ESP);
				cards.add(temp);
      }

      fileReader.close();

    }catch(FileNotFoundException exeption){

      System.out.println("No se ha encontrado el archivo.");
    } 

    //Si el archivo fue encontrado con exito
    if (file != null){
			//obtener la decision del usuario
			boolean verificador = true;
			int opcion = 0;
			while (verificador){
				try {
					System.out.println("Escriba el n\u00famero de la implementaci\u00edn que desee utilizar:\n\t1)Red Black Tree\n\t2)HashMap");

					opcion = scan.nextInt();

					if (opcion == 1||opcion == 2){
						//se puede avanzar
						verificador = false;
					}
					else {
						System.out.println(Msgerror);
					}
				} catch(InputMismatchException ime){
				System.out.println(Msgerror);
				}
			}
		
			//Se obtiene la implementacion
			mapa = factory.selectMap(opcion);

		}

  }
}