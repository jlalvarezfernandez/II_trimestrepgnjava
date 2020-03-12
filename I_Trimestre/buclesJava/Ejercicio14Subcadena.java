package buclesJava;
/**
* Programa: Ejercicio14Subcadena.java
*
* Proposito: 14. Realizar un programa que compruebe si una cadena contiene una subcadena. 
*                Las dos cadenas se introducen por teclado.
*
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * cadena (cadena): almacenará la cadena introducida por el usuario
 * subcadena (cadena): alamcenará la subcadena perteneciente al cadena principal que desa buscar el usuario
 * coincideSubcadena (boleano): alamcenara en principio flase, como si no existiese la subcadena en la cadena y comprabaremos si coincide o no
 * 
 * Algoritmo:
 * leemos los datos
 * bucle for que recorre la longitud de la cadena menos la longitud d ela cadena
 * esto sirve para comprobar cuantos caracteres ocupa la subcadena y a partir de ahi ir buscando si coincide el numero de caracteres de la subcadena
 * condicional if si cadena y usamos substring poara ir buscando coincidencias  de la longitus d ela cadena y son iguale sa ala longitud de la subcadena  
 * entonces coincideSubcadena será true
 * Mostramos los resultados
 *
 */

 import java.util.Scanner;
 public class Ejercicio14Subcadena {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    String cadena;
    String subcadena;
    boolean coincideSubcadena = false; //interruptor cuando es verdadero se deja de comprobar
   
    // Pedimos al usuario que introduzca los datos por pantalla

    System.out.println("Introduce una frase por pantalla: ");
    cadena = sc.nextLine();

    System.out.println("Introduce una subcadena: ");
    subcadena = sc.nextLine();
    
    // Calculos

    for (int i = 0; i<=cadena.length()-subcadena.length();i++) {
    	if  (cadena.substring(i,i+subcadena.length()).equals(subcadena)){
    		coincideSubcadena = true;
    	}
    }
    
    if (coincideSubcadena) {
	  System.out.println("La subcadena " + subcadena + " aparece en la frase " + cadena);
    } else {
    	System.out.println("La subcadena " + subcadena + " No aparece en la frase " + cadena);

    	
    }
  }
}