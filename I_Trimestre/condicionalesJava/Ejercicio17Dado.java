package condicionalesJava;
/**
* Programa: Ejercicio17Dado.java
*
* Proposito: 17. Realiza un programa que pida por teclado el resultado (dato entero) 
*               obtenido al lanzar un dado de seis caras y muestre por pantalla el número en letras (dato cadena) 
*               de la cara opuesta al resultado obtenido.
*        Nota 1: En las caras opuestas de un dado de seis caras están los números: 1-6, 2-5 y 3-4.
*        Nota 2: Si el número del dado introducido es menor que 1 o mayor que 6, se mostrará el mensaje: “ERROR: número incorrecto.”.
*
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * opcion (entero): almacenará la opciona  elegir entre las propuestas
 * 
 * Algoritmo:
 * LEER: opcion
 * CALCULAR: switch con las diferentes opciones      
 *
 *  
 */

import java.util.Scanner;

public class Ejercicio17Dado {
  public static void main (String[] args) {

    Scanner sc = new Scanner (System.in);


    // Definimos las variables

    int opcion;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce un número de un dado (1 al 6) para saber cual es su cara opuesta: ");
    opcion = sc.nextInt();

    // Calculos

  switch (opcion){
    case 1: 
      System.out.println("La cara opuesta del 1 es el 6");
      break;
    case 2: 
      System.out.println("La cara opuesta del 2 es el 5");
      break;
    case 3: 
      System.out.println("La cara opuesta del 3 es el 4");
      break;
    case 4: 
      System.out.println("La cara opuesta del 4 es el 3");
      break;
    case 5: 
      System.out.println("La cara opuesta del 5 es el 2");
      break;
    case 6: 
      System.out.println("La cara opuesta del 6 es el 1");
      break;
    default:
      System.out.println("ERROR!!!, no has introducido un número entre el 1 y el 6");

  }

  }
  }


