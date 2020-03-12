package secuencialesJava;
/**
* Programa: Ejercicio1Saludo.java
*
* Proposito: Escribir un programa que pregunte al usuario su nombre, y luego lo salude.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 1/11/2019
*/

/**
 * Variables:
 * nombre (String): alamcenará el nombre introducido por el usuario
 * 
 * Algoritmo:
 * 
 * LEER: nombre
 * ESCRIBIR: nombre
 * 
 * 
 */

 public class Ejercicio1Saludo {
   public static void main (String[] args ) {


    // definimos las variables

    String nombre;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce tu nombre: ");
    nombre = System.console().readLine();

    // Mostramos los resultados por pantalla

    System.out.println("Hola " + nombre + " !!!!, ¿Qué tal estás?");

   }
 }