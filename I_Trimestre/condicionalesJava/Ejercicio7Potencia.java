package condicionalesJava;
/**
* Programa: Ejercicio7Potencia.java
*
* Proposito: Realiza un algoritmo que calcule la potencia, para ello pide por teclado la base y el exponente. 
*            Pueden ocurrir tres cosas:
*
*                   El exponente sea positivo, sólo tienes que imprimir la potencia.
*                   El exponente sea 0, el resultado es 1.
*                   El exponente sea negativo, el resultado es 1/potencia con el exponente positivo.
*
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * base (double): almacenará la base de la potencia
 * exponente (double): almacenará el exponente de la potencia
 * potencia (double): almacenará el resultado de la potencia
 * 
 * Algoritmo:
 * 
 * LEER: base, exponente
 * CALCULAR: si el exponente es positivo será verdadero, sino si exponente es 0 sera veradero, de lo contrario sera falso.
 *           usaremos Math.pow() para calcular la potencia
 * 
 */
import java.util.Scanner;

 public class Ejercicio7Potencia {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    double base;
    double exponente;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce la base de la potencia: ");
    base = sc.nextDouble();

    System.out.println("Introduce el exponente la potencia: ");
    exponente = sc.nextDouble();
    
  // Calculos

    if (exponente > 0) {

      double potencia = Math.pow(base,exponente);
      
      System.out.println("el resultado de la potencia es: " + potencia);
    }
    else if (exponente == 0) {
      System.out.println("el resultado de la potencia es 1");
    }
    else {
      System.out.println("el resultado de la potencia es 1/potencia con el exponente positivo.");

    }
    }

   }