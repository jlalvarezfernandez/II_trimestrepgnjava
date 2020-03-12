package secuencialesJava;
/**
* Programa: Ejercicio17Ciclista.java
*
* Proposito: 17. Un ciclista parte de una ciudad A a las HH horas, MM minutos y SS segundos. 
*                El tiempo de viaje hasta llegar a otra ciudad B es de T segundos. 
*                Escribir un algoritmo que determine la hora de llegada a la ciudad B.
*
*
*
* @author José Luis Álvarez Fernández
*
* Fecha: 4/11/2019
*/
/**
 * Variables:
 * horas (double): almacenará la hora de salida del ciclista.
 * minutos (double): almacenará los minutos de salida del ciclista
 * segundos (double): almacenará los segundos de salida del ciclista
 * segundosViaje (double): almacenará los segundos que dura el viaje 
 * tiempoSalida (numérica) : almacenará el tiempo de salida en segundos (tiempoSalida = ((hora * 3600) + (minutos * 60) + (segundos)))
 * tiempoTotal (numérica): almacenará el tiempo total del viaje (tiempoTotal = (tiempoSalida + segundosViaje))
 * horaLlegada (numérica): almacenará la hora de llegada ((tiempoTotal / 3600))
 * minutosLlegada (numérica): almacenará los minutos a los que llega ((tiempoTotal % 3600) / 60)
 * segundosLLegada (numérica): almacenará los segundos a los que llega ( (tiempoTotal % 3600) % 60
 * 
 * 
 * Algoritmo:
 * 
 * LEER: horas, minutos, segundos, segundosViaje
 * CALCULAR: 
 * ESCRIBIR: horaLlegada, minutosLlegada, segundosLlegada
 * 
 */


 public class Ejercicio17Ciclista {
   public static void  main(String[] args) {
     
    // Definimos las variables:

    String linea;
    int horas;
    int minutos;
    int segundos;
    int segundosViaje;
  
  

    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce la hora de salida del ciclista: ");
    linea = System.console().readLine();
    horas =Integer.parseInt(linea);

    System.out.println("Introduce los minutos de salida del ciclista: ");
    linea = System.console().readLine();
    minutos =Integer.parseInt(linea);

    System.out.println("Introduce los segundos de salida del ciclista: ");
    linea = System.console().readLine();
    segundos = Integer.parseInt(linea);

    System.out.println("Introduce los segundos que dura el viaje: ");
    linea = System.console().readLine();
    segundosViaje = Integer.parseInt(linea);

    // Calculos

   int tiempoSalida = ((horas * 3600) + (minutos * 60) + segundos);
   int tiempoTotal = tiempoSalida + segundosViaje;
   int horaLlegada = tiempoTotal / 3600;
   int minutosLlegada = (tiempoTotal % 3600) / 60;
   int segundosLLegada = (tiempoTotal % 3600) % 60;
  
   
    // Mostramos los resultados por pantalla

    System.out.println("El ciclista llegara a su destino a las " + horaLlegada + " horas " + minutosLlegada + " minutos y " + segundosLLegada + " segundos" );
    

   }
 }