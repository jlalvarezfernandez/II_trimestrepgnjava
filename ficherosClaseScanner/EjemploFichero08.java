package ficherosClaseScanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author AJFRU
 *
 */

import java.util.Scanner;
public class EjemploFichero08 {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    
    // definimos las variables
    
    String nombreFichero;
    
   
    
    try {
      
      BufferedReader br = new BufferedReader(new FileReader("numeros.txt"));
      String linea = br.readLine(); // asignamos a linea la primera fila del archivo
      int contador = 0;
      double suma = 0;
      
      while (linea != null) {
        
        suma += Double.parseDouble(linea);
        linea = br.readLine();
        contador++;
      }
      
      
      br.close();
      
      System.out.println("La media es " + suma / (double)contador);
      
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    }
  }
}
    
    
    

 
