package ficherosClaseScanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Realiza un programa que sea capaz de ordenar alfabéticamente las palabras contenidas en un fichero de texto. 
 * El nombre del fichero que contiene las palabras se debe pasar como argumento en la línea de comandos. 
 * El nombre del fichero resultado debe ser el mismo que el original añadiendo la coletilla sort, por ejemplo palabras_sort.txt. 
 * Suponemos que cada palabra ocupa una línea.
 * 
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio04LibroJava {

  public static void main(String[] args) throws IOException {

    if ((args.length != 1)) {
      System.err.println("Error al introducir los parámetros");
      System.exit(-1);
    }


    try {
      // ArrayList de palabras
      ArrayList<String> arrayOrdenado = new ArrayList<>();
      
      // Formamos nombre de fichero 
      String nombre = args[0].substring(0, args[0].length()-4);
      String extension = ".txt";
      String nombreFichero = nombre + "_sort" + extension;
      
      // Manejadores de texto
      BufferedReader ficheroLectura = new BufferedReader(new FileReader(args[0]));
      BufferedWriter ficheroEscritura = new BufferedWriter(new FileWriter(nombreFichero));
      
      String linea = ficheroLectura.readLine();
      
      while (linea != null) {
        // Añadimos la linea leida al array list
        arrayOrdenado.add(linea);
        // leemos nueva linea
        linea = ficheroLectura.readLine();       
      }
      
      ficheroLectura.close();
      // Ordenamos array
      Collections.sort(arrayOrdenado);
      
      
      for (int i=0; i<arrayOrdenado.size() ; i++) {
        // Añadimos cada palabra ordenada al nuevo fichero
        String palabra = arrayOrdenado.get(i);
        // Escribimos la palabra
        ficheroEscritura.write(palabra + "\n");
      }
      // Cerramos fichero
      ficheroEscritura.close();
     
      System.out.println("Operación completada.");
      
      

    } catch (IOException e) {
      System.err.println("Error de lectura o escritura");
    }
    
    


  }

}
