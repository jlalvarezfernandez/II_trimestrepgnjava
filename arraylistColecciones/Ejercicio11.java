package arraylistColecciones;

import java.util.HashMap;

/**
 * Realiza un programa que escoja al azar 5 palabras en español del minidiccionario del ejercicio anterior. 
 * El programa irá pidiendo que el usuario teclee la traducción al inglés de cada una de las palabras y comprobará si son correctas. 
 * Al final, el programa deberá mostrar cuántas respuestas son válidas y cuántas erróneas.
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio11 {

  public static void main(String[] args) {
    
    
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

  }

}
