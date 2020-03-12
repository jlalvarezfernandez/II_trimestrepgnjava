package arraylistColecciones;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Escribe un programa que ordene 10 números enteros introducidos por teclado y almacenados en un objeto de la clase ArrayList.
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */


public class Ejercicio03 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner (System.in);
    
    // creamos el arraylist
    
    ArrayList<Integer> lista = new ArrayList<Integer>();
    
    // Pedimos al usuario que introduzca los datos por pantalla
    
    for (int i = 1; i <= 10; i++) {
      System.out.println("Introduce el número " + i + ": ");
      lista.add(sc.nextInt());
      
    }
    
    // mostramos la lista original
    
    System.out.println("Lista original de números " + lista);
    
    // asi ordenamos la lista de menor a mayor
    Collections.sort(lista);
    
    // mostramos la lista ordenada
    
    System.out.println("\nLista de números ordenados: ");
    for (int numero: lista) {
      System.out.println(numero);
    }
    

  }

}
