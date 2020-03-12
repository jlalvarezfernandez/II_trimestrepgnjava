package ficherosClaseScanner;

/**
 * 
 * @author AJFRU
 *
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class EjemploFichero02 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner (System.in);
    
    BufferedWriter bw = new BufferedWriter(new FileWriter("fruta.txt"));
    
    try {
      
      for (int i = 1; i <= 3; i++) {
        System.out.println("Introduce el nombre de la fruta: ");
        bw.write(sc.nextLine() + "\n");
      }
      
      bw.close();
      
    } catch (IOException ioe) {
      System.out.println("No se ha podido escribir en el fichero");
    }
  }
}
