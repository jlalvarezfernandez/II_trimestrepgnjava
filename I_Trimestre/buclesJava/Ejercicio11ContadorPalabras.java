package buclesJava;
/**
* Programa: Ejercicio11ContadorPalabras.java
*
* Proposito: 11. Suponiendo que hemos introducido una cadena por teclado que representa una frase (palabras separadas por espacios),
*                realiza un programa que cuente cuantas palabras tiene.
*
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * cadena (cadena): almacenará la cadena introducida por el usuario
 * contadorPalabras (entero): alamcenará la cantidad de palabras que hay en la cadena, iniciada en 0
 * 
 * Algoritmo:
 * 
 * introducimos los datos por pantalla
 * para saber cuantas palabras hay en una cadena debemos contar los espacios que hay entre cada palabra
 * cada espacio significa que hay dos palabras
 * creamos un ciclo for que recorre toda la cadena
 * condicianal si cadena se va recorriendo y es igual a un espcio el contador de palabras se incrementara en 1
 * mostramos los resultados por pantalla 
 */

 import java.util.Scanner;
 
 public class Ejercicio11ContadorPalabras {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    String cadena;
    int contadorPalabras = 0;


    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce una frase por pantalla: ");
    cadena = sc.nextLine();
    

    // Calculos
    
    for (int i = 0; i <cadena.length(); i++) {
    	if (cadena.substring(i,i+1).equals(" ")) {
    		contadorPalabras++;
    	}
    }
    System.out.println("El número total de palabras es de: " + (contadorPalabras+1));

 }
  }