package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;

public class PosicionDigito {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    
    int numero;
    int posicion;
    
    System.out.println("Introduce un número: ");
    numero = sc.nextInt();
    
    System.out.println("Introduce la posicion que quiere ver del numero: ");
    posicion = sc.nextInt();
    
    System.out.println("la posicion " + posicion + " del numero " + numero +" es:" + Varias.digitoN(numero, posicion));
    
    
  }

}
