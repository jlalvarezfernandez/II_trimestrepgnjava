package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;

public class Voltea {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    int numero;
    
    System.out.println("Introduce un numero para darle la vuelta: ");
    numero = sc.nextInt();
    
    System.out.println("EL numero volteado es: "+ Varias.voltea(numero));
    
  }

}
