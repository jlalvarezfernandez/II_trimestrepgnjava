package arraylistColecciones;
import arraylistColecciones.Carta;
import java.util.ArrayList;

/**
 * Realiza un programa que escoja al azar 10 cartas de la baraja española (10 objetos de la clase Carta). 
 * Emplea un objeto de la clase ArrayList para almacenarlas y asegúrate de que no se repite ninguna.

 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Ejercicio08 {

  public static void main(String[] args) {


    // definimos las variables

    int tamanio = 10;


    // creamos el ArrayList

    ArrayList<Carta> baraja = new ArrayList<Carta>();


    for (int i = 0; i < tamanio; i++) {
      Carta carta;
      do {
        carta = new Carta();

      }while (baraja.contains(carta));
      baraja.add(carta);
      System.out.println("Creamos carta: " + baraja.get(i));
    }
    System.out.println("------------------");
    System.out.println(baraja);


  }

}
