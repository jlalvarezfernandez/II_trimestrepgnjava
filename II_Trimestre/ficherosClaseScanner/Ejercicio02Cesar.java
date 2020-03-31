package ficherosClaseScanner;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 2. Crea un programa que encripte un fichero que le pasamos como parámetro y almacene el resultado en otro, 
 *    que también pasamos como parámetro, de manera que:
 *    
 *            1. Si el programa no recibe dos parámetros termina con un error 1.
 *            2. Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo del que lee, 
 *               pero antes advertirá al usuario de que machacará el archivo origen, dando opción a que la operación no se haga.
 *            3. Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina con un mensaje de error y código 2.
 *            4. Si en el fichero destino no se puede escribir da error al abrirlo como lectura) el 
 *               programa termina con un mensaje de error y código 2.
 *            5. Para encriptar usa el método César, necesitarás una clave que debes pedir al usuario.
 *            
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio02Cesar {

  
  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner (System.in);

    //  1. Si el programa no recibe dos parámetros termina con un error 1.

    if ((args.length == 0) || (args.length > 2)){
      System.err.println("Error al introducir los parámetros");
      System.exit(1);
    }


    // 2. Si el programa recibe un solo parámetro guardará la información encriptada
    // en el mismo archivo del que lee, pero antes advertirá al usuario de que 
    // machacará el archivo origen, dando opción a que la operación no se haga.

    String ficheroOrigen = args[0];
    String ficheroDestino = null;
    if ( args.length == 2) {
      ficheroDestino = ficheroOrigen;

      do {
        System.out.println("Esta operación machaca archivo de origen.");
        String resp = "";
        System.out.println("Pulse S o N");
        resp = sc.nextLine();
        if (resp.equals("S")) {
          break;
        }
        if (resp.equals("N")) {
          System.out.println("webón");
          System.exit(1);

        } else {
          ficheroDestino = args[2];
        }  
      } while (true);
    }

    // 3. Si el fichero origen no existe (da error al abrirlo como lectura) 
    // el programa termina con un mensaje de error y código 2.

    try {

      BufferedReader fichero = new BufferedReader(new FileReader(ficheroOrigen));
    }

    catch (FileNotFoundException excep) {
      System.err.println("No se ha podido abrir el fichero");
      System.exit(2);
    }

    //  4. Si en el fichero destino no se puede escribir da error al abrirlo como lectura) el 
    // programa termina con un mensaje de error y código 2.
    BufferedWriter fichero = null;
    try {
      fichero = new BufferedWriter(new FileWriter(ficheroDestino));

    } catch (FileNotFoundException excep) {
      System.err.println("No se puede escribir el fichero");
      System.exit(2);
    }


    // 5. Para encriptar usa el método César, necesitarás una clave que debes pedir al usuario.

    do {

      try {
        System.out.println("Introduce el número de desplazamientos para la encriptación: ");
        int desplazamiento = sc.nextInt();
        break;
      } catch (InputMismatchException excep) {
        System.out.println("Introduce un núemro entero"); 
        sc.nextLine();
      } 

    } while (true);
    
    
    
    
    



  }

}
