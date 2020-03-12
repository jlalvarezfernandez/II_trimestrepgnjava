package condicionalesJava;
/**
* Programa: Ejercicio18DiaSemana.java
*
* Proposito: 18. Realiza un programa que pida el día de la semana (del 1 al 7) y escriba el día correspondiente. 
                 Si introducimos otro número nos da un error.


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

public class Ejercicio18DiaSemana {
  public static void main (String[] args) {

    Scanner sc = new Scanner (System.in);


    // Definimos las variables

    int opcion;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce un número del 1 al 7 para saber a que dia de la semana corresponde: ");
    opcion = sc.nextInt();

    // Calculos

  switch (opcion){
    case 1: 
      System.out.println("Lunes");
      break;
    case 2: 
      System.out.println("Martes");
      break;
    case 3: 
      System.out.println("Miercoles");
      break;
    case 4: 
      System.out.println("Jueves");
      break;
    case 5: 
      System.out.println("Viernes");
      break;
    case 6: 
      System.out.println("Sabado");
      break;
    case 7:
      System.out.println("DOmingo");
      break;
    default:
      System.out.println("ERROR!!!, no has introducido un número entre el 1 y el 7");

  }

  }
  }

