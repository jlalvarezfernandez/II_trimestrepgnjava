package arraylistColecciones;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Crea un mini-diccionario español-inglés que contenga, al menos, 20 palabras (con su correspondiente traducción). 
 * Utiliza un objeto de la clase HashMap para almacenar las parejas de palabras. 
 * El programa pedirá una palabra en español y dará la correspondiente traducción en inglés.
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio10 {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    
    String palabra;
    
    // declaramos el diccionario
    
    HashMap<String, String> diccionario = new HashMap<String, String>();
    
    // añadimos las palabras al diccionario
    
    diccionario.put("perro", "dog");
    diccionario.put( "gato", "cat");
    diccionario.put("pajaro", "bird");
    diccionario.put("mesa", "table");
    diccionario.put("lapiz", "pencil");
    diccionario.put("llaves", "keys");
    diccionario.put( "ratón", "mouse");
    diccionario.put("pez", "fish");
    diccionario.put("arroz", "rice");
    diccionario.put("silla", "chair");
    diccionario.put("movil", "mobile");
    diccionario.put("nombre", "name");
    diccionario.put("tijeras", "scissors");
    diccionario.put("caballo", "horse");
    diccionario.put("vaca", "cow");
    diccionario.put("loro", "parrot");
    diccionario.put("dinero", "money");
    diccionario.put("gafas", "glass");
    diccionario.put("chocolate", "chocolate");
    diccionario.put("botella", "bottle");
    
    System.out.println("-----DICCIONARIO INGLES-ESPAÑOL------");
    System.out.println("---------------------------------------");
    System.out.println("Introduce una palabra en castellano para ver su traducción: ");
    palabra = sc.next();
    
    if (diccionario.containsKey(palabra)) {
      System.out.print("La palabra " + palabra + " corresponde a: ");
      System.out.println(diccionario.get(palabra));
    } else {
      System.out.println("La palabra introducida no existe en el diccionario");
    }
    
    

  }

}
