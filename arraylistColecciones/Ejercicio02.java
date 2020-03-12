package arraylistColecciones;

/**
 * Realiza un programa que introduzca valores aleatorios (entre 0 y 100) en un ArrayList 
 * y que luego calcule la suma, la media, el máximo y el mínimo de esos números. 
 * El tamaño de la lista también será aleatorio y podrá oscilar entre 10 y 20 elementos ambos inclusive.
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

import java.util.Scanner;
import java.util.ArrayList;


public class Ejercicio02 {
  
  // creamos una variables estatica para los numeros aleatorios creados
  

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    
    // definimos las variables
    
    int suma = 0;
    int media = 0;
    int maximo = 0;
    int minimo =100;
    int tamano = (int)(Math.random() * (20-10)+10);
    
    
    // creamos el arrayList
    
    ArrayList<Integer> lista = new ArrayList<Integer>();
    
    // bucle for que genera los numeros aleatorios del 0 al 100 de una longitud de entre 10 y 20 numeros.
    
    for (int i = 0; i < tamano; i++) {
      lista.add((int)(Math.random()*101));
    }
    
    // Mostramos los num aleatorios
    
    System.out.println("Los cantidad de números aleatorios generados son: " + lista.size());
    System.out.println("Los numeros aleatorios generados son: " + lista);
    
    // Calculos para mostrar la suma
        
    for (int numero : lista) {
      suma += numero;

    }  
    
    // calculos para mostrar la media
    
    for (int numero : lista) {
      media = suma/tamano;
    }
    
    // Calculos apra mostrar el número maximo
    
    for (int numero : lista) {
      if (numero > maximo) {
      maximo = numero;
      }
    }
    
    // calculos apra mostrar el numero minimo
    
    for (int numero : lista) {
      if (numero < minimo) {
      minimo = numero;
      }
    }
    
    System.out.println("La suma de los números es: " + suma);
    System.out.println("La media los números es: " + media);
    System.out.println("El número maximo es: " + maximo);
    System.out.println("El número minimo es: " + minimo);


/////////////////////////////////////////////////////////////////////////////////
    /**
     * 
     */


    

    
    
    
    
    
   
    
    
     
    
    
  }

  }


