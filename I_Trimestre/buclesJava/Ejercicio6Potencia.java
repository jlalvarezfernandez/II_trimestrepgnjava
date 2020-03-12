package buclesJava;
/**
* Programa: Ejercicio6Potencia.java
*
* Proposito: 6. Escribe un programa que dados dos números, uno real (base) 
* 				y un entero positivo (exponente), saque por pantalla el resultado de la potencia. 
* 				No se puede utilizar el operador de potencia.
*
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * base (numérica): almacenará la base para calcular la potencia
 * exponente (numérica): almacenará el exponente para calcular la potencia
 * potencia (numérica): almacenará el resultado de la potencia
 * 
 * Algoritmo:
 * 
 * leer los datos de base y exponente
 * ciclo for que recorre el exponente tantas veces como le hayamosmindicado y despues se multiplica por la baase
 * mostramos los resultados por pantalla
 */

 import java.util.Scanner;

 public class Ejercicio6Potencia {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    int base;
    int exponente;
    int potencia = 1;
    
   

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el primer número (base): ");
    base  = sc.nextInt();

    System.out.println("Introduce el segundo número (exponente): ");
    exponente  = sc.nextInt();

  
    // Calculos
    
    for (int i = 0; i< exponente;i++) {

      potencia *= base;
      
    }
    System.out.println("El resultado de la potencia es: " + potencia);
    
    

    }

 }
