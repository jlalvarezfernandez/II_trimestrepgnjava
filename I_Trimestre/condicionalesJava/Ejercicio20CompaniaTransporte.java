package condicionalesJava;
/**
* Programa: Ejercicio20CompaniaTransporte.java
*
* Proposito: 20. Una compañía de transporte internacional tiene servicio en algunos países de 
*                América del Norte, América Central, América del Sur, Europa y Asia. 
*                El costo por el servicio de transporte se basa en el peso del paquete y la zona a la que va dirigido. 
*                Lo anterior se muestra en la tabla:
*
*                  ZONA	UBICACIÓN	COSTO/GRAMO
*                    1	América del Norte	24.00 euros
*                    2	América Central	20.00 euros
*                    3	América del Sur	21.00 euros
*                    4	Europa	10.00 euros
*                    5	Asia	18.00 euros
*                Parte de su política implica que los paquetes con un peso superior a 5 kg no son transportados, 
*                esto por cuestiones de logística y de seguridad. 
*                Realice un algoritmo para determinar el cobro por la entrega de un paquete 
*                o, en su caso, el rechazo de la entrega.
*
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * peso (entero): almacenará el peso del paquete
 * opcion (entero): almacenará la opcion elegida
 * 
 * Algoritmo:
 * LEER: peso, opcion
 * CALCULAR: switch con las diferentes opciones para motrar el precio      
 * 
 *  
 */

import java.util.Scanner;

public class Ejercicio20CompaniaTransporte {
  public static void main (String[] args) {

    Scanner sc = new Scanner (System.in);


    // Definimos las variables

    int peso;
    int opcion = 0;
    int precio;

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el peso del paquete que vas a enviar en gramos: ");
    peso = sc.nextInt();

    // Calculos

  if (peso > 5000) {
    System.out.println("ERROR, peso no permitido");
  } else {
    System.out.println("A continuacion apareceran las zonas de envio");
    
    System.out.println("------------------------------");
    System.out.println("ZONA	UBICACIÓN	     COSTO/GRAMO");
    System.out.println("1	América del Norte	24.00 euros");
    System.out.println("2	América Central	        20.00 euros");
    System.out.println("3	América del Sur	        21.00 euros");
    System.out.println("4	Europa	                10.00 euros");
    System.out.println("5	Asia	                18.00 euros"); 
    
    System.out.println("Elige una zona de envio del 1 al 5: ");
    opcion = sc.nextInt();
  }

  switch (opcion) {
    case 1:
    precio = peso * 24;
    System.out.println("Has elegido America del Norte y el precio a pagar por el envio será de: " + precio+ " euros");
    break;
    case 2:
    precio = peso * 20;
    System.out.println("Has elegido America Central y el precio a pagar por el envio será de: " + precio+ " euros");
    break;
    case 3:
    precio = peso * 21;
    System.out.println("Has elegido America del Sur y el precio a pagar por el envio será de: " + precio+ " euros");
    break;
    case 4:
    precio = peso * 10;
    System.out.println("Has elegido Europa y el precio a pagar por el envio será de: " + precio+ " euros");
    break;
    case 5:
    precio = peso * 18;
    System.out.println("Has elegido Asia y el precio a pagar por el envio será de: " + precio+ " euros");
    break;
    default:
    System.out.println("ERROR!!!, la zona de envio es incorrecta");
    break;

  }

  }
  }

