package utiles;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Algunas especificaciones sobre Teclado:
 *       Permite la lectura desde teclado
 *       Teclado es un envoltorio de scanner, que es un analizador de texto que 
 *       puede analizar tipos y cadenas primitivas usando expresiones regulares
 *       No tiene estado todo es estático. Las invocaciones serán Teclado.leerCaracter() o Teclado.leerEntero("Introduce la cantidad de artículos: ")
 *       Sobrecargaréis los métodos. Uno sólo leerá del teclado y otro leerá de teclado y mostrará un mensaje. Este invocará al anterior. 
 *       No se puede duplicar código. Hay que reutilizarlo.
 *       En caso de error habrá que capturar las excepciones. Evita capturar Exception. Tendrás que ser más específico (InputMismatchException)
 *       
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Teclado {

  private static Scanner sc = new Scanner (System.in);

  // metodo para leer una cadena con clase teclado

  public static String leeCadena () {
  
         return sc.nextLine();
  }
  /**
   * metodo para leer una cadena con clase teclado
   * @param cadena
   * @return String
   */

  public static String leeCadena (String cadena) {
    do {
      try {
        System.out.println(cadena);
        return sc.nextLine();
      } catch  (InputMismatchException excepcion){
        System.err.println("ERROR!!!; debes introducir una cadena"); 
      }
    } while(true);
  }

  /**
   * metodo para leer un entero
   * @param cadena
   * @return int
   */

  public static int leeEntero (String cadena) {
    do {
      try {
        System.out.println(cadena);
        return Integer.parseInt(sc.nextLine());
      } catch  (NumberFormatException excepcion){
        System.err.println("ERROR!!!; debes introducir un número entero"); 
      }
    } while(true);
  }




  /**
   * metodo para leer un real
   * @param cadena
   * @return
   */

  public static double leeReal (String cadena) {
    do {
      try {
        System.out.println(cadena);
        return Double.parseDouble(sc.nextLine());
        
      } catch  (NumberFormatException excepcion){
        System.err.println("ERROR!!!; debes introducir un número decimal"); 
      }
    } while(true);
  }


}



  
  


