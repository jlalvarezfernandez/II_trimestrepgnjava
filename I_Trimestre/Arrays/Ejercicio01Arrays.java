package Arrays;

/**
 * Proposito: 1. Define un array de 12 números enteros con nombre num y asigna los valores
 *               según la tabla que se muestra a continuación. Muestra el contenido de todos
 *               los elementos del array. ¿Qué sucede con los valores de los elementos que no
 *               han sido inicializados?
 * 
 * 
 * 
 * @author José Luis älvarez Fernández
 * Fecha 20/11/2019
 * 
 * 
 * ANÁLISIS
 * ----------
 * - Programa para introducir los datos mediante un array
 *   y nos vamos a encontrar datos del array vacios.
 *   Este ejercicio nos va  aserbvir para ver como trata un array un dato vacio de tipo entero
 * 
 * 
 * 
 * VARIABLES
 * ----------
 * num (entero): almacenará los datos del array
 
 * 
 * ALGORITMO
 * ----------
 * creamos el array de num con los datos facilitados
 * PARA i DESDE 0 HASTA 12
 *    LEER num[i]
 * FIN SI
 * 
 * 
 * 
 */

public class Ejercicio01Arrays {

  public static void main(String[] args) {
    
    
    // Definimos las variables
    
    int [] num = new int [12];  // declaramos el array que va a almacenar 12 datos
    
    
    // completamos el array con los datos facilitados del ejercicio
    
    num [0] = 39;
    num [1] = -2;
    num [4] = 0;
    num [6] = 14;
    num [8] = 5;
    num [9] = 120;

    
    // creamos el ciclo for para leer todos los datos del array
    
    for (int i = 0; i<num.length; i++) {
      
      // mostramos los resultados
      
      System.out.println("los valores del array son: " + i + " : " +  num[i]);
      
    }
    
    
    
    
    
    
    
    
    
    

  }

}
