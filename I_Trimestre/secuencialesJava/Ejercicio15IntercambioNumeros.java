package secuencialesJava;
/**
* Programa: Ejercicio15IntercambioNumeros.java
*
* Proposito: 15. Dadas dos variables numéricas A y B, que el usuario debe teclear, 
                 se pide realizar un algoritmo que intercambie los valores de ambas variables 
                 y muestre cuanto valen al final las dos variables.


*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 4/11/2019
*/
/**
 * Variables:
 * numeroA (double): almacenará el valor del primer número introducido
 * numeroB (double): almacenará el valor del segundo número introducido
 * cambio (double): almacenará el cambio de numeros
 * 
 * Algoritmo:
 * 
 * LEER: numeroA, numeroB
 * CALCULAR: cambio
 * ESCRIBIR: cambio
 * 
 */


 public class Ejercicio15IntercambioNumeros {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    int numeroA;
    int numeroB;
  
  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el valor de A: ");
    linea = System.console().readLine();
    numeroA =Integer.parseInt(linea);

    System.out.println("Introduce el valor de B: ");
    linea = System.console().readLine();
    numeroB =Integer.parseInt(linea);

    // Calculos

   int cambio = numeroA;
   numeroA = numeroB;
   numeroB = cambio; 

  
   
    // Mostramos los resultados por pantalla

    System.out.println("Ahora el valor del número A es: " + numeroA + " y el del número B es: " + numeroB);

   }
 }