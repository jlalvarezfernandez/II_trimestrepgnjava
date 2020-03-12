package NumerosAleatorios;

/**
 * PROPOSITO: 5. Muestra 50 números enteros aleatorios entre 100 y 199 (ambos incluidos) separados por espacios. 
 *               Muestra también el máximo, el mínimo, la moda, la media, la mediana y la desviación típica de esos números.
 *
 *
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * FECHA: 25/11/2019
 * 
 * 
 * ANÁLISIS
 * --------
 * primero mostramos 50 números aleatorios entre 100 y 199
 * mostramos el maximo y el minimo
 * calculamos la media
 * calculamos la moda
 * calculamos la mediana: la mediana representa el valor de la variable de posición central en un conjunto de datos ordenados. Para calcularla:
 *                         – Ordenamos los datos de menor a mayor.
 *                         – Si la serie tiene un número impar de medidas la mediana es la puntuación central.
 *                         2, 3, 4, 4, 5, 5, 5, 6, 6 Me = 5
 *                         – Si la serie tiene un número par de puntuaciones la mediana es la media entre las dos puntuaciones centrales.
 *                         7, 8, 9, 10, 11, 12 Me = 9,5
 * calcular la desviacion tipica, para ello hay que calcular primero la varianza
 * 
 * 
 * VARIABLES
 * ----------
 * numAleatorios (entero): almacenará los 50 números aleatorios generados
 * maximo (entero): alamcenará el número maximo
 * minimo (entero): alamcenará el número minimo
 * media (entero): almacenará la media de los números
 */
public class Ejercicio05Calculos {
  static final int NUMEROSALEATORIOS = 50;


  public static void main(String[] args) {
    
    // Declaramos las variables
    
    
    int [] numeros = new int [50];
    
    int maximo = Integer.MIN_VALUE;
    
    int minimo = Integer.MAX_VALUE;
    
    int media = 0;
    
    int varianza = 0;
    
    
    
    
    
    // Calculos
    
    // generamos los 50 numeros aleatorios entre 100 y 199
    
    System.out.println("Los números aleatorios generados son:");

    
    for (int i = 0; i<numeros.length; i++) {
      
      numeros[i] = (int)(Math.random()*(199-100 + 1) +100);
      

      System.out.print(numeros[i] + " ");

      // calculamos el numero maximo

      if (numeros[i] > maximo) {

        maximo = numeros[i];

      }
      
      // calculamos el número mínimo

      if (numeros[i] < minimo) {

        minimo = numeros[i];

      }
      
      // calculamos la media
      
      media += (numeros[i]/50);
      
      // calculamos la mediana
      
      // calculamos la desviacion tipica
      
      // primero tenemos que calcular la varianza
      
     
      
      
      
      

    } 
    int sumaNotas = 0;
    for (int i = 0; i <NUMEROSALEATORIOS; i++) {
      sumaNotas += Math.pow(numeros[i]-media, 2);
    }
    varianza = sumaNotas/NUMEROSALEATORIOS;
    
    
    // Mostramos los resultados
    
    System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("RESULTADOS");
    System.out.println("EL número máximo es: " + maximo);
    System.out.println("El número minimo es: " + minimo);
    System.out.println("La media de los números es: " + media);
    System.out.println(varianza);


    
   

    
    
    
  }

}
