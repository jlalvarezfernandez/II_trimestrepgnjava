package Arrays;

/**
 * PROPOSITO:   8. Realiza un programa que pida 8 números enteros y que luego muestre esos números junto con la palabra “par” o “impar” según proceda.
 * @author AJFRU
 *
 */

import java.util.Scanner;

public class Ejercicio09LibroJava {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    // definimos el array
    
    int [] numeros = new int [8];
    
    for (int i = 0; i < numeros.length; i++) {
      System.out.println("Introduce un número: ");
      numeros[i] = sc.nextInt();
    }
    
    for (int i = 0; i < numeros.length; i++) {
      if (numeros[i] % 2 == 0) {
        System.out.println(numeros[i] + " PAR");
      } else {
        System.out.println(numeros[i] + " IMPAR");

        
      }
    }
    
    

  }

}
