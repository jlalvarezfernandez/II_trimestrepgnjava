package condicionalesJava;
/**
* Programa: Ejercicio19DiasMes.java
*
* Proposito: 18. Escribe un programa que pida un número entero entre uno y doce 
                 e imprima el número de días que tiene el mes correspondiente.




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

public class Ejercicio19DiasMes {
  public static void main (String[] args) {

    Scanner sc = new Scanner (System.in);


    // Definimos las variables

    int opcion;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce un número del 1 al 12 para saber cuantos dias tiene ese mes: ");
    opcion = sc.nextInt();

    // Calculos

  switch (opcion){
    case 1: 
      System.out.println("Enero tiene 31 dias");
      break;
    case 2: 
      System.out.println("febrero tiene 28 dias");
      break;
    case 3: 
      System.out.println("Marzo tiene 31 dias");
      break;
    case 4: 
      System.out.println("Abril tiene 30 dias");
      break;
    case 5: 
      System.out.println("Mayo tiene 31 dias");
      break;
    case 6: 
      System.out.println("Junio tiene 30 dias");
      break;
    case 7:
      System.out.println("Julio tiene 31 dias");
      break;
    case 8:
      System.out.println("Agosto tiene 31 dias");
      break;
    case 9:
      System.out.println("Septiembre tiene 30 dias");
      break;
    case 10:
      System.out.println("Octubre tiene 31 dias");
      break;
    case 11:
      System.out.println("Noviembre tiene 30 dias");
      break;
    case 12:
      System.out.println("Diciembre tiene 31 dias");
      break;
    default:
      System.out.println("ERROR!!!, no has introducido un número entre el 1 y el 12");

  }

  }
  }

