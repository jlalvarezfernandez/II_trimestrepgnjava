package condicionalesJava;
/**
* Programa: Ejercicio4Division.java
*
* Proposito: 4. Crea un programa que pida al usuario dos números y muestre su división si el segundo no es cero,
                o un mensaje de aviso en caso contrario.


* 
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * numero1 (double): almacenará el primer número introducido
 * numero2 (double): almacenará el segundo número introducido
 * 
 * Algoritmo:
 * 
 * LEER: numero1, numero2
 * CALCULAR: si numero2 no es 0 será verdadero y se mostrará el resultado de la división, de lo contrario sera falso
 *           y el programa devolvera error.
 * 
 * 
 * 
 */
import java.util.Scanner;

 public class Ejercicio4Division {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    double numero1;
    double numero2;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el primer número: ");
    numero1 = sc.nextDouble();

    System.out.println("Introduce el segundo número: ");
    numero2 = sc.nextDouble();

    

    // Calculos

    if (numero2 != 0) {
      double division = (numero1 / numero2);
      System.out.println("El resultado de la división es: " + division);
    }
    else {
      System.out.println("ERROR!!, El segundo número introducido es 0");

    }
    }

   }