import java.io.*;
import java.util.*;
public class AFDGen{
  String file;
  FileWriter fw;
  String[] Vari;
	String[] lenguaje;
  ArrayList<String> Variables;
	ArrayList<String> listado;
  public AFDgen(String path){
    this.file = path;
  }

  public void fileGenerator() {

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
			Vari = scanner.nextLine().split(",");
			Variables = new ArrayList<String>();
			for (int j = 0; j < Vari.length; j++) {
				Variables.add(Vari[j]);
			}
			System.out.println("Variables: " + Variables);
			lenguaje = scanner.nextLine().split(",");
			listado = new ArrayList<String>();
			for (int j = 0; j < lenguaje.length; j++) {
				listado.add(lenguaje[j]);
			}
			String listado2 = (String)String.join(",", listado);
			fw.write(listado2);
      String VariIni = scanner.nextLine();
			
      ArrayList<ArrayList> trans = new ArrayList<ArrayList>();
      BufferedReader lineas = new BufferedReader();
			while(scanner.hasNextLine()) {
        // Variables = [S,A]
        // listado = a,b,c,d
        String[] linea = scanner.split("->");
        for ()
        
        int letras = 0;
        
				if( /*letras*/ = 0){ //[S,A] = 0 aaaabbb  S -> [aa]X
					for(i=0; i > /*letras*/ ; i++){
					/*[Numero de la variable <-- i][Numero de Estado Actual] <--- Ingresamos el estado al que hace transicion*/ 
					}
				} if( /*letras*/ = 1){
					if( /*Estado Final */ = ''){
						/*Estado Final = Nuevo estado */
						/*[Numero de la variable][Numero de Estado Actual] <--- Ingresamos el estado al que hace transicion*/ 
					} 
				} if( variables.length > 1){
						for(i=0; i > /*letras*/ ; i++){
						/*letras[i] = numero de la variable*/
						/*[Numero de la variable][Numero de Estado Actual] <--- Posicion de estado Final + 1*/
						/*Numero de Estado Actual = Posicion de Estado Final +1*/
					} if( /*Estado Final */ = ''){
						/*Estado Final = Nuevo estado */
						/*[Numero de la variable][Numero de Estado Actual] <--- Ingresamos el estado al que hace transicion*/ 
					} if else{
						/*[Numero de la variable][Numero de Estado Actual] <--- Posicion de estado Final + 1*/
					}
				} 
			}
      

			scanner.close();
			fw.close();
		 	} catch (FileNotFoundException s) {
				System.out.println("El archivo no existe");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("El archivo no existe");
  	} 
  }
}