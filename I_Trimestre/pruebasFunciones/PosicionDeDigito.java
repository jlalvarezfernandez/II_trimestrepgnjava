package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;

public class PosicionDeDigito {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    
    int numero;
    int digito;
    
    System.out.println("Introduce un numero: ");
    numero = sc.nextInt();
    
    System.out.println("Introduce el digito a buscar: ");
    digito = sc.nextInt();
    
    System.out.println("La posicion del digito " + digito + " es: " + (Varias.posicionDeDigito(numero,digito)));
    
  }

}
