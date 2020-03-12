package buclesJava;
/**
* Programa: Ejercicio13MayusculasMinusculas.java
*
* Proposito: 13. Realizar un programa que lea una cadena por teclado y convierta las mayúsculas a minúsculas 
* y viceversa.
*

* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * 
 * cadena (cadena): almacenará la cadena ingtroducida por el usuario
 * caracter (cadena): alamcenará todos losc aracteres de la cadena
 * invertida (cadena): almacenará la cadena invertida entre mayuscylas y minusculas
 * 
 * Algoritmo:
 * introducimos los datos por pantalla
 * bucle for para recorrer lamlongitud de la cadena
 * usamos la variable caracter para ir buscando cada uno d elos caracteres de la cadena
 * condicional si el caracter de la cadena es igual a un caracter escrito en mayusculas entonces en invertida lo pasamos a minuscula
 * si no , significa que esta en minusculas y tenmos que paesarlo a la variable invertida como un caracter mayusculo
 * mostramos los resultados por pantalla 
 */

 import java.util.Scanner;


 public class Ejercicio13MayusculasMinusculas {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    String cadena;
    String caracter;
    String invertida = "";

  
    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce una frase por pantalla: ");
    cadena = sc.nextLine();


    // Calculos
    
    for (int i = 0; i<cadena.length();i++) {
    	caracter = cadena.substring(i,i+1);// caracter esta debtro d ela cadena que va buscando uno a uno cada caracter
    	if (caracter.equals(caracter.toUpperCase())) { // si el caracter es igual a una mayuscula 
    		invertida += caracter.toLowerCase();// lo almacenaremos en la cadena invertida como minuscula
    	} else {
    		invertida +=caracter.toUpperCase();// si no lo alamcenaremos como una minuscula
    	}
    }
    System.out.println("La cadena escrita de mayusculas a minusculas o viceversa es: " + invertida);
    
     
    }
  }