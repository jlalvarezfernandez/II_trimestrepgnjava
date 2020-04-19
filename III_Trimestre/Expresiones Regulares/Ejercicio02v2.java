package expresionesRegulares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PROPOSITO 1: Programa que reciba una url y el nombre de una etiqueta html. 
 *              Si la url es válida debe mostrar por la pantalla el contenido de cada etiqueta.
 *              
 *              Ejemplo: 
 *                si ejecuto java miprograma https://www.iesgrancapitan.org h1
 *                La salida sería:
 *                      - Últimos artículos de nuestro blog de centro
 *                      - Número de etiquetas encontradas: 1
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 * 
 * ANÁLISIS
 * ---------
 * - Primero nos hemos creado un archivo llamado "Etiquetas.txt" donde almacenamos todas las etiquetas de html
 * - Creamos un ArrayList llamado etiquetas que nos servira para recorrer el fichero
 * - Comprobamos que el numero de argumentos sea igual a 2, sino es así devolverá un error
 * - Asignados a las variables cual es su parámetro correspondiente
 * - bloque try-catch en el que vamos a leer el fichero linea a linea y guardaremos toda la informacion en el arrayList
 * - Condicion si la etiqueta pasada como parámetro no aparece en el arrayList devuelve error
 * - Hacemos la petición get a la web
 * - Hacemos la lectura de la petición
 * - Añadimos contenido a la cadena de html
 * - Construimos la expresión y la buscamos en html
 * - Mostramos los resultados
 *
 */

public class Ejercicio02v2{

  public static void main(String[] args) throws IOException {
    
    // Creación ArrayList
    
    ArrayList<String> etiquetas = new ArrayList<String>();

    // Comprobamos argumentos
    
    if (args.length != 2) {
      System.err.println("El programa debe tener 2 parámetros");
    }

    // Parámetros
    String web = args[0];
    String etiqueta = args[1];
    String html = "";

    try {
      // Lectura de elementos html en el archivo.
      BufferedReader bf1 = new BufferedReader(new FileReader("Etiquetas.txt"));
      String lineaFichero = bf1.readLine();

      while (lineaFichero != null) {
        // Añadimos al arrayList el contenido de etiquetas.
        etiquetas.add(lineaFichero);
        lineaFichero = bf1.readLine();
      }
      bf1.close();

      // Comprobamos si la etiqueta pasada como parametro se encuentra en el fichero.
      if (!etiquetas.contains(etiqueta)) {
        System.err.println("La etiqueta pasada como parámetro no existe.");
        System.exit(1);
      }

      // Petición Get a la web
      URL url = new URL(web);
      HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
      conexion.setRequestMethod("GET");

      // Lectura de peticion
      BufferedReader bf2 = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
      String linea;

      // Añadimos contenido a la cadena de html
      while ((linea = bf2.readLine()) != null) {
        html += linea + "\n";
      }
      // cerramos ela rchivo y tambien la conexión
      bf2.close();
      conexion.disconnect();

      // Construimos la expresión y la buscamos en html
      Pattern patron = Pattern.compile("<" + etiqueta + "[^>]*>(.+?)</" + etiqueta + ">", Pattern.DOTALL);
      Matcher matcher = patron.matcher(html);

      // Imprimimos resultados
      System.out.println("ANÁLISIS DE LOS RESULTADOS:\n");
      System.out.println("- Etiqueta buscada en el código: " + etiqueta + "\n");
      System.out.println("- Contenido de la etiqueta " + etiqueta + ":\n");

      // recorremos las coincidencias buscadas
      int i = 1;
      while (matcher.find()) {
        System.out.println("COINCIDENCIA " + i + ": \n" + matcher.group(1) + "\n");
        i++;
      }

      // Mostramos los resultados
      System.out.println();
      System.out.println("- Número de etiquetas encontradas: " + (i-1));

    } catch (MalformedURLException e) {
      System.err.println("URL no encontrada.");
    } catch (IOException e) {
      System.err.println("Fichero de etiquetas no leido");
    }

  }

}
  