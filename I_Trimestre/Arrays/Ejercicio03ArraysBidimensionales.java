package Arrays;

/**
 * PROPOSITO: 3. Modifica el programa anterior de tal forma que los números que se introducen en el array 
 *               se generen de forma aleatoria (valores entre 100 y 999).
 * 
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * FECHA: 23/11/2019
 * 
 *
 */

public class Ejercicio03ArraysBidimensionales {

  public static void main(String[] args) {
    
    // definimos las variables
    
    int fila;
    int columna;
    int [][] numeros = new int [4][5];
    
    // Calculos
    
    // Introducimos los 20 números dentro del array bidimensional
    
   for (fila = 0; fila<4;fila++) {
     
     for (columna = 0; columna<5;columna++) {
       
       numeros[fila][columna] = (int) (Math.random()*(999-100 + 1) + 100);
     }
     
   }
   
   for (fila = 0; fila < 4; fila++) {

     int sumaParcialColumna = 0;

     for (columna = 0; columna < 5; columna++) {

       System.out.print(numeros[fila][columna] + " \t");

       sumaParcialColumna += numeros[fila][columna];
     }

     System.out.print(sumaParcialColumna);

     System.out.println();
   }
   int sumaTotal =0;

   for (columna = 0; columna < 5; columna++) {

     int sumaParcialFila = 0;
     

     for (fila = 0; fila < 4; fila++) {

       sumaParcialFila += numeros[fila][columna];

     }
     System.out.print(sumaParcialFila +" \t");
     
     sumaTotal += sumaParcialFila;

   }
   
   System.out.println(sumaTotal + " ");

  }

}
