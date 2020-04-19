package expresionesRegulares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Programa que reciba una url y el nombre de una etiqueta html. Si la url es válida debe mostrar por la pantalla el contenido de cada etiqueta.
 * Ejemplo: 
 * si ejecuto java miprograma https://www.iesgrancapitan.org h1
 * La salida sería:
 * 
 * Últimos artículos de nuestro blog de centro
 * Número de etiquetas encontradas: 1
 * 
 * @authorJÓSE LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio02 {

  public static void main(String[] args) throws MalformedURLException, ProtocolException, IOException {

    // Comprobamos los parámetros
    if (args.length != 2) {
      System.err.println("El número de parámetro debe de ser 2.");
      System.exit(1);
    }

    // Variables
    String web = args[0];
    String etiqueta = args[1];
    String html = "";

    try {

      // Petición Get a la web
      URL url = new URL(web);
      HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
      conexion.setRequestMethod("GET");
      
      // Leemos la petición
      BufferedReader bf = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
      String linea;
      
      StringBuffer contenido = new StringBuffer();
      
      // Añadimos contenido a la cadena de html
      while ((linea = bf.readLine()) != null) {
        html += linea + "\n";
      }
      bf.close();
      conexion.disconnect();
      
      // Construimos la expresión y la buscamos en html
      Pattern patron = Pattern.compile("<" + etiqueta + "[^>]*>(.+?)</" + etiqueta + ">", Pattern.DOTALL);
      Matcher matcher = patron.matcher(html);
      
      // Imprimimos resultados
      System.out.println("COINCIDENCIAS:\n");
      System.out.println("- Etiqueta buscada en el código: " + etiqueta + "\n");
      System.out.println("- Contenido de la etiqueta " + etiqueta + ":\n");

      int i = 1;
      // Imprimimos resultados
      while (matcher.find()) {
        System.out.println("COINCIDENCIA " + i + ": \n" + matcher.group(1) + "\n");
        i++;
        
      }
      System.out.println("-------------------------------------------------");
      System.out.println("Total de coincincidencias de <" + etiqueta + ">: " + i);
      
      // Ocurrencias
      
      


    } catch (MalformedURLException e) {
      System.err.println("URL no encontrada.");
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

}

