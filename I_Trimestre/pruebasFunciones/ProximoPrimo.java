package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;

public class ProximoPrimo {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    
    int numero;
    
    System.out.println("Introduce un numero: ");
    numero = sc.nextInt();
    
      
      if (Varias.esPrimo(numero)) {
        
        System.out.println("El proximo número primo al número introducido es: " + Varias.siguientePrimo(numero));
        
        
      }
      
      
 
    

  }

}
