package secuencialesJava;
/**
* Programa: Ejercicio13RaizCuadradaCubica.java
*
* Proposito: 13. Realizar un algoritmos que lea un número y que muestre su raíz cuadrada y su raíz cúbica.
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/
/**
 * Variables:
 * numero (double): almacenará el valor del número
 * cuadrada (double): almacenará al raiz cuadrada del numero (Math.sqrt(numero))
 * cubica (double): alamcenará la raiz cúbica del número (Math.pow(numero,1/3))
 * Algoritmo:
 * 
 * LEER: num1
 * CALCULAR: cuadrada, cubica
 * ESCRIBIR: cuadrada, cubica
 * 
 */


 public class Ejercicio13RaizCuadradaCubica {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    double numero;
  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce un número: ");
    linea = System.console().readLine();
    numero = Double.parseDouble(linea);

    // Calculos

   double cuadrada = Math.sqrt(numero);
   double cubica = Math.pow(numero,1.0/3.0);
   
    // Mostramos los resultados por pantalla

    System.out.println("La raiz cuadrada de " + numero + " es: " + cuadrada);
    System.out.println("La raiz cúbica de " + numero + " es: " + cubica);



   }
 }