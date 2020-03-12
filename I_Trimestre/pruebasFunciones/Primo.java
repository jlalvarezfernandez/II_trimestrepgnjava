package pruebasFunciones;

/**
 * 
 * programa para saber si un núemro es primo
 * 
 * @author AJFRU
 *
 */

import java.util.Scanner;

import matematicas.Varias;

public class Primo {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    int numero;
    
    System.out.println("Introduce un numero para saber si es primo: ");
    numero = sc.nextInt();
    
    if (Varias.esPrimo(numero)) {
      
      System.out.println("El número " + numero + " es primo");
      
    } else {
      
      System.out.println("El número " + numero + " No es primo");
    }
    
  
  
  
  }

}
