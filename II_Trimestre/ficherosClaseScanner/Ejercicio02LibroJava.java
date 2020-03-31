package ficherosClaseScanner;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * PROPOSITO: 2. Realiza un programa que lea el fichero creado en el ejercicio anterior y que muestre los números por pantalla.
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio02LibroJava {

  public static void main(String[] args) {
    
    /**
     * creamos bloque try-catch
     * dentro del try creamos el archivo para lectura
     * ciclo while mikentras linea no sea EOF lee cada linea del fichero primos.dat
     * mostramos los resultados por pantalla
     */
    
    try {
      BufferedReader fichero = new BufferedReader(new FileReader("primos.dat"));
      
      String linea = fichero.readLine();
      
      while (linea != null) {
        linea = fichero.readLine();
      }
      
      
      fichero.close();
      
    } catch (Exception e) {
      System.err.println("Error, no se ha podido escribir en el fichero");
    }
    

  }

}
