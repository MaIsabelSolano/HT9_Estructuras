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
		String Msgerror = ("Se ha producido un error, ingrese una opci\u00edn v\u00e1lida");

		//pedirle al usuario la implementacion de desea utilizar
		SearchInterface SI;
		boolean verificador = true;
		int opcion = 0;
		while (verificador){
			try{
				System.out.println("\nEscriba el n\u00famero de la implementaci\u00edn que desee utilizar:\n\t1)SplayTree\n\t2)HashMap\n");

				//eleccion del usuario
				opcion = scan.nextInt();

				if (opcion == 1||opcion == 2){
					//puede salir del loop
					verificador = false;
				}
				else {
					System.out.print(Msgerror);
					//repite el loop
				}
			}
			catch(InputMismatchException ime){
				System.out.print(Msgerror);
				scan.nextLine(); 
			}
		}

		if (opcion == 1){
			//Se utiliza el SplayTree
		}

		else if (opcion == 2){
			//se utiliza el HashMap
		}

	}


	/**
	* @param
	* @return 
	* @throws FileNotFoundException
	*/
	public static String obtencionTexto() throws FileNotFoundException{
		String expresion = "";
		ArrayList<String> temp = new ArrayList<>();
		File origen = new File("Texto.txt");
		Scanner lector = new Scanner(origen);
		while(lector.hasNextLine()){
			temp.add(lector.nextLine());
			temp.add(" ");
		}
		expresion = temp.toString();
		return expresion;
	}
	
	public static void LeerArchivoHM()throws FileNotFoundException{
		//leer el archivo para la implementacion HashMap
    File file = null;
    ArrayList <String> palabras = new ArrayList<String>();   
    try {
      file = new File ("Spanish.txt");
      Scanner fileReader = new Scanner(file);

      while (fileReader.hasnextLine()){
        
        String line = fileReader.nextLine();
        palabras.add(line);
      }

      fileReader.close();
    } catch(FileNotFoundException exception){
      
      System.out.println("No se ha encontrado el archivo.");
    }
	}

	public static void LeerArchivoST()throws FileNotFoundException{
		//leer el archivo para la implementacion Splay Tree
    try {
      FileReader lector = new FileReader("Spanish.txt");
      BufferedReader buff = new BufferedReader(lector);
      while ((linea = buff.readLine()) != null){
        //Se eliminan tabulaciones y caracteres extras
          linea = linea.replaceAll(";","");
          linea = linea.replaceAll(",","");
          linea = linea.replaceAll("\t", " ");
          String [] significados = linea.split(" ");
          String ingles = significados[0];
          String espa = significados[1];
          arbol.put(ingles,espa);
      }
      buff.close();
    }catch (IOException ex){ 
      System.out.println("No se ha encontrado el archivo.");
    }
	}

	public static void Traducir(String expresion, SearchInterface SI){
    String linea = "";
		
   
  }
}
