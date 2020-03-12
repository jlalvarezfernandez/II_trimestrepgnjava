package NumerosAleatorios;

/**
 * PROPOSITO: 2. Realiza un programa que vaya generando números aleatorios pares entre 0 y 100 y que no termine de generar números hasta que no saque el 24. 
 *               El  programa deberá decir al final cuántos números se han generado.
 *               
 *               
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * FECHA: 23/11/2019
 * 
 * 
 * 
 * ANÁLISIS
 * ----------
 * - Dividimos el análisis en tres partes:
 *   1º. generamos un número aleatorio dentro del bucle do-while
 *   2º. hacemos que los numeros aleatorios mostrados sean pares
 *   3º. contamos todos los números aleatorios pares que se generen hasta que aparezca el 24
 *   
 * VARIABLES
 * ----------
 * numAleatorio (entero): almacenará los números aleatorios generados
 * contador (entero): sumatorio de todos los números aleatorios generados
 * 
 * 
 * ALGORITMO
 * ----------
 * numAleatorio = 0
 * contador = 0;
 * HACER
 *     generar numAleatorio ((Math.random()*100+1);)
 *     SI numAleatorio%2 == 0
 *        LEER  numAleatorio
 *            incrementar el contador en 1
 * MIENTRAS (numAleatorio != 24)
 * ESCRIBIR contador
 * 
 */


public class Ejercicio02Aleatorio24 {

  public static void main(String[] args) {


    // Definimos las variables

    int numAleatorio = 0;

    int contador = 0;

    do {

      numAleatorio = (int) (Math.random()*100+1);  // generamos los números aleatorios

      if ( numAleatorio%2 == 0) {

        System.out.println(numAleatorio);

        contador++;
      }

    }while (numAleatorio != 24);

    // Mostramos los resultados por pantalla

    System.out.println("El total de números aleatorios generados ha sido de: " + contador );

  }
}

