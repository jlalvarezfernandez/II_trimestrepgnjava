package expresionesRegulares;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * PROPOSITO: 1. Programa que recibe dos parámetros: 
 * 
 *                  un fichero de texto 
 *                  
 *                  una cadena que le indica qué información va extraer del mismo 
 *                  
 *               después muestra por la pantalla los datos extraídos.
 *               
 *               Los posibles valores del segundo parámetro y la información que extrae es:
 *               
 *                  DNI: extrae los DNIs.
 *                  
 *                  IP: extrae las direcciones IP. \\d{1,3}.\\d.1,3}.\\d{1,3}.\\d{1,3}
 *                  
 *                  MAT: extrae matrículas de coche con formato 0000XXX.  \\d{4}[A-Z]{3}
 *                  
 *                  HEX: extrae números hexadecimales.
 *                  
 *                  FEC: extrae fechas con formato dd/mm/aaaa.  \\d{1,2}/\\d.1,2}/\\d{4}
 *                  
 *                  TWT: extrae usuarios de twitter: 
 *                        empieza por @ y puede contener letras mayusculas y minusculas, numeros, guiones y guiones bajos.
 *                        \\d@
 *                        
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio01 {




  public static void main(String[] args) throws IOException {

    // Primero comprobamos que el programa recibe 2 parámetros

    if(args.length != 2) {
      System.err.println("Error, el programa no tiene 2 parámetros");
      System.exit(1);
    }

    // asignamos al segundo parámetro una cadena que extraerá la información del mismo 
    // y después mostrará por pantalla los datos extraidos

    String fichero = args[0];
    String cadena = args[1];
    String expresion = null;

    // leemos la informacíon del fichero

    if (cadena.toUpperCase().equals("DNI")) {
      expresion = "\\d{8}[A-HJ-NP-TV-Z]";
    }
    else if (cadena.toUpperCase().equals("IP")) {
      expresion = "\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b";
    }
    else if (cadena.toUpperCase().equals("MAT")) {
      expresion = "[0-9]{4}[BC-DF-GH-JN-PT-VZ]{3}";
    }
    else if (cadena.toUpperCase().equals("HEX")) {
      expresion = "#[0-9A-Fa-f]+\\b";
    }
    else if (cadena.toUpperCase().equals("FEC")) {
      expresion = "\\d{1,2}/\\d{1,2}/\\d{4}";
    }
    else if (cadena.toUpperCase().equals("TWT")) {
      expresion = "\\B(@[a-zA-Z0-9_]{1,15})\\b";
    }
    else {
      System.err.println("Error al introducir el nombre del parámetro");
      System.exit(1);
    }
    buscaCoincidencias(fichero, expresion);
  }


  /**
   * Este método buscará y escribirá dentro del fichero introducido por parámetro la expresión regular también
   * introducida por parámetro.
   * @param fichero
   * @param expresion
   */
  private static void buscaCoincidencias(String fichero, String expresion) {
    try {
      BufferedReader manejador = new BufferedReader(new FileReader(fichero));
      String linea =  manejador.readLine();
      while (linea != null) {
        Pattern pattern1 = Pattern.compile(expresion);
        Matcher matcher1 = pattern1.matcher(linea);
        while (matcher1.find()) {
          System.out.println("Coincidencias: " + matcher1.group());
        }
        linea = manejador.readLine();
      }
      manejador.close();
    } catch (FileNotFoundException e) {
      System.err.println("Error, No se ha encontrado el fichero");
      System.exit(2);
    }catch (IOException e) {
      System.err.println("Error");
      System.exit(2);
    } 
  }
}


