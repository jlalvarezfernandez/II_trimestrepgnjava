package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;

public class juntaNumeros {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    
    // variables
    
    int num1;
    
    int num2;
    
    
    // pedimos los datos
    
    System.out.println("Introduce el primer número: ");
    num1 = sc.nextInt();
    
    System.out.println("Introduce el segundo número: ");
    num2 = sc.nextInt();
    
    // resultados
    
    System.out.println("El número nuevo es: " + Varias.juntaNumeros(num1, num2));

  }

}
