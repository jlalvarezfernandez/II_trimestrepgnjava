package pruebasFunciones;


/**
 * programa para saber si un numero es capicua
 * 
 * @author AJFRU
 *
 */

import java.util.Scanner;
import matematicas.Varias;

public class Capicua {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
   
    int numero;
    
    System.out.println("Introduce un número para saber si es capicua: ");
    numero = sc.nextInt();
    
    
    if (Varias.esCapicua(numero)) {
      System.out.println("El número " + numero + " es capicua");
      
    } else {
      System.out.println("El número " + numero + " No es capicua");
    }

  }

}
