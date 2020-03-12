package secuencialesJava;
/**
* Programa: Ejercicio14NumeroInvertido.java
*
* Proposito: 14. Dado un número de dos cifras, diseñe un algoritmo que permita obtener el número invertido.
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 4/11/2019
*/
/**
 * Variables:
 * numero (double): almacenará el valor del número
 * primeraCifra (double): almacenará el resto de dividir el número entre 10, que sería la segunda cifra del número introducido
 * segundaCifra (double): almacenará la division del número entre 10, que seria la primera cifra del número introducido
 * invertido (double): almacenará el número invertido, que seria el resultado de multiplicar por 10 la primeraCifra más la segundaCifra
 * 
 * 
 * Algoritmo:
 * 
 * LEER: numero
 * CALCULAR: invertido
 * ESCRIBIR: invertido
 * 
 */


 public class Ejercicio14NumeroInvertido {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    int numero;
  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce un número: ");
    linea = System.console().readLine();
    numero =Integer.parseInt(linea);

    // Calculos

   int primeroCifra = numero % 10;
   int segundaCifra = numero / 10;
   int invertido = primeroCifra * 10 + segundaCifra;
   
    // Mostramos los resultados por pantalla

    System.out.println("El número " + numero + " invertido es: " + invertido );

   }
 }