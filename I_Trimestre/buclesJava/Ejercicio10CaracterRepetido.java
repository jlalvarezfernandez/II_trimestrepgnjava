package buclesJava;
/**
* Programa: Ejercicio10CaracterRepetido.java
*
* Proposito: 10. Pide una cadena y un carácter por teclado y 
* 				 muestra cuantas veces aparece el carácter en la cadena.
*

* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * cadena (cadena): almacenará la cadena introducida por teclado
 * caracter (cadena): alamcenará el caracter a buscar
 * contador (numérico): almacenará la cantidad de veces que se repite el caracter seleccionado, se inicia en 0
 * 
 * Algoritmo:
 * 
 * introducimos los datos por pantalla
 * creamos un ciclo for que recorra toda la cadena
 * condicional usando substring( que sirve para extraer una cantidad determinada de caracters de la cadena, 1 en este caso)
 * y si este caracter es igual que el caracter elegido cade vez que se repita se añadira un caracter al contador
 * mostramos los resultados
 */

 import java.util.Scanner;
 
 public class Ejercicio10CaracterRepetido {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    String cadena;
    String caracter;
    int contador = 0;
    


    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce una frase: ");
    cadena = sc.nextLine();

    System.out.println("Introduce un caracter: ");
    caracter = sc.nextLine();

    // Calculos
    
   for (int i=0 ; i<cadena.length(); i++) {
	   if (cadena.substring(i,i+1).equals(caracter)) {// substring sirve para extraer la cantidad de caracteres que queramos de la cadena
		   contador++;
	   }
   }
   System.out.println("El caracter " + caracter + " se repite " + contador + " veces");

   



    }
  }