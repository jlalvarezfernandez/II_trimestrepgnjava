package secuencialesJava;
/**
* Programa: Ejercicio6Media.java
*
* Proposito: 7. Calcular la media de tres números pedidos por teclado.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/
/**
 * Variables:
 * num1 (double): almacenará el valor del primer número
 * num2 (double): almacenará el valor del segundo número
 * num3 (double): almacenará el valor del tercer número
 * media (double): almacenará la media d elos 3 números (num1 + num2 + num3) / 3
 * 
 * 
 * Algoritmo:
 * 
 * LEER: num1, num2, num3
 * CALCULAR: media
 * ESCRIBIR: media
 * 
 */

 public class Ejercicio6Media {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    double num1;
    double num2;
    double num3;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el primer número");
    linea = System.console().readLine();
    num1 = Double.parseDouble(linea);

    System.out.println("Introduce el segundo número");
    linea = System.console().readLine();
    num2 = Double.parseDouble(linea);

    System.out.println("Introduce el tercer número");
    linea = System.console().readLine();
    num3 = Double.parseDouble(linea);

    // Calculos

    double media = ((num1 + num2 + num3) / 3 );

    // Mostramos los resultados por pantalla

    System.out.println("La media de los tres números introducidos es: "+ media);



   }
 }