package controladoresEjercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * PROPOSITO: 3. Haz un programa que reciba como parámetro un fichero encriptado con el método César y y almacene el resultado en otro, 
 *               que también pasamos como parámetro, de manera que:
 *               
 *                  Si el programa no recibe dos parámetros termina con un error 1.
 *                  
 *                  Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo del que lee, 
 *                  pero antes advertirá al usuario de que machacará el archivo origen, dando opción a que la operación no se haga.
 *                  
 *                  Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina con un mensaje de error y código 2.
 *                  
 *                  Si en el fichero destino no se puede escribir da error al abrirlo como lectura) el programa termina con un mensaje de error y código 2.
 *                  
 *              Para desencriptar necesitas una clave que debes pedir al usuario.
 *              
 *              ¿Se te ocurre alguna forma de desencriptar este archivo sin pedir clave? Coméntala, y si te atreves... ¡impleméntala!

 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class DesencriptaMetodoCesar {
  
  /**
   * Encripta la cadena que le pasamos como parámetro. 
   * @param cadena
   * @param desplazamiento
   * @return cadena encriptada
   */
  static String desencriptaCesar(String cadena, int desplazamiento) {
    String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZáéíóúüñÁÉÍÓÚÜÑ";
    String cadenaDesencriptada = "";
    for (char caracter: cadena.toCharArray()) {
      char caracterDesencriptado = caracter;
      // si el carácter es alfabético, desencriptamos
      if (letras.contains(Character.toString(caracter))) {
        int posicionDondeEsta = letras.indexOf(caracter);
        int posicionCaracterDesencriptado = ((posicionDondeEsta - desplazamiento) % letras.length());
        if (posicionCaracterDesencriptado < 0) {
          posicionCaracterDesencriptado = letras.length() + posicionCaracterDesencriptado;
        }
        caracterDesencriptado = letras.charAt(posicionCaracterDesencriptado);
      } 
      cadenaDesencriptada += caracterDesencriptado;
    }
    return cadenaDesencriptada;
  }

  public static void main(String[] args) throws IOException {
    
    Scanner sc = new Scanner (System.in);
    
    
    // Si el programa no recibe dos parámetros termina con un error 1
    
    if ((args.length == 0) || (args.length > 2)) {
      System.err.println("Error!!!, el programa no recibe 2 parámetros");
      System.exit(1);
    }
    
    // Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo del que lee, 
    //pero antes advertirá al usuario de que machacará el archivo origen, dando opción a que la operación no se haga.

    String ficheroOrigen = args[0];
    String ficheroDestino ="ficheroDesencriptado.txt";
    if(args.length == 1) {
      ficheroDestino = ficheroOrigen;
      do {
        System.out.println("Este programa tiene un único parámetro");
        System.out.println("¿Desea sobreescribir el archivo (S/N) ?: ");
        String opcion = sc.next();
        if (opcion.equals("S") || opcion.equals("s")) {
          break;
        } 
        if (opcion != "S" || opcion != "s") {
          System.out.println("Operación cancelada");
          System.exit(4);
        } else {
          ficheroDestino = args[1];
        }


      } while (true);

    }
    
    // Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina con un mensaje de error y código 2.
    BufferedReader manejadorOrigen = null;
    try {
      manejadorOrigen = new BufferedReader(new FileReader(ficheroOrigen));
    } catch (FileNotFoundException e) {
      System.err.println("Error!!!, el archivo no se ha podido abrir para lectura" + ficheroOrigen);
      System.exit(2);
      
    }
    
    // Si en el fichero destino no se puede escribir da error al abrirlo como lectura) el programa termina con un mensaje de error y código 2.
    BufferedWriter manejadorDestino = null;
    try {
      manejadorDestino = new BufferedWriter(new FileWriter(ficheroDestino));
      
    } catch (Exception e) {
      System.err.println("No se puede escribir en el fichero de destino " + ficheroDestino);
    }
    
    // pedimos el desplazamiento para desencriptar el fichero
    
    int desplazamiento = 0;
    do {
      try {
        System.out.println("Introduce el desplazamiento para desencriptar el archivo usando el método César: ");
        desplazamiento = sc.nextInt();
        break;

      } catch (Exception e) {
        System.err.println("Error, introduce un número entero");
        System.exit(3);
      }

    } while (true);

 // Leemos, encriptamos y escribimos
    String linea = manejadorOrigen.readLine();
    while (linea != null) {
      // escribimos línea encriptada
      manejadorDestino.write(desencriptaCesar(linea, desplazamiento));
      manejadorDestino.newLine(); // salto de línea, mejor que "\n"
      // leemos siguiente línea, si es <EOF> no entraremos en el ciclo
      linea = manejadorOrigen.readLine();
    }
    
    // Cerramos ficheros
    manejadorOrigen.close();
    manejadorDestino.close();
    System.out.println("Proceso concluido.");


  }
}

