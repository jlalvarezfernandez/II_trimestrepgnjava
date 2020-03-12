package condicionalesJava;
/**
* Programa: Ejercicio12Bisiesto.java
*
* Proposito: 12. Escribir un programa que lea un año indicar si es bisiesto. 
*                Nota: un año es bisiesto si es un número divisible por 4, 
*                pero no si es divisible por 100, excepto que también sea divisible por 400.
*
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * annio (double): almacenará el año introducido
 * 
 * 
 * Algoritmo:
 * LEER: annio
 * CALCULAR: si el resto del año intruducido y dividido entre 4 o 400 es cero el año es bisiesto 
 */
import java.util.Scanner;

 public class Ejercicio12Bisiesto {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    int annio;
  
    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el año que quieras: ");
    annio = sc.nextInt();


  // Calculos


  if ( annio % 4 == 0 && annio % 100 != 0 || annio % 400 == 0) {
    System.out.println(annio + " es un año bisiesto");
  }
  else {
    System.out.println(annio + " NO es un año bisiesto");

  }
  
}
 }
