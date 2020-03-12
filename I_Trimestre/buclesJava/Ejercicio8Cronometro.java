package buclesJava;
/**
* Programa: Ejercicio8Cronometro.java
*
* Proposito: 8. Hacer un programa que muestre un cronometro, indicando las horas, minutos y segundos.
*
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * hora (numérico): almacenará las horas
 * minutos (numérico): almacenará los minutos 
 * segundos (numérico): almacenará los segundos 
 *
 * 
 * Algoritmo:
 * 
 * ciclo for para recorrer las horas, de 0 a 24 horas
 * ciclo for apra recorrer los minutos de 0 a 60 minutos
 * ciclo for para recorrer los segundos de 0 a 60 segundos
 * 
 */



 import java.util.concurrent.TimeUnit;

 public class Ejercicio8Cronometro {
   public static void main(String []args) throws InterruptedException {


    // Definimos las variables

    int horas = 0;
    int minutos = 0;
    int segundos = 0;
    String borrar = "\b\b\b\b\b\b\b\b";
   

    for (horas = 0; horas <= 23; horas++){
      for (minutos = 0; minutos <60; minutos++){
        for (segundos = 0; segundos <60; segundos++) {
       	  System.out.printf("%02d:%02d:%02d",horas,minutos,segundos);
       	  TimeUnit.SECONDS.sleep(1);
       	  System.out.print(borrar);
      }
     }
    }
   }
 }