package Arrays;

/**
 * PROPOSITO: 5. Realiza un programa que rellene un array de 6 filas por 10 columnas con números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). 
 *               A continuación, el programa deberá dar la posición tanto del máximo como del mínimo.
 * 
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * FECHA: 23/11/2019
 * 
 * ANÁLISIS
 * -------------
 * - creamos un array bidimensional de 6 filas y 10 columnas para almacenar números entre 0 y 1000
 * - vamos introduciendo los números según la fila y columna correspondiente, si el número introducido es menor que 0 o mayor que 1000 se vuelve a pedir
 * - debemos mostrar la posicion del numero mas alto introducido y del mas bajo.
 * 
 * 
 * 
 * VARIABLES
 * -----------
 * numeros (entero): array bidimensional  de 6 filas y 10 columnas que almacenará los números.
 * fila (entero): almacenará los números correspondientes a la posicion de la fila
 * columna (entero): almacenará los números correspondientes a la posición de la columna
 * maximo (entero): almacenará el número mas alto introducido
 * minimo (entero): almacenará el numero mas bajo ontroducido
 * filaMaxima (entero): almacenará la posicion de la fila con el número maximo
 * filaMinima (entero): almacenará la posicion de la fila con el número minimo
 * columnaMaxima (entero): almacenará la posicion de la columna con el número maximo
 * 
 * 
 * 
 * ALGORITMO
 * -----------
 * int [][] numeros = new int [6][10]
 * fila=0;
 * columna=0;
 * PARA fila HASTA fila<6
 *     PARA columna HASTA columna<10
 *        LEER numeros[fila][columna]
 *     MIENTRAS numeros[fila][columna]<0 || numeros[fila][columna]>1000
 *        LEER numeros[fila][columna]
 *  SI numeros[fila][columna] == maximo
 *      maximo == numeros[fila][columna]
 *      filaMaxima == fila
 *      columnaMaxima == columna
 *  SI numeros[fila][columna] == minimo
 *      minimo == numeros[fila][columna]
 *      filaMinima == fila
 *      columnaMinima == columna
 *  ESCRIBIR filaMinima,columnaMinima
 *  ESCRIBIR filaMaxima, columnaMaxima
 *  

 * 
 */

import java.util.Scanner;

public class Ejercicio05ArraysBidimensionalesV1 {

  public static void main(String[] args) {

    Scanner sc = new Scanner (System.in);

    // definimos las variables

    int fila=0;
    
    int columna = 0;
    
    int [][] numeros = new int [6][10];
    
    int maximo = Integer.MIN_VALUE;
    
    int minimo = Integer.MAX_VALUE; 
    
    int filaMaxima = 0;
    
    int filaMinima = 0;
    
    int columnaMaxima = 0;
    
    int columnaMinima = 0;


    // creamos el array

    System.out.println("Introduce números hasta completar el array");

    for (fila = 0;fila<6;fila++) {
      
      for (columna = 0;columna<10;columna++) {
        
        numeros[fila][columna] = (int)(Math.random()*(1001));
        
        
        

        
        while (numeros[fila][columna]<0 || numeros[fila][columna]>1000) {
          
          System.out.println("Debes introducir un número entre 0 y 1000");
          
          System.out.print("Fila " + (fila+1) + " Columna " + (columna+1) + ": ");
          
          numeros[fila][columna]= sc.nextInt();
          
          System.out.print(numeros[fila][columna] + "  \t");

                    
        }
        
        // calculamos el valor minimo del array

        if (numeros[fila][columna]<minimo) {
          
          minimo = numeros[fila][columna];
          
          filaMinima = fila;
          
          columnaMinima = columna;
        }
        
        // calculamos el valor maximo del array
        
        if (numeros[fila][columna]>maximo) {
          
          maximo = numeros[fila][columna];
          
          filaMaxima = fila;
          
          columnaMaxima = columna;
        }
        
      } 
      
      System.out.println();
      
      
    }
    // mostramos el array por pantalla
    
    for (int i = 0; i < fila; i++) {
      for (int j = 0; j < columna; j++) {
        System.out.print(numeros[i][j] + "\t ");

      }
      System.out.println();

    }
    
    // Mostramos los resultados por pantalla
    
    System.out.println();
    
    System.out.println("La posición del array maximo es: [" + (filaMaxima+1) + "," + (columnaMaxima+1) + "] maximo: " + maximo);
    
    System.out.println("La posición del array minimo es: [" + (filaMinima+1)+ "," + (columnaMinima +1) + "] minimo: " + minimo);
    
  }
}

