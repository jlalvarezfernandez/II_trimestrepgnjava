package Arrays;

import java.util.Scanner;

/**
 * PROPOSITO: 6. Modifica el programa anterior de tal forma que no se repita ningún número en el array.
 * 
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * FECHA: 23/11/2019
 *
 */

public class Ejercicio06ArraysBidimensionales {

  public static void main(String[] args) {
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
    
    boolean repite;


    // creamos el array


    for (fila = 0; fila < 6; fila++) {
      
      for (columna = 0; columna < 10; columna++) {
        
        do {
          
          repite = false;
          
          numeros[fila][columna]= (int)(Math.random() * 1001);
          
          for (int i  = 0; i < fila; i++) {
            
            for (int j = 0; j < columna; j++) {
              
              if  (numeros[fila][columna] == numeros[i] [j]) {
                
                repite = true;
              }
              
            }
  
          }

        } while (repite);
        
        System.out.print(numeros[fila][columna] + " \t");

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
    
    System.out.println("La posición del array maximo es: [" + (filaMaxima+1)+ "," + (columnaMaxima+1)+ "] maximo: " + maximo);
    
    System.out.println("La posición del array minimo es: [" + (filaMinima+1)+"," + (columnaMinima+1) + "] minimo: " + minimo);
  }
  
}


