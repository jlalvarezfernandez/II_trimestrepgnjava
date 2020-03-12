package secuencialesJava;
/**
* Programa: Ejercicio11DistanciaNumeros.java
*
* Proposito: 11. Pide al usuario dos números y muestra la "distancia" entre ellos 
*                (el valor absoluto de su diferencia, de modo que el resultado sea siempre positivo).
*
* @author José Luis Álvarez Fernández
*
* Fecha: 2/11/2019
*/
/**
 * Variables:
 * num1 (double): almacenará el valor del primer número
 * num2 (double): almacenará el valor del primer número
 * distancia (double): almacenará la distancia entre los dos números (Math.abs(num1 - num2))
 * 
 * Algoritmo:
 * 
 * LEER: num1, num2
 * CALCULAR: distancia
 * ESCRIBIR: distancia
 * 
 */


 public class Ejercicio11DistanciaNumeros {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    double num1;
    double num2;
  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el primer número: ");
    linea = System.console().readLine();
    num1 = Double.parseDouble(linea);

    System.out.println("Introduce el segundo número: ");
    linea = System.console().readLine();
    num2 = Double.parseDouble(linea);

    // Calculos

   double distancia = Math.abs(num1-num2);
   
    // Mostramos los resultados por pantalla

    System.out.println("La distancia entre los dos numeros es de: " + distancia);



   }
 }