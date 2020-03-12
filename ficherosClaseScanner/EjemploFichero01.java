package ficherosClaseScanner;

/**
 * Ejemplo de uso de la clase File
 * Lectura de un fichero de texto
 *
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploFichero01 {

  public static void main(String[] args) {

    try {
      BufferedReader br = new BufferedReader(new FileReader("cordoba.txt"));
      
      String linea = br.readLine();  // variable para leer el contenido del archivo
      int n = 1;
      while (linea != null) { // mientras linea sea distinta de null leemos la linea y la mostramos
        System.out.println("Linea " + n + ": " + linea);
        linea = br.readLine();
        n++;
      }

      br.close(); // cerramos el manejador
      
    } catch (FileNotFoundException fnfe) { // qué hacer si no se encuentra el fichero
      System.out.println("No se encuentra el fichero Cordoba.txt");
    } catch (IOException ioe) { // qué hacer si hay un error en la lectura del fichero
      System.out.println("No se puede leer el fichero Cordoba.txt");
    }


  }

}
