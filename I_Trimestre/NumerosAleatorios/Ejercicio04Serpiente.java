package NumerosAleatorios;
/**
 * PROPOSITO: 4. Realiza un programa que pinte por pantalla una serpiente con un “serpenteo” aleatorio. 
 *               La cabeza se representará con el carácter @ y se debe colocar exactamente en la posición 13 (con 12 espacios delante). 
 *               A partir de ahí, el cuerpo irá serpenteando de la siguiente manera: 
 *                  se generará de forma aleatoria un valor entre tres posibles que hará que el siguiente carácter se 
 *                  coloque una posición a la izquierda del anterior, alineado con el anterior o una posición a la derecha del anterior. 
 *               La longitud de la serpiente se pedirá por teclado y se supone que el usuario introducirá un dato correcto.
 *               
 *               Ejemplo:
 *               Por favor, introduzca la longitud de la serpiente en caracteres contando la cabeza: 6
 *                                            @
 *                                            *
 *                                           *
 *                                            *
 *                                            *
 *                                             *
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * 
 * FECHA: 23/11/2019
 *
 *
 *ANÁLISIS
 *-----------
 *sabemos que la cabeza d ela serpiente se situa a 13 espacios
 * tenemos tres posibles posiciones para el cuerpo
 * generamos numeros alatorio entre 1 y 3
 * si el nuemro aleatorio es 1 impriira el cuerpo a 12 espacios, si es 2 a 13 espacios y si es 3 a 14 espacios
 *
 *
 * VARIABLES
 * ----------
 * longitud (entero): almacenará la longitud de la serpiente introducida por el usuario
 * serpenteo (entero): almacenará los nuemros aleatorios
 * 
 */
import java.util.Scanner;

public class Ejercicio04Serpiente {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Definimos las variables

    int longitud;
    
    int serpenteo =0;
    
    // Calculos

    System.out.println("Introduce la longitud de la serpiente: ");
    
    longitud = sc.nextInt();
    
    // la cabeza de la serpiente

    System.out.println("             @ ");
    
    // cuerpo de la serpiente

    for (int i = 0; i<longitud; i++) {
      
      serpenteo = (int)(Math.random()*3)+1;

      if (serpenteo == 1) {
        
        System.out.print("            * ");
        
      } else if (serpenteo == 2) {
        
        System.out.print("             *");
        
      } else {
        
        System.out.print("              *");
        
      }
      
      // Mostramos los resultados
      
      System.out.println();

    }

  }

}
