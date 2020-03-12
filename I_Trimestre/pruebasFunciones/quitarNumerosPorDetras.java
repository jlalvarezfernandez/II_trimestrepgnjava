package pruebasFunciones;

import java.util.Scanner;

import matematicas.Varias;

public class quitarNumerosPorDetras {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    // variables
    
    int num;
    int numQuitar;
    
    // pedimos los datos
    
    System.out.println("Introduce un número: ");
    num = sc.nextInt();
    
    System.out.println("Introduce el numero de digitos que vas a eliminar empezando por la derecha: ");
    numQuitar = sc.nextInt();
    
    // resultados
    
    System.out.println("El número menos los digitos eliminados es: " + Varias.quitaPorDetras(num, numQuitar));
    

  }

}
