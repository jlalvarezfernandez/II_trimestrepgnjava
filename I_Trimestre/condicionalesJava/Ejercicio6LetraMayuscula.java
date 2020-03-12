package condicionalesJava;
/**
* Programa: Ejercicio6LetraMayuscula.java
*
* Proposito: 6. Programa que lea una cadena por teclado y compruebe si es una letra mayúscula.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * letra (String): almacenará la letra introducida
 * 
 * 
 * Algoritmo:
 * 
 * LEER: letra
 * CALCULAR: si letra esta escrita en mayusculas será verdadero, de lo contrario sera falso.
 *           Para comprobar que una letra es mayuscula debemos recurrir a toUpperCase (nos devuelve si esta en mayusculas o no);
 * 
 */
import java.util.Scanner;

 public class Ejercicio6LetraMayuscula {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    String letra;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce una letra: ");
    letra = sc.nextLine();
    
  // Calculos

    if (letra == letra.toUpperCase()) {
      
      System.out.println("la letra introducida esta escrita en mayusculas ");
    }
    else {
      System.out.println("la letra introducida esta escrita en minusculas");

    }
    }

   }