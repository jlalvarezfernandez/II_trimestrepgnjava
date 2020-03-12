package pruebasFunciones;


import java.util.Scanner;

import matematicas.Varias;
public class Digitos {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    int cantidad;
    
    System.out.println("Introduce un numero para saber cuantos digitos tiene: ");
    cantidad = sc.nextInt();
    
    
    System.out.println("La cantidad de digitos que tiene el numero es de " + Varias.digitos(cantidad));
  

  }

}
