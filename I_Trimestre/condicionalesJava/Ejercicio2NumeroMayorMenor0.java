package condicionalesJava;
/**
* Programa: Ejercicio2NumeroMayorMenor0.java
*
* Proposito: 2. Realizar un algoritmo que pida números (se pedirá por teclado la cantidad de números a introducir). 
*               El programa debe informar de cuantos números introducidos son mayores que 0, menores que 0 e iguales a 0.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * numeros (numérica): almacenará la cantidad de números introducidos
 * 
 * Algoritmo:
 * 
 * LEER: numeros
 * CALCULAR: 
 *     * introducimos los números por pantalla
 *     * inicializamos un contador a 0 para cada número introducido (positivos, negativos, ceros)
 *     * por cada número introducido incrementamos en 1 el contador correspondiente
 * ESCRIBIR: mostramos los resultados 
 *     * numPositivos, numNegativos, numCeros
 *
 */

 import java.util.Scanner;

 public class Ejercicio2NumeroMayorMenor0 {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    int numeros;
    int positivos;
    int negativos;
    int ceros;
    

    
    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.print("Cuantos números quieres que analicemos: ");
    numeros = sc.nextInt();
  
    
    // inicializamos los contadores

    int contPositivos = 0;
    int contNegativos = 0;
    int contCeros = 0;


    // Calculos

    for (int i = 1; i <= numeros; i++) {

      if (numeros > 0) {
        System.out.println("Introduce un número: ");
        positivos = sc.nextInt();
        contPositivos++;
      } else if (numeros <0) {
          System.out.println("Introduce un número: ");
          negativos = sc.nextInt();
          contNegativos++;
      } else {
          System.out.println("Introduce un número: ");
          ceros = sc.nextInt();
          contCeros++;
      }
      }
    System.out.println("la cantidad de números positivos introducidos ha sido: " + contPositivos);
    System.out.println("la cantidad de números negativos introducidos ha sido: " + contNegativos);
    System.out.println("la cantidad de números igual a cero introducidos ha sido: " + contCeros);

   }
 }