package arraylistColecciones;
import java.util.HashMap;
/**
 * Escribe un programa que genere una secuencia de 5 cartas de la baraja española y que sume los puntos según el juego de la brisca. 
 * El valor de las cartas se debe guardar en una estructura HashMap que debe contener parejas (figura, valor), por ejemplo (“caballo”, 3). 
 * La secuencia de cartas debe ser una estructura de la clase ArrayList que contiene objetos de la clase Carta. 
 * El valor de las cartas es el siguiente: as → 11, tres → 10, sota → 2, caballo → 3, rey → 4; el resto de cartas no vale nada.
 * 
 * Ejemplo:
        as de oros
        cinco de bastos
        caballo de espadas
        sota de copas
        tres de oros
        Tienes 26 puntos
        
 * @author AJFRU
 *
 */

public class Ejercicio12 {

  public static void main(String[] args) {
    
    HashMap<String, Integer> baraja= new HashMap<String, Integer>();
    
    baraja.put("as de oros", 11);
    baraja.put("cinco de bastos", 0);
    baraja.put("as de oros", 11);
    baraja.put("as de oros", 11);
    baraja.put("as de oros", 11);
    
    
    
    
    

  }

}
