package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;


public class añadeDigito {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    // variables
     int numero;
     
     int numAnadido;
     
     // pedimos los datos
     
     System.out.println("Introduce un numero: ");
     numero = sc.nextInt();
     
     System.out.println("Introduce un numero a añadir: ");
     numAnadido = sc.nextInt();
     
     // resultados
     
     System.out.println("La nueva palabra es: " + Varias.pegaPorDetras(numero, numAnadido));

  }

}
