package buclesJava;
/**
* Programa: Ejercicio4NumerosPares.java
*
* Proposito:  4. Escribir un programa que imprima todos los números pares entre dos números 
* 				 que se le pidan al usuario.
*
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * num1 (numérico): almacenará el primer número introducido
 * num2 (numérico): almacenará el segundo número introducido
 * 
 * Algoritmo:
 * 
 * leemos num1 y num2
 * ciclo for que recorra desde num1 hasta num2
 * si el resto de la division de i entr 2 es igual a 0 sabemos que ese número es par
 * imprimimos i 
 * 
 */

 import java.util.Scanner;

 public class Ejercicio4NumerosPares {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    int numero1;
    int numero2;
    

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el primer número: ");
    numero1  = sc.nextInt();

    System.out.println("Introduce el segundo número: ");
    numero2  = sc.nextInt();

  
    // Calculos

    for (int i = numero1; i <=numero2; i++) {
      if (i%2 == 0) {
      System.out.println("Los números pares entre esos dos números son: " + i);
    }
   }
   System.out.println("Fin programa");
 }
}