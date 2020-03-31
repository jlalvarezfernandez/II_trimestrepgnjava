package ficherosClaseScanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * PROPOSITO: 5. Escribe un programa capaz de quitar los comentarios de un programa de Java.
 *               Se utilizaría de la siguiente manera:
 * 
 *                    quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO
 *      
 *                  Por ejemplo:
 *                    quita_comentarios hola.java holav2.java 
 *      
 *              crea un fichero con nombre holav2.java que contiene el código de hola.java pero sin los comentarios.
 *      
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio05LibroJava {

  public static void main(String[] args) {
    
    try {
      
      BufferedReader fichero1 = new BufferedReader(new FileReader("hola.java"));
      BufferedWriter fichero2 = new BufferedWriter(new FileWriter("holav2.java"));
      
      String linea = fichero1.readLine();
      
      while (linea != null) {
        
        linea = fichero1.readLine();
        if (linea != null) {
          fichero2.write(linea + "\n");
        }
        
      }
      
      fichero1.close();
      fichero2.close();
    } catch (Exception e) {
      
    }
    
    

  }

}
