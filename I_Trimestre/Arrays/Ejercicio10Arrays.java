package Arrays;

/**
 * Proposito: 10. Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100 y que los almacene en un array. 
 *                El programa debe ser capaz de pasar todos los números pares a las primeras posiciones del array (del 0 en adelante) y
 *                todos los números impares a las celdas restantes. Utiliza arrays auxiliares si es necesario.
 * 
 * 
 * @author José Luis Álvarez Fernández
 * Fecha: 21/11/2019
 * 
 * ANÁLISIS
 * ----------
 * primero tenemos que generar 20 numeros aleatorios entre 0 y 100 y almacenarlos en un array
 * nos creamos un array para los números pares
 * creamos otro array para los números impares
 * creamo un array ginal para introducir los números pares y después los impares
 * 
 * 
 * VARIABLES
 * -----------
 * num (entero): array que almacenará los 20 números aleatorios entre 0 y 100
 * pares (entero): array que almacenará los números pares
 * impares (entero): array que almacenará los números impares
 * arrayFinal (entero): array que almacenará los números pares al principio y después los impares
 */


public class Ejercicio10Arrays {

  public static void main(String[] args) {

    
    // Definimos las variables
    
    int [] num = new int[20];
    
    
    
    // Calculos
    
    // generamos 20 números aleatorios entre 0 y 100
    System.out.println("Array principal");
    for (int i= 0; i<num.length; i++) {
      
      num[i] = (int)((Math.random()*100-0)+1);
      
      System.out.print(num[i] +" ");
      
    }
    
    // creamos un array para guardar los números pares
    
    int [] pares = new int [20];
    int contadorPares = 0;
    System.out.println("\n--------------------------------------------------------------------");
    System.out.println("\nArray con los números pares");

    
    for (int i = 0; i<pares.length; i++) {
      
      if (num[i]%2 ==0) {
        System.out.print(num[i]+" ");
        pares[contadorPares] = num[i];
        contadorPares++;
      }
      
    }
    
// creamos un array para guardar los números impares
    
    int [] impares = new int [20];
    int contadorImpares = 0;
    System.out.println("\n--------------------------------------------------------------------");

    System.out.println("\nArray con los números impares");

    
    for (int i = 0; i<impares.length; i++) {
      if (num[i]%2 !=0) {
        System.out.print(num[i] + " ");
        impares[contadorImpares] = num[i];
        contadorImpares++;
      }
      
    }
    
    // cremos el array para mostrar los números pares al principio y después los impares
    
    int [] arrayFinal = new int [20];
    
    System.out.println("\n--------------------------------------------------------------------");

    System.out.println("\nArray con los números pares al principio e impares al final");
    
    for (int i =0;i<arrayFinal.length;i++) {
      
      System.out.print(pares[i]+ " ");
    }
}
}