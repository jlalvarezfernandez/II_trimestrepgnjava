package buclesJava;

/**
 * 
 * Proposito: programa que calcule la nota máxima, mínima, media y varianza
 * 			  de 10 notas introducidas por el usuario:
 *  
 *      * maximo
 *      * minimo
 *      * media:    sumatorio de las notas dividido entre el número total de notas
 *      * varianza: sumatorio de la diferencia de cada nota menos la media al cuadrado 
 *      			dividido por el número de notas
 * 
 * @author Álvarez Fernández Jose Luis
 * Fecha 19/11/2019
 * 
 * 
 * ANÁLISIS
 * --------------
 * - Este programa se dividie en dos partes:
 *   - primero: calcular la media, la nota máxima y la nota mínima.
 *   - segundo: calcular la varianza (necesitamos sacar la media primero)
 * 
 * VARIABLES
 * --------------
 * - notas: vector con las calificaciónes introducida por el ususario
 * - máximo: almacenará la nota máxima
 * - mínimo: almacenará la nota mínima
 * - media: almacenará la media de todas las notas
 * - sumaNotas: almacenará la suma de todas las notas
 * - i: contador ciclo
 * - varianza
 * 
 * ALGORITMO
 * -------------
 * sumaNotas = 0
 * máximo = 0
 * mínimo = 10
 * PARA i DESDE 1 HASTA 10
 * 	  LEER notas[i]
 * 	  SI notas > máximo ENTONCES
 * 			máximo = notas[i]
 * 	  FIN SI
 *    SI notas < mínimo ENTONCES
 *    		mínimo = notas[i]
 *    FIN SI
 *    sumaNotas = sumaNotas + nota[i]
 * FIN PARA
 * 
 * media = sumaNotas/10
 * 
 * sumaNotas = 0
 * PARA i DESDE 1 HASTA 10  // (en lenguaje de programacion es de 0 a 9)
 *    sumaNotas = sumanotas + (nota[i]-media)2
 * FIN PARA
 * varianza = sumaNotas/10
 * 
 * ESCRIBIR máximo, mínimo. media, varianza
 *
 */

import java.util.Scanner;

public class EjercicioVarianza {
	
	// CONSTANTE
	
	static final int NUMERONOTAS = 10;
	static final String ROJO = "\u001B[31m";
	static final String NORMAL = "\u001B[0m";
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		
    // VARIABLES
		
		double[] notas; // array o vector de nota
		notas = new double[NUMERONOTAS];  // creamos un array y reservamos espacio para 10 elementos
		double sumaNotas = 0;
		double media = 0;
		double maximo = 0; //-Double.MAX_VALUE;  // nota máxima
		double minimo = 10;  //Double.MAX_VALUE;  // nota mínima
		double varianza;
		
	
	// PROCESO PRIMERA PARTE
		
	   for (int i = 0; i<NUMERONOTAS; i++) {
		   // pedir nota entre 0 y 10
	     System.out.println("Introduce la nota del alumno " + (i+1) + " : ");
	     notas[i] = sc.nextDouble();
	     while (notas[i] < 0 || notas[i] > 10) {
	       System.out.println(ROJO + "Me has dado una nota erronea, vuelve a introducirla (nota entre 0 y 10): " + NORMAL);
	       notas[i] = sc.nextDouble();
	     }
	     // Actualizar los datos intermedios: sumatorio, máximo y mínimo
	    
	     //máximo
	     
	     if (notas[i] > maximo) {
	    	 maximo = notas[i];
	     }
	     // mínimo
	     if (notas[i] < minimo) {
	    	 minimo = notas[i];
	     }
	     sumaNotas += notas[i]; 
	   }
	   media = sumaNotas/NUMERONOTAS; 
	   
	   
	 // PROCESO SEGUNDA PARTE
	   
	   sumaNotas = 0;
	   for (int i = 0; i < NUMERONOTAS; i++) {
	     sumaNotas += Math.pow(notas[i]-media, 2);
	   }
	   varianza = sumaNotas/NUMERONOTAS;

	   
	 // MOSTRAMOS LOS RESULTADOS
	   System.out.println("\nRESULTADOS");
	   System.out.println("----------");
	   System.out.println("La nota máxima es: " + maximo);
	   System.out.println("La nota mínima es: " + minimo);
	   System.out.println("La nota media es: " + media);
	   System.out.println("La varianza es: " + varianza);
	}
}
