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
 * - el array se va rellenando de numeros aleatorios
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
 *        LEER numeros[fila][columna] = (int)(Math.random() * 1001)
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

public class EjercicioArrays5BidimensionalesV2 {

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


    for (fila = 0;fila<6;fila++) {
      
      for (columna = 0;columna<10;columna++) {
        
        numeros[fila][columna]= (int)(Math.random() * 1001);
        
        System.out.print(numeros[fila][columna] + "  \t");
        
        if (numeros[fila][columna]<minimo) {
          
          minimo = numeros[fila][columna];
          
          filaMinima = fila;
          
          columnaMinima = columna;
        }
        if (numeros[fila][columna]>maximo) {
          
          maximo = numeros[fila][columna];
          
          filaMaxima = fila;
          
          columnaMaxima = columna;
        }
      } 
      System.out.println();

    }
    System.out.println();
    
    System.out.println("La posición del array maximo es: [" + filaMaxima+"," + columnaMaxima+ "] maximo: " + maximo);
    
    System.out.println("La posición del array minimo es: [" + filaMinima+"," + columnaMinima + "] minimo: " + minimo);
  }
}


