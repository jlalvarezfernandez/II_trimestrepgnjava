package secuencialesJava;
/**
* Programa: Ejercicio5ConversorGrados.java
*
* Proposito: 5. Escribir un programa que convierta un valor dado en grados Fahrenheit a grados Celsius.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/
/**
 * Variables:
 * farenheit (double): almacenará la cantidad de grados farenheit
 * conversor (double): almacenará la conversion de grados farenheit a grados celsius (farenheit -32 / 1.8000 )
 * 
 * 
 * Algoritmo:
 * 
 * LEER: farenheit
 * CALCULAR: conversor
 * ESCRIBIR: conversor
 * 
 */

 public class Ejercicio5ConversorGrados {
   public static void main (String[] args ){

    // Definimos las variables

    String linea;
    double gradosFarenheit;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce la cantidad de grados Farenheit: ");
    linea = System.console().readLine();
    gradosFarenheit = Double.parseDouble(linea);

    // Calculos

    double conversor = ((gradosFarenheit -32) /1.8000);

    // Mostramos los resultados por pantalla

    System.out.println(gradosFarenheit + " grados Farenheit, equivalen a " + conversor + " grados Celsius");
  
  }
 }