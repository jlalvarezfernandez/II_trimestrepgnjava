package Arrays;

/**
 * Proposito: 2. Escribe un programa que pida 20 números enteros. Estos números se deben introducir en un array de 4 filas por 5 columnas. 
 *               El programa mostrará las sumas parciales de filas y columnas igual que si de una hoja de cálculo se tratara. 
 *               La suma total debe aparecer en la esquina inferior derecha.
 * 
 * 
 * @author José Luis Álvarez fernández
 * fecha: 24/11/2019
 * 
 * ANÁLISIS
 * ---------
 * rellenamos el array de 4 filas y 5 columnas con 20 números pedidos por teclado
 * mostramos el array por pantalla
 * calculamos la suma parcial de las filas, recorriendo el array y sumando los valores de cada fila
 * calculamos la suma parcial de las columnas, recorriendo el array y sumando los valores de cada columna
 * sumamos el total de todas las columnas que es la misma suma que la de las filas
 * mostramos los resultados por pantalla
 * 
 * 
 * 
 * VARIABLES
 * ----------
 * numeros (entero): array que almacenará los 20 números por teclado
 * fila (entero): recorrerá cada fila del array
 * columna (entero): recorrerá cada columna del array
 * sumaParcialFila (entero) almacenará la suma de cada fila
 * sumaParcialColumna (entero) almacenará la suma de cada columna
 * sumaTotal (entero): almacenará la suma total de las columnas
 *
 */

import java.util.Scanner;

public class Ejercicio02ArraysBidiminsionales {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);


    // Definimos las variables

    int [][] numeros = new int [4][5];

    int fila;

    int columna;


    // Introducimos los 20 números dentro del array bidimensional

    System.out.println("Introduce los 20 números : ");

    for (fila = 0; fila < 4; fila++) {

      for (columna = 0; columna < 5; columna++) {

        System.out.print("Fila " + (fila+1) + " Columna " + (columna+1) + " : ");

        numeros[fila][columna] = sc.nextInt();
      }
      System.out.println();

    }
    
    // calculamos la suma parcial de las columnas

    for (fila = 0; fila < 4; fila++) {

      int sumaParcialColumna = 0;

      for (columna = 0; columna < 5; columna++) {

        System.out.print(numeros[fila][columna] + " \t");

        sumaParcialColumna += numeros[fila][columna];
      }

      System.out.print(sumaParcialColumna);

      System.out.println();
    }
    
    // calculamos la suma parcial de las filas
    
    int sumaTotal =0;

    for (columna = 0; columna < 5; columna++) {

      int sumaParcialFila = 0;


      for (fila = 0; fila < 4; fila++) {

        sumaParcialFila += numeros[fila][columna];

      }
      System.out.print(sumaParcialFila +" \t");
      
      // calculamos al suma total

      sumaTotal += sumaParcialFila;

    }

    System.out.println(sumaTotal + " ");


  }
}


