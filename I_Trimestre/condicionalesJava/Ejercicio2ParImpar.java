package condicionalesJava;
/**
* Programa: Ejercicio2ParImpar.java
*
* Proposito: 2. Escribe un programa que lea un número e indique si es par o impar.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * numero (int): almacenará el número introducido
 * 
 * Algoritmo:
 * 
 * LEER: numero1
 * CALCULAR: si numero es par será verdadero, de lo contrario sera falso
 *           un número es par si el resto de su división es 0
 * 
 * 
 * 
 */
import java.util.Scanner;

 public class Ejercicio2ParImpar {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    int numero;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce un número: ");
    numero = sc.nextInt();

    

    // Calculos

    if (numero % 2 == 0) {
      System.out.println("El número introducido es par");
    }
    else {
      System.out.println("El número introducido es impar");

    }
    }

   }