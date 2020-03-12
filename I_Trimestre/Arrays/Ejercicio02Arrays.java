package Arrays;

/**
 * Proposito: 2. Define un array de 10 caracteres con nombre simbolo y asigna valores a los
 *               elementos según la tabla que se muestra a continuación. Muestra el contenido
 *               de todos los elementos del array. ¿Qué sucede con los valores de los elementos
 *               que no han sido inicializados?
 *               
 * @author José Luis Álvarez Fernández
 * Fecha: 20/11/2019
 * 
 * ANÁLISIS
 * ----------
 * - Programa para introducir los datos mediante un array
 *   y nos vamos a encontrar datos del array vacios.
 *   Este ejercicio nos va a servir para ver como trata un array un dato vacio de tipo string
 * 
 * 
 * 
 * VARIABLES
 * ----------
 * simbolo (string): almacenará los datos del array
 
 * 
 * ALGORITMO
 * ----------
 * creamos el array de simbolo con los datos facilitados
 * PARA i DESDE 0 HASTA 11
 *    LEER simbolo[i]
 * FIN SI
 * 
 *
 */

public class Ejercicio02Arrays {

  public static void main(String[] args) {
    
    
    // definimos las variables
    
    char [] simbolo = new char [10];
    
    
    // rellenamos los datos proporcionados del array
    
    simbolo[0]= 'a';
    simbolo[1]= 'x';
    simbolo[4]= '@';
    simbolo[6]= ' ';
    simbolo[7]= '+';
    simbolo[8]= 'Q';

    
    // bucle for para recorrer el array
    
    for (int i = 0; i<10; i++) {
      System.out.println("el valor de la posición " + i + " del array es: " + simbolo[i]);
    }
    
        
    
    
   

  }

}
