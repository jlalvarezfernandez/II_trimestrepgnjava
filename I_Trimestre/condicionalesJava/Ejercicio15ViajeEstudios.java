package condicionalesJava;
/**
* Programa: Ejercicio15ViajeEstudios.java
*
* Proposito: 15. El director de una escuela está organizando un viaje de estudios, 
*                y requiere determinar cuánto debe cobrar a cada alumno y cuánto debe pagar a la compañía de viajes por el servicio. 
*                La forma de cobrar es la siguiente: 
*                     si son 100 alumnos o más, el costo por cada alumno es de 65 euros; 
*                     de 50 a 99 alumnos, el costo es de 70 euros, 
*                     de 30 a 49, de 95 euros, 
*                     y si son menos de 30, el costo de la renta del autobús es de 4000 euros, sin importar el número de alumnos. 
*                Realice un algoritmo que permita determinar el pago a la compañía de autobuses y lo que debe pagar cada alumno 
*                por el viaje.
*
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 5/11/2019
*/

/**
 * Variables:
 * numAlumnos (double): almacenará el número de alumnos que van al viaje
 * precioAlumno (double): almacenará el dienro que pagará cada alumno por el viaje
 * precioViaje (double): almacenará la cantidad de dinerop que se le `pagará a la compañia
 * 
 * Algoritmo:
 * LEER: numAlumnos, precioAlumno, precioViaje
 * CALCULAR: calcular el precio del viaje (numalumnos / precioViaje)       
 * ESCRIBIR: precioAlumno, precioViaje
 *  
 */

import java.util.Scanner;

 public class Ejercicio15ViajeEstudios {
   public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables:

    double numAlumnos;
    double precioAlumno = 0;
    double precioViaje;
   
    

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce el número de alumnos que va  al viaje: ");
    numAlumnos = sc.nextDouble();
    
   
    // Calculos

  if (numAlumnos >= 100) {
    precioAlumno = 65;
    precioViaje = numAlumnos * 65;
    }
  else if (numAlumnos >= 50 ) {
    precioAlumno = 70;
    precioViaje = numAlumnos * 70;
  }
  else if (numAlumnos >= 30) {
    precioAlumno = 95;
    precioViaje = numAlumnos * 95;
  }
  else {
    precioViaje = 4000;
    precioAlumno = 4000 / numAlumnos;
  }
  
  System.out.println("Cada alumno pagara: " + precioAlumno + " euros, y a la compañia se le pagará: " + precioViaje + " euros");
  
  }
}