package buclesJava;
/**
* Programa: Ejercicio3VocalNoVocal.java
*
* Proposito: 3. Algoritmo que pida caracteres e imprima ‘VOCAL’ si son vocales y ‘NO VOCAL’ 
* 				en caso contrario.
*               El programa termina cuando se introduce un espacio.
*
*
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * caracter (cadena): almacenará el caracter introducido, se inicializará en un espacio (" ")
 * 
 * 
 * Algoritmo:
 * 
 * bucle while, mientras el caracter sea diferente de un espacio entrara en el bucle 
 * y realizara las siguientes acciones:
 * 
 * si el caracter introducido es igual a: a, e, i, o, u imprimimos vocal
 * sino imprimimos no vocal
 * 
 * pedimos caracteres hasta que el usuario introduzca un espacio para finalizar el programa

 *     
 */

 import java.util.Scanner;

 public class Ejercicio3VocalNoVocal {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    char caracter = ' ';

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce algún caracter(el programa finalizará cuando pulses un espacio): ");
    caracter = sc.nextLine().charAt(0);
    
  
    // Calculos

    while (caracter != ' ') {
      if (caracter == 'A' || caracter == 'a' || caracter == 'E' || caracter == 'e' ||caracter == 'I' || caracter == 'i' ||caracter == 'O' || caracter == 'o'||caracter == 'U' || caracter == 'u'  ) {
        System.out.println("VOCAL");
      } else {
        System.out.println("NO VOCAL");
      }
    System.out.println("Introduce caracteres: ");
    caracter = sc.nextLine().charAt(0);
      
    }
    System.out.println("Programa finalizado, has pulsado un espacio");

   }
 }