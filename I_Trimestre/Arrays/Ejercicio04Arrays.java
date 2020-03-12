package Arrays;

/**
 * Proposito: 4. Define tres arrays de 20 números enteros cada una, con nombres numero, cuadrado
 *               y cubo. Carga el array numero con valores aleatorios entre 0 y 100. 
 *               En el array cuadrado se deben almacenar los cuadrados de los valores que hay en el array numero. 
 *               En el array cubo se deben almacenar los cubos de los valores que hay en numero. 
 *               A continuación, muestra el contenido de los tres arrays dispuesto en tres columnas.
 *               
 * @author José Luis Álvarez Fernández
 * 
 * Fecha: 20/11/2019
 * 
 * 
 * ANÁLISIS
 * ---------
 * tenemos que declarar un array para guardar 20 numeros 
 * dentro de ese array tenemos que crear 20 numeros aleatorios para guardarlos en ese array
 * despues tenemos que declarar un array con esos numeros para levarlos al cuadrado
 * por ultimo tenemos declarar un array con esos numeros para elevarlos al cubo
 * finalmente tenemos que mostrar los tres arrays en tres columnas
 * 
 * 
 * VARIABLES
 * ----------
 * numero (entero): almacenará un array de 20 números
 * cuadrado (entero): almacenará un array con los 20 números del array números para elevarlos al cuadrado
 * cubo (entero): almacenará un array con los 20 números del array números para elevarlos al cubo
 * 
 
 *    
 * 
 *
 */
import java.util.Scanner;

public class Ejercicio04Arrays {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    
    // definimos las variables
    
    int [] numero = new int [20];
    int [] cuadrado = new int [20];
    int [] cubo = new int [20];
    
    
    
    
    // Calculos
    
    System.out.println("estos son los 20 números aleatorios creados: ");
    
    for (int i=0;i<numero.length;i++) {  // recorremos el array 20 veces
      numero[i] = (int) (Math.random()*100+1);  // generamos los números aleatorios
      System.out.println( numero[i]);  // imprimimos los 20 números aleatorios
    }
    
    System.out.println("estos son los 20 números aleatorios elevados al cuadrado: ");

    for (int i=0;i<cuadrado.length;i++) {  //recorremos el array 20 veces
      cuadrado[i] = (int) Math.pow(numero[i], 2);  // elevamos los numeros del array al cuadrado
      System.out.println(cuadrado[i]);  // imprimimos los 20 números elevado al cuadrado
      
    }
    System.out.println("estos son los 20 números aleatorios elevados al cubo: ");
    
    for (int i=0; i<cubo.length;i++) {  // recorremos el array 20 veces
      cubo[i] = (int) Math.pow(numero[i], 3);  // elevamos los numeros del array al cubo
      System.out.println(cubo[i]);  // imprimos los 20 numeros elvados al cubo
    }
    

  }

}
