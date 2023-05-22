import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.*;
//import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthSpinnerUI;
import java.io.FileWriter;

public class Gramatica {
	static FileWriter fw;
	
	public static void main(String[] args) throws Exception {
		//Su codigo aqui
		if (args.length == 0) {
			System.out.println("Formato invalido");
		} else if (args[1].equals("-afd")) {
		String path = args[0]; //./tests/gramaticas/pares.gld 
		System.out.println(path);
			
		try {
			String nombre = path.replaceAll(".gld", "");
			nombre = nombre.replace(".", "");
			nombre = nombre.replace("tests", "");
			nombre = nombre.replace("/gramaticas", "");
			nombre = nombre.replace("/", "");
			String newPath = "./afn/" + nombre + ".afn";
			File afdFile = new File(newPath);
			if (!afdFile.exists()) {
			  afdFile.createNewFile();
			}
			fw = new FileWriter(afdFile);
			File file = new File(path);
		  	try {
			Scanner scanner = new Scanner(file);
			String[] Vari = scanner.nextLine().split(",");
			ArrayList<String> Variables = new ArrayList<String>();
			for (int j = 0; j < Vari.length; j++) {
				Variables.add(Vari[j]);
			}
			System.out.println("Variables: " + Variables);
			String[] lenguaje = scanner.nextLine().split(",");
			ArrayList<String> listado = new ArrayList<String>();
			for (int j = 0; j < lenguaje.length; j++) {
				listado.add(lenguaje[j]);
			}
			System.out.println("Lenguaje: " + listado);
			String listado2 = (String)String.join(",", listado);
			fw.write(listado2);
			String VariIni = scanner.nextLine();
			fw.close();

			
			
			/*BufferedReader reader = new BufferedReader(new FileReader(file));
			reader.readLine();
			System.out.println(reader.toString());
			reader.close();*/
			int numTransiciones = 1;
			List[][] transicionesAFN = new List[listado.size()][numTransiciones];
			for(int cont = 0; cont < listado.size(); cont++) {
				for(int c = 0; c < numTransiciones; c++) {
					System.out.println();
					System.out.printf("AFN: " + transicionesAFN[cont][c]);
				}
			}
			while(scanner.hasNextLine()) {
        		String[] linea = scanner.nextLine().split("->");
				ArrayList<String> trans = new ArrayList<String>();
				ArrayList<String> variableIni = new ArrayList<String>();
				ArrayList<String> variableFin = new ArrayList<String>();
				ArrayList<String> tranS = new ArrayList<String>();
        		for (int k = 0; k < linea.length ; k++ ){
					trans.add(linea[k]);
				}
				String transicion = trans.get(1).toString();
				String transicion2 = trans.get(0).toString();
				System.out.println("Transicion: " + transicion);
				variableIni.add(transicion2.substring(0, 1));
				System.out.println("variableIni: " + variableIni);
				for (int h = 0; h < transicion.length(); h ++) {
					if (listado.contains(transicion.substring(h,h+1))) {
						tranS.add(transicion.substring(h,h+1));
					} else {
						variableFin.add(transicion.substring(h,h+1));
					}
				}
				if (variableFin.isEmpty()) {
					int posvf = Variables.size() + 1;
					Variables.add(Integer.toString(posvf));
					variableFin.add(Integer.toString(posvf));
					System.out.println("Posicion variable final: " + posvf);
				}
				System.out.println("tranS: " + tranS);
				System.out.println("variableFin: " + variableFin);
				
				if( tranS.isEmpty()) { //   aaabbbccc 
					for(int i=0; i < Variables.size() ; i++){
						 //[A,B] Lista
						 //[A] Posicion de A en Lista
						 /*System.out.println("Aqui antes de la posicion");
						 System.out.println("Comparración: " + Variables.get(i).equals(variableIni));
						 System.out.println("Variable i: " + Variables.get(i));
						 System.out.println("Variable Inicial: " + variableIni); */
						 
						if (Variables.get(i).equals(variableIni.get(0))){
							int posicionVarIni = i + 1;
							System.out.println("Aqui con la posicion Inicial: " + posicionVarIni);
						}	
						if (Variables.get(i).equals(variableFin.get(0))){
							int posicionVarFin = i + 1;
							System.out.println("Aqui con la posicion Final: " + posicionVarFin);
						}
						
						//[[0,1],[0,]]

						//TrancisionesAFN[i + 1][posicionVArIni] <--- posicionVarFin
						//TrancisionesAFN[i + 1](Tamaño del Lenguaje)[posicionVArIni](Tamaño de las Variables) <--- posicionVarFin
					}
				} if( tranS.size() == 1){
					if( variableFin.isEmpty()){
						/*Estado Final = Nuevo estado */
						/*[Numero de la variable][Numero de Estado Actual] <--- Ingresamos el estado al que hace transicion*/ 
					} 
				} if( Variables.size() > 1){
						for(int i=0; i > tranS.size() ; i++){
						/*letras[i] = numero de la variable*/
						/*[Numero de la variable][Numero de Estado Actual] <--- Posicion de estado Final + 1*/
						/*Numero de Estado Actual = Posicion de Estado Final +1*/
					} if( variableFin.isEmpty()){
						/*Estado Final = Nuevo estado */
						/*[Numero de la variable][Numero de Estado Actual] <--- Ingresamos el estado al que hace transicion*/ 
					} /*if else(){
						/*[Numero de la variable][Numero de Estado Actual] <--- Posicion de estado Final + 1
					}*/
				}

			}
			scanner.close();
		 	} catch (FileNotFoundException s) {
				System.out.println("El archivo no existe");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("El archivo no existe");
  		} 
		/*String esperado = args[2]; // pares.txt
		System.out.println(esperado);
		String pathEsperados = "./tests/cuerdas/" + esperado;
		System.out.println(pathEsperados);
		File file = new File(path);
		File x = new File(pathEsperados);*/
		} else if (args[1].equals("-afn")) {
			String path = args[0]; //./tests/gramaticas/pares.gld 
			System.out.println(path);
			String esperado = args[2]; // pares.txt
			System.out.println(esperado);
			String pathEsperados = "./tests/cuerdas/" + esperado;
			System.out.println(pathEsperados);
			File file = new File(path);
			File x = new File(pathEsperados);
		} else if (args[1].equals("-check")) { 
			if (args.length != 4) {

			}
			String path = args[0]; //./tests/gramaticas/pares.gld 
			System.out.println(path);
			String esperado = args[2]; // pares.txt
			System.out.println(esperado);
			String pathEsperados = "./tests/cuerdas/" + esperado;
			System.out.println(pathEsperados);
			File file = new File(path);
			File x = new File(pathEsperados);
		}
	}
}