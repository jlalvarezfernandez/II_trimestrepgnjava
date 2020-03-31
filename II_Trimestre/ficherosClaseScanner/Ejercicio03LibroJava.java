package ficherosClaseScanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * PROPOSITO: 3. Escribe un programa que guarde en un fichero el contenido de otros dos ficheros, 
 *               de tal forma que en el fichero resultante aparezcan las líneas de los primeros dos ficheros mezcladas, 
 *               es decir, la primera línea será del primer fichero, la segunda será del segundo fichero, 
 *               la tercera será la siguiente del primer fichero, etc. 
 *               
 *               Los nombres de los dos ficheros origen y el nombre del fichero destino se deben pasar como argumentos en la línea de comandos.
 *               
 *               Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas pueden tener tamaños diferentes.


 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio03LibroJava {

  public static void main(String[] args) {
    
//    
//     creamos un bloque try-catch
//     en el definimos los 3 ficheros que vamos a necesitar
//     2 de lectura y uno de escritura
//     creamos un bucle while que mientras el foichero1 y el fichero 2 no lleguen al EOF vayan leyendo los datos
//     despues esos datos los vamos introducuiendo en el fichero de escritura
//     cerramos los ficheros.
//     

    try {

      BufferedReader fichero1 = new BufferedReader(new FileReader("fichero1.txt"));
      BufferedReader fichero2 = new BufferedReader(new FileReader("fichero2.txt"));
      BufferedWriter ficheroMezclado = new BufferedWriter(new FileWriter("ficheroMezcla.txt"));

      String linea1 = fichero1.readLine();
      String linea2 = fichero1.readLine();

      while ( (linea1 != null) || (linea2 != null) ) {
        linea1 = fichero1.readLine();
        linea2 = fichero2.readLine();
        if (linea1 != null) {
          ficheroMezclado.write(linea1 + "\n");
        }
        if (linea2 != null) {
          ficheroMezclado.write(linea2 + "\n");
        }
      }
      fichero1.close();
      fichero2.close();
      ficheroMezclado.close();



    } catch (Exception e) {
      System.err.println("ERROR, no existe el archivo");
    }


  }

}
