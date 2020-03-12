package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;

public class Potencia {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    int base;
    int exponente;
    
    
    
    System.out.println("Introduce la base: ");
    base = sc.nextInt();
    
    System.out.println("Introduce el exponente: ");
    exponente = sc.nextInt();
    
    
    System.out.println("El resultado de la potencia es: " + Varias.potencia(base, exponente));

  }

}
