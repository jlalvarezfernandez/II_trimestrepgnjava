package buclesJava;
/**
* Programa: Ejercicio9NumerosPrimos.java
*
* Proposito: 9. Mostrar en pantalla los N primero número primos. 
*               Se pide por teclado la cantidad de números primos que queremos mostrar.
*
* 
* @author José Luis Álvarez Fernández
*
* Fecha: 9/11/2019
*/

/**
 * Variables:
 * cantidad (numérico): almacenará la cantidad de números que el usuario ha introducido
 * 
 *
 * 
 * Algoritmo:
 * 1.- Leer cantidad de número primos a mostrar, debe ser positivo
   2.- Muestro el primer número primo, el 2.
   3.- Inicializo el contador de número mostrados a 1.
   4.- Inicializo la variable donde guardo el número a probar -> num=3
   4.- Mientras no haya mostrado la cantidad de número indicados
   5.- Considero que es primo. Inicializo el indicador -> esPrimo=Verdadero
   6.- desde el 3 hasta la raíz cuadrada del número
   7.- Si es divisible -> Ya no es primo -> esPrimo=Falso
   8.- Si es primo
   9.- Incremento el contador de números mostrados
   10.- Escribo el número primo
   11.- Como son impares, incremento en 2 el número a probar

 *  
 */

 import java.util.Scanner;
 
 public class Ejercicio9NumerosPrimos {
   public static void main(String []args) {

    Scanner sc = new Scanner (System.in);

    // Definimos las variables

    int cantidadNumIntroducir;
    int cantidadMostrados;
    int num;
    

    
    
    // Calculos
    
    // podemos hacer in ciclo while para comprobar que hemos introducido una cantidad superios a 0, si no volvemos a pedir una cnatidad de numeros
    
    do  {
      System.out.println("¿Cuantos números primos quieres que se muestren?: ");
      cantidadNumIntroducir = sc.nextInt();
    }while(cantidadNumIntroducir <=0);
    
    // el primer número primo es el 2, a partir de aqui todos los números primos son impares por lo que vamos comprobando desde 3
    //dividimos entre 3 y vamos incrementando la cantidad de numeros a mostrar
    // imprimimos el 2 que es el primer número primo
    
    System.out.println("1: es el 2 ");
    cantidadMostrados = 1;
    
    // comprobamos a partir del 3
    
    num = 3;
    
    while (cantidadMostrados <cantidadNumIntroducir) {
        // pienso que es primo hasta que encuentre con que dividirlo
      boolean esPrimo = true;
      // sabemos que es impar
    	
      // comprobamos si es primo
    	
      for (int divisor=3 ; divisor<= Math.sqrt(num) && esPrimo; divisor+=2) {
    	// si el resto de la division es 0
        if (num%divisor == 0) {
    	  //sabemos que no es primo
    	  esPrimo = false;
        }
      }
        if (esPrimo) {
    	  cantidadMostrados++;
    	  System.out.println(cantidadMostrados + ": es el " + num);
        }
        num+=2;
      }
      
    }

   }
 
    
   
  