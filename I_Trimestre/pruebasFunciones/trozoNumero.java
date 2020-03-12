package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;

public class trozoNumero {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    int num;
    
    int posInicial;
    
    int posFinal;
    
    System.out.println("Introduce un numero: ");
    num = sc.nextInt();
    
    System.out.println("Introduce la posicion inicial: ");
    posInicial = sc.nextInt();
    
    System.out.println("Introduce la posicion final: ");
    posFinal = sc.nextInt();
    
    // resultados
    
    System.out.println("El nuevo nuemro es: " + Varias.trozoDeNumero(posInicial, posFinal, num));
    
    
    

  }

}
