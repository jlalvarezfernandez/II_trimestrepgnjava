package Arrays;

/**
 * Proposito: 3. Escribe un programa que lea 10 números por teclado y que luego los muestre
                 en orden inverso, es decir, el primero que se introduce es el último en mostrarse
                 y viceversa.
                 
 * @author José Luis Álvarez Fernández
 * Fecha: 210/11/2019
 * 
 * 
 * ANÁLISIS
 * ----------
 *  - este programa se divide en dos partes:
 *    - primero tenemos que leer 10 nuemros por teclado
 *    - segundo tenemos que mostrar los números introducidos en orden inverso
 *    
 * VARIABLES
 * -----------
 * num (entero): almacenará los números introducidos por el usuario
 * 
 * 
 * ALGORITMO
 * -----------
 * num  // que lo crearemos como si fuera un array que recogera 10 datos
 * PARA i DESDE 0 HASTA 10
 *    LEER num[i]
 *    
 * PARA i DESDE num.lenght-1 HASTA 0
 *    LEER num[i]
 *    
 *
 */
import java.util.Scanner;
public class Ejercicio03Arrays {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    
    // definimos las variables
    
    int [] num = new int [10];
    
    // Calculos
    
    
        // bucle for que lea los 10 números introducidos por teclado 
    
    for (int i = 0; i<10; i++) {
      System.out.println("Introduce el valor del número " +(i+1) + ": ");
      num[i] = sc.nextInt();
    }
    
        // bucle for que va recorriendo el array al reves 
    
   for (int i=num.length-1; i>-1; i--) {
     System.out.println("ahora el valor de " + (i+1) + " es: "+ num[i]);

   }

  }

}
