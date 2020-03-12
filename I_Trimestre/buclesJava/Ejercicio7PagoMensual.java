package buclesJava;
/**
* Programa: Ejercicio7PagoMensual.java
*
* Proposito: 7. Una persona adquirió un producto para pagar en 20 meses. 
*               El primer mes pagó 10 €, el segundo 20 €, el tercero 40 € y así sucesivamente. 
*               Realizar un programa para determinar cuánto debe pagar mensualmente 
*               y el total de lo que pagará después de los 20 meses.

* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * mes (numérico): almacenará los meses que dura el pago
 * pagoMensual (numérico): almacenará lo que pagará cada ma (el doble del mes anterior)
 * pagoTotal (numérico): almacenará lo que pagara despues de los 20 meses
 *
 * 
 * Algoritmo:
 * 
 * ciclo for que recorrera los 20 meses e ira incrementnado en uno cada iteracion hasta completar los 20 meses
 * el pago total es el sumatorio de lo que paga cada mes
 * el pago mensual sera la multiplicacion del doble de cada mes recorrido en el bucle
 * 
 */

 import java.util.Scanner;

 public class Ejercicio7PagoMensual {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    int pagoMensual = 10;
    int pagoTotal = 0;
    int mes = 0;
    
    for (mes = 1; mes <= 20 ; mes++) {
    	  System.out.println("El mes " + mes + " pagará: " + pagoMensual +  " euros");

    	pagoTotal += pagoMensual;
    	pagoMensual *=2;
    }
    System.out.println("pago total: " + pagoTotal + " euros");








   }
  }