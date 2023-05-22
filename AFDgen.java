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

  public void fileGenerator(){

    try {
			String nombre = path.replaceAll(".gld", "");
			nombre = nombre.replace(".", "");
			nombre = nombre.replace("tests", "");
			nombre = nombre.replace("/gramaticas", "");
			nombre = nombre.replace("/", "");
			String newPath = "./afd/" + nombre + ".afd";
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
			System.out.println("Lenguaje: " + listado2);
			fw.write(listado2);
			
			scanner.close();
			fw.close();
		 	} catch (FileNotFoundException s) {
				System.out.println("El archivo no existe");
			}
		} catch (FileNotFoundException ex) {
			System.out.println("El archivo no existe");
  	} 
  }

  /*
  if (EstadoI = EstadoF){
    if (transiciones = 0){
      
    } else if (transiciones = 1){
      for(c = 0; c < length (lista de transiciones) + 1; c++) 
        if (transicioin = lista transicion[i]){
        for(i = 0; c < length (lista de estados) + 1; i++) 
          if (transicioin = lista de estados[i]){
        EstadoI -->  [][c][i+1]  Ingresamos la transicion a la lista de transiciones 
  } else if()
      return
    } else if (transiciones > 1){
      
    }
    
  }
  if (EstadoF = ''){
    
  }
  for(c = 0; c < length (lista de estados) + 1; i++) 
  if (EstadoI = lista estado[i]){
    EstadoI -->  [][i]  Ingresamos el estado a 
  } else if()
   
  */ 
}