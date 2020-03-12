package pruebasFunciones;

import java.util.Scanner;

import funcionesArrays.Arrays;

public class PruebasFuncionesArrays {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);

    int tamano;
    int maximo;
    int minimo;
    int numero;
    int posicion;
    
    

    System.out.println("Introduce el tamaño del array: ");
    tamano = sc.nextInt();

    System.out.println("Introduce el número minimo del array: ");
    minimo = sc.nextInt();

    System.out.println("Introduce el número maximo del array: ");
    maximo = sc.nextInt();
    int [] array = Arrays.generaArrayInt(tamano, maximo, minimo);

    Arrays.mostrarArray(array);
    System.out.println();
    
    System.out.println("El valor minimo es: " + Arrays.minimoArrayInt(array));
    System.out.println();
    System.out.println("El valor maximo es: " + Arrays.maximoArrayInt(array));
    System.out.println();
    System.out.println("La media de los valores del array es: " + Arrays.mediaArrayInt(array));
    System.out.println();
    System.out.println("Introduce un número para saber si esta en el array: ");
    numero = sc.nextInt();
    
    System.out.println("El número está en el array: " + Arrays.estaEnArrayInt(array, numero));
    System.out.println();
    System.out.println("Introduce un numero del array para saber cual es su posicion: " );
    posicion = sc.nextInt();
    System.out.println("La posicion de " + posicion + " es: " + Arrays.posicionEnArray(array, posicion));
    System.out.println("");
    System.out.println("El array volteado es: ");
    Arrays.mostrarArray(Arrays.volteaArrayInt(array));
    System.out.println();
    System.out.println("Array antes de rotar ");
    Arrays.mostrarArray(array);
    Arrays.rotaDerechaArrayInt(array, 2);
    System.out.println();
    System.out.println("Array despues de rotar 2 posiciones a la derecha: ");
    System.out.println("");
    Arrays.mostrarArray(array);
    System.out.println();
    Arrays.rotaIzquierdaArrayInt(array,2);
    System.out.println("Array despues de rotar 2 posiciones a la izquierda: ");
    Arrays.mostrarArray(array);


    
    
  }

}
