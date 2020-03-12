package condicionalesJava;
/**
* Programa: Ejercicio16CompañiaTelefonica.java
*
* Proposito: 16. La política de cobro de una compañía telefónica es: 
*                cuando se realiza una llamada, el cobro es por el tiempo que ésta dura, 
*                de tal forma que los primeros cinco minutos cuestan 1 euro,
*                los siguientes tres, 80 céntimos, 
*                los siguientes dos minutos, 70 céntimos, 
*                y a partir del décimo minuto, 50 céntimos. 
*                Además, se carga un impuesto de 3 % cuando es domingo, 
*                y si es otro día, en turno de mañana, 15 %, y en turno de tarde, 10 %. 
*               Realice un algoritmo para determinar cuánto debe pagar por cada concepto una persona que realiza una llamada.
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

public class Ejercicio16CompañiaTelefonica {
  public static void main (String[] args) {

    Scanner sc = new Scanner (System.in);


    // Definimos las variables

    double minLlamada;
    double precioLlamada = 0;
    char domingo;
    char turno = ' ';
    char dia;
    double coste = 0;
    double impuesto = 0;
    double precioFinal = 0;


    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce los minutos que dura la llamada: ");
    minLlamada = sc.nextDouble();

    // Calculos

    if (minLlamada < 5) {
      precioLlamada = minLlamada * 1;
    }
    else if (minLlamada >5 || minLlamada <=8) {
      precioLlamada = minLlamada - 5 * 0.80 + 5;
    }
    else if (minLlamada > 8 || minLlamada <= 10) {
      precioLlamada = minLlamada - 8 * 0.70 + 7.40;
    }
    else {
      precioLlamada = minLlamada - 10 * 0.50 + 8.80;
    }

  System.out.println("¿La llamada se produce en domingo (S/N): ?");
  domingo = sc.next().charAt(0);

  if (domingo =='N' || domingo == 'n') {
    System.out.println("Como es un dia diferente a domingo, ingresa un turno de mañana o tarde (M/T)?: ");
    dia = sc.next().charAt(0);
  }
  if (domingo =='S' || domingo =='s'){
    precioLlamada += precioLlamada * 0.03;
  }
  else if (turno == 'M' || turno =='m'){
    precioLlamada += precioLlamada *0.15;
  }
  else if (turno == 'T' || turno == 't') {
    precioLlamada += precioLlamada*0.10;
  }

// Mostramos los resultados por pantalla
 
System.out.println("El precio de la llamada es de: " +  precioLlamada+  "euros");
    }

  }


