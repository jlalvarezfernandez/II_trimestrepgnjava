package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;

public class añdeDigitoPorDelante {

  public static void main(String[] args) {
    
    
    Scanner sc = new Scanner (System.in);
    
    int num;
    
    int numAnadir;
    
    System.out.println("Introduce un número: ");
    num = sc.nextInt();
    
    System.out.println("Introduce un digito a añadir por delante: ");
    numAnadir = sc.nextInt();
    
    System.out.println("El digito nuevo es: " + Varias.pegaPorDelante(num, numAnadir));
    
  }

}
