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
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.NullPointerException;
import java.util.*;

class Main {
  public static void main(String[] args) throws FileNotFoundException{
	  Factory factory = new Factory();
	  Scanner scan = new Scanner(System.in);
	
		//utiles
		String Msgerror = ("Se ha producido un error, ingrese una opci\u00edn v\u00e1lida");

		//pedirle al usuario la implementacion de desea utilizar
		SearchInterface<String,String> SI;
		boolean verificador = true;
		int opcion = 0;
		while (verificador){
			try{
				System.out.println("\nEscriba el n\u00famero de la implementaci\u00edn que desee utilizar:\n\t1)SplayTree\n\t2)HashMap\n");

				//eleccion del usuario
				opcion = scan.nextInt();

				if (opcion == 1||opcion == 2){
					//puede salir continuar
					SI = factory.elegir(opcion);

					LeerArchivoHM(SI);
					//obtener el Texto
					String expresion = obtencionTexto();

					//frase original
					System.out.println("Frase original\n"+expresion);

					//traducir con la implementacion escogida por el usuario
					Traducir(expresion, SI);
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
	}


	/**
	* 
	* @throws FileNotFoundException
	*/
	public static String obtencionTexto() throws FileNotFoundException{
		String expresion = "";
		ArrayList<String> temp = new ArrayList<>();
		File origen = new File("Texto.txt");
		Scanner lector = new Scanner(origen);
		while(lector.hasNextLine()){
			temp.add(lector.nextLine());
			//temp.add(" ");
		}
		expresion = temp.toString();
		return expresion;
	}

	/**
	* Se encarga de leer el archivo de Spanish.txt y almacenar su informacón en un SplayTree
	*
	*/
	public static void LeerArchivoHM(SearchInterface<String,String> temp)throws FileNotFoundException{
		//leer el archivo para la implementacion HashMap
    File file = null;
    //SearchInterface<String,String> temp;
		//ArrayList <String> palabras = new ArrayList<String>();   
    try {
      file = new File ("Spanish.txt");
      Scanner fileReader = new Scanner(file);

      while (fileReader.hasNextLine()){
        /*
        String line = fileReader.nextLine();
        palabras.add(line);
				*/
		String linea = fileReader.nextLine();
		String [] lineaTemp = linea.split("	");
		String llave = lineaTemp[0];
		lineaTemp[0]="";
		StringBuilder sb = new StringBuilder();
		for (String s:lineaTemp){
			if (s.equals("")){
				//ignorar
			}
			else {
				sb.append(s);
				sb.append(" ");
			}

		}
		String valor = sb.toString();
		temp.put(llave,valor);
				
      }
		
      fileReader.close();
			//return temp;


    } catch(FileNotFoundException exception){
      
      System.out.println("No se ha encontrado el archivo.");
    }
	}


	/**
	* Se encarga de leer el archivo de Spanish.txt y almacenar su informacón en un SplayTree
	*
	*/
	public static void LeerArchivoST()throws FileNotFoundException{
		//leer el archivo para la implementacion Splay Tree
    try {
      String linea = "";
      FileReader lector = new FileReader("Spanish.txt");
      BufferedReader buff = new BufferedReader(lector);
      while ((linea = buff.readLine()) != null){
        //Se eliminan tabulaciones y caracteres extras
          linea = linea.replaceAll(";","");
          linea = linea.replaceAll(",","");  
          
          
      }
      buff.close();
    }catch (IOException ex){ 
      System.out.println("No se ha encontrado el archivo.");
    }
	}


	/**
	*Realiza la traduccion
	*@param expresion Frase a traducir
	*@param SI interfaz con la implementaicon a utilizar
	*
	*/
	public static void Traducir(String expresion, SearchInterface SI) throws NullPointerException{
		String[] fraseST = expresion.split(" "); //frase Sin Traducir
		ArrayList<String> frase = new ArrayList<>();
		/*
		for (String s:fraseST){
			frase.add(s); //añadir al array
		}
		*/
		//remplazar y traducir
		for (int i = 0; i < fraseST.length; i++){
			String llave = fraseST[i].toLowerCase();
			if (SI.contains(llave)){
				//si lo contine se traduce
				String traduccion = SI.get(llave).toString().toLowerCase();
				frase.add(traduccion); 
				//System.out.println(i);
			}
			else {
				//se agrega sin traducir
				String sintraducir = "*"+llave+"*";
				frase.add(sintraducir);
				//System.out.println(i);
			}
		}

		//reconstruir la frase
		StringBuilder sb = new StringBuilder();
		for (String s: frase){
			sb.append(s);
			sb.append(" ");
		}

		//Impresion final
		System.out.println("\nResultado traducido");
		System.out.println(sb.toString());	
  }
}

