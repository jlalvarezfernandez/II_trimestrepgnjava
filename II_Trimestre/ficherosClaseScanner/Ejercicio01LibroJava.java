package ficherosClaseScanner;
/**
 * PROPOSITO:  1. Escribe un programa que guarde en un fichero con nombre primos.dat los números primos que hay entre 1 y 500.
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * 
 */

import java.io.BufferedWriter;
import java.io.FileWriter;


public class Ejercicio01LibroJava {
  
  /**
   * Creamos la funcion para saber si un nuemro es primo o no
   * @param primo
   * @return
   */


  public static boolean esPrimo (int primo) {

    boolean creoPrimo = true;
    for (int i = 2; i <= Math.sqrt(primo) && creoPrimo; i++) {

      if ((primo % i) == 0) {
        creoPrimo = false;
      } 
    }
    return creoPrimo;
  }

  public static void main(String[] args) {
    
    /**
     * creamos un fichero para escritura llamado primos.dat
     * lo hacemos dentro de un bloque de excepcio try-catch
     * creamos un bucle for que compruebe por cada iteracion si el nuemro es primo
     * si lo es lo añade al fichero
     * cerramos el archivo
     */

    try {
    
      BufferedWriter fichero = new BufferedWriter(new FileWriter("primos.dat"));
      for (int i = 1; i <= 501; i++) {
        if (esPrimo(i)) {
          fichero.write(i + "\n");
        }
      }
      fichero.close();
    } catch (Exception e) {
      System.out.println("Error, no se ha podido escribir en el fichero");
    }
  }
}
