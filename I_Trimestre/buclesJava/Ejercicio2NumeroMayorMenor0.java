package buclesJava;
/**
* Programa: Ejercicio2NumeroMayorMenor0.java
*
* Proposito: 2. Realizar un algoritmo que pida números (se pedirá por teclado la cantidad de números a introducir). 
*               El programa debe informar de cuantos números introducidos son mayores que 0, menores que 0 e iguales a 0.
*

* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * cantidadNumIntroducidos (numérica): almacenará la cantidad de números introducidos
 * numeros (numérica): almacenará si el numero introducido es positivo, negatico o cero
 * contPositivos (numérica): incrememtará en 1 cada número positivo introducido
 * contNegativos (numérica): incrememtará en 1 cada número negativo introducido
 * contCeros (numérica): incrememtará en 1 cada número cero introducido
 * 
 * 
 * Algoritmo:
 * 
 * ciclo for que recorra desde el primer número introducido hasta la totalidad de la cantidad de números que queremos analizar
 * si el núemro introducido es mayor que 0 incrementamos en 1 el contador de positivos
 * y si no, si el número es menor que 0 incrementamos en 1 el contador de negativos
 * si no el número introducido seía 0 e increemntamos en 1 el contador de iguales a 0
 * 
 * mostramos la cantidad de numeros mayores, menores e iguala 0
 *
 */

 import java.util.Scanner;

 public class Ejercicio2NumeroMayorMenor0 {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    int cantidadNumIntroducidos;
    int numeros;

    // inicializamos los contadores

    int contPositivos = 0;
    int contNegativos = 0;
    int contCeros = 0;
     
    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.print("Cuantos números quieres que analicemos: ");
    cantidadNumIntroducidos = sc.nextInt();
  
    // Calculos
      
     for (int i = 1; i <= cantidadNumIntroducidos; i++){
       System.out.println("Introduce un número: ");
       numeros = sc.nextInt();
    	 if (numeros > 0) {
    	   contPositivos++;
    	}else if (numeros < 0) {
    	  contNegativos++;
    	}else {
    	  contCeros++;
    	} 
    }
    System.out.println("la cantidad de números positivos introducidos ha sido: " + contPositivos);
    System.out.println("la cantidad de números negativos introducidos ha sido: " + contNegativos);
    System.out.println("la cantidad de números igual a cero introducidos ha sido: " + contCeros);
    }
   }
 