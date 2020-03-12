package buclesJava;
/**
*Programa: Ejercicio1Aleatorio.java
*
* Proposito: 1. Crea una aplicación que permita adivinar un número. 
*               La aplicación genera un número aleatorio del 1 al 100. 
*               A continuación va pidiendo números y va respondiendo si el número a adivinar es mayor o menor que el introducido,
*               además de los intentos que te quedan (tienes 10 intentos para acertarlo). 
*               El programa termina cuando se acierta el número (además te dice en cuantos intentos lo has acertado), 
*               si se llega al limite de intentos te muestra el número que había generado.
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 1/11/2019
*/

/**
 * Variables:
 *   numAleatorio (númerica): almacenará el número aleatorio (numAleatorio = (int)(Math.random()*100 +1);)
 *   numIntroducido (numérico): almacenará el número a adivinar
 *   intentos (numérica): almacenará los intentos que llevamos para adivinar el número, inicializada a 0 porque todavia no hemos ingresado nungún número
 *   intentosMaximos (numérica): constante inicializada en 10 para saber los intentos que nos quedan
 * 
 * 
 * Algoritmo:
 * 
 * mientras el número Introducido sea diferente al número Aleatorio pedimos números 
 * incrementamos el contador en 1
 * si el número introducido es menor o mayor que el número aleatorio volvemos a pedir números
 * si el número introducido es igual que el aleatorio o los intentos son 10 terminamos
 * 
 * si hemos certado mostramos el número y los intentos que nos ha costado adivinarlo
 * si hemos agotado los 10 intentos mostramos el núemro aleatorio
 * 
 * 
 * 
 */
import java.util.Scanner;

 public class Ejercicio1Aleatorio {
   public static void main(String[] args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    int numAleatorio = (int)(Math.random()*100 +1);
    int numIntroducido;
    int intentos = 0;

    // constante
    int intentosMaximos = 10;

    // Proceso
    
    do {
      System.out.println("Te quedan " + (intentosMaximos-intentos) + " Introduce un número entre 1 y 100: ");
      numIntroducido = sc.nextInt();
      intentos++;
        if (numIntroducido > numAleatorio) {
    	  System.out.println("El número introducido es mayor que el número aleatorio");
    	} else {
    	  System.out.println("El número introducido es menor que el número aleatorio");
    	  }
    	if (numIntroducido == numAleatorio || intentos == intentosMaximos) { //acabo si adivino el número o supero los intentos
    	  break;
    	}
     } while (numIntroducido != numAleatorio);

    	// Mostramos los resultados

     if (numIntroducido == numAleatorio){
       System.out.println("Has adivinado el número en " + intentos + " intentos");
     } else {
       System.out.println("Has agotado el número máximo de intentos. El número a adivinar era: " + numAleatorio);
     }
}
 }