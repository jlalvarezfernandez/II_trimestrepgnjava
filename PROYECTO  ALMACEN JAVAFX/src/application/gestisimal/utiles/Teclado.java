package application.gestisimal.utiles;

import java.util.Scanner;

public class Teclado {

  private static Scanner sc = new Scanner (System.in);

  // metodo para leer una cadena con clase teclado

  public static String getLeeCadena(String mensaje) {
    System.out.println(mensaje);
         return getLeeCadena();
  }

  /**
   * metodo para leer una cadena con clase teclado
   * @param cadena
   * @return String
   */

  public static String getLeeCadena() {
        return sc.nextLine();
  }
  
  // Método para leer un número entero

  public static int getLeeEntero(String mensaje) {
    System.out.println(mensaje);
    return getLeeEntero();
  }
  
  /**
   * metodo para leer un número entero con la clase teclado
   * @param cadena
   * @return int
   */

  public static int getLeeEntero () {
    do {
      try {
        return Integer.parseInt(sc.nextLine());
      } catch  (NumberFormatException excepcion){
        System.err.println("ERROR!!!; debes introducir un número entero"); 
      }
    } while(true);
  }
  
  // Método para leer un núemro real con la clase teclado

 public static double getLeeReal(String mensaje) {
   System.out.println(mensaje);
        return getLeeReal();
 }


  /**
   * metodo para leer un número real
   * @param cadena
   * @return
   */

  public static double getLeeReal () {
    do {
      try {
        return Double.parseDouble(sc.nextLine());
      } catch  (NumberFormatException excepcion){
        System.err.println("ERROR!!!; debes introducir un número decimal"); 
      }
    } while(true);
  }

}

