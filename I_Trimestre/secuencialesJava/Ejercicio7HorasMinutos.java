package secuencialesJava;
/**
* Programa: Ejercicio7HorasMinutos.java
*
* Proposito: 7. Realiza un programa que reciba una cantidad de minutos 
*               y muestre por pantalla a cuantas horas y minutos corresponde.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/
/**
 * Variables:
 * min (double): almacenará la cantidad de minutos introducidos por le usuario
 * horas (double): almacenará las horas a las que corresponden los minutos introducidos (min / 60)
 * restoMin (double): almacenará los minutos sobrantes de las horas (min % 60)
 *   
 * 
 * Algoritmo:
 * 
 * LEER: min
 * CALCULAR: horas, restoMin
 * ESCRIBIR: horas, restoMin
 * 
 */

 public class Ejercicio7HorasMinutos {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    int min;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce la cantidad de minutos: ");
    linea = System.console().readLine();
    min = Integer.parseInt(linea);

    // Calculos

    int horas = (min / 60);
    int restoMin = ( min % 60 );


    // Mostramos los resultados por pantalla

    System.out.println(min+ " minutos, equivalen a: " + horas + " y " + restoMin + " minutos");



   }
 }