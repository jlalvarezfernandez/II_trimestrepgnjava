package condicionalesJava;
/**
* Programa: Ejercicio1NumeroMayorMenor.java
*
* Proposito: Algoritmo que pida dos números e indique si el primero es mayor que el segundo o no.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 1/11/2019
*/

/**
 * Variables:
 * numero1 (double): almacenará el primer número introducido
 * numero2 (double): almacenará el segundo número introducido
 * 
 * Algoritmo:
 * 
 * LEER: numero1, numero2
 * CALCULAR: si numero1 es mayor que numero2 será verdadero, de lo contrario sera falso y 
 *           el segundo número será mayor que el primero
 * 
 * 
 * 
 */
import java.util.Scanner;

 public class Ejercicio1NumeroMayorMenor {
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

    if (numero1 > numero2) {
      System.out.println("El primer número es mayor que el segundo");
    }
    else {
      System.out.println("El segundo número es mayor que el primero");

    }
    }

   }

 
