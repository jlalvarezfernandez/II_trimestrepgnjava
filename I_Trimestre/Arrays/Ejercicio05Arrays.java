package Arrays;

/**
 * Proposito: 5. Escribe un programa que pida 10 números por teclado y que luego muestre los números introducidos 
 *               junto con las palabras “máximo” y “mínimo” al lado del máximo y del mínimo respectivamente.
 *               
 *               
 * @author José Luis Álvarez Fernández
 * fecha: 23/11/2019
 * 
 * ANÁLISIS
 * ---------
 * Primero tenemos que introducir 10 números por teclado
 * al imprimir los números por pantalla debemos mostrar la palabra maximo junto al número mas alto introducido y
 * la palabra mínimo junto al número mas bajo introducido.
 * 
 * 
 * VARIABLES
 * ----------
 * - numeros (entero): array que almacenará 10 números introducidos por teclado
 * - maximo (entero): almacenará el número más alto introducido
 * - minimo (entero): almacenará el número mas bajo introducido
 * 
 * ALGORITMO
 * ----------
 * PARA i DESDE 0 HASTA longitud de numero
 *      LEER numero[i]
 * PARA i DESDE 0 HASTA longitud de numero
 *    SI numero[i]<minimo
 *       minimo = numero[i]
 *    SI numero[i]>maximo
 *       maximo = numero[i]
 * PARA i DESDE 0 HASTA longitud de numero
 *    SI numero[i] == maximo
 *       ESCRIBIR numero[i] + "maximo"
 *    SI numero[i] == minimo
 *       ESCRIBIR numero[i] + "minimo"
 *    SI numero[i] != maximo || numero[i]!= minimo
 *       ESCRIBIR numero[i]
 * 
 *
 *
 */
import java.util.Scanner;
public class Ejercicio05Arrays {

  public static void main(String[] args) {

    Scanner sc = new Scanner (System.in);

    // declaramos las variables

    int numero[] = new int [10];
    int maximo = Integer.MIN_VALUE;  // nota máxima
    int minimo = Integer.MAX_VALUE;  // nota mínima



    for (int i = 0; i < numero.length;i++) {

      System.out.println("Introduce el numero " + (i+1) + ":");
      numero[i]= sc.nextInt();

    }

    for (int i = 0; i < numero.length;i++) {

      if (numero[i]> maximo) {
        maximo = numero[i];
      }
      if  (numero[i]< minimo) {
        minimo = numero[i];
      }


    }


    for (int i = 0; i < numero.length; i++) {

      if(numero[i]==maximo) {
        System.out.println(numero[i] + " MÁXIMO");
      }
      if (numero[i] == minimo) {
        System.out.println(numero[i] + " MNIMO");
      }
      if (numero[i]!= maximo && numero[i]!= minimo){
        System.out.println(numero[i]);

      }

    }

  }

}
