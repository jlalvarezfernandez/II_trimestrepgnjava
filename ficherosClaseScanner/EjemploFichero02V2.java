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


class EjemploFichero02V2 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner (System.in);
   
    String fruta = "";
    
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter("fruta.txt"));
      
      do {
        System.out.println("Introduce el nombre de la fruta (introduce un espacio para acabar): ");
        fruta = sc.nextLine();
        bw.write(fruta + "\n");
      } while (!fruta.equals(" "));
      
      bw.close();
      
    } catch (IOException ioe) {
      System.out.println("No se ha podido escribir en el fichero");
    }
  }
}
