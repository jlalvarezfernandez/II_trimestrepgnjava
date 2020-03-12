package arraylistColecciones;


/**
 * Crea un ArrayList con los nombres de 6 compañeros de clase. 
 * A continuación, muestra esos nombres por pantalla. 
 * Utiliza para ello un bucle for que recorra todo el ArrayList sin usar ningún índice.
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

import java.util.ArrayList;

public class Ejercicio01 {

  public static void main(String[] args) {
    
    // definimos el arrayList
    
    ArrayList <String> nombres = new ArrayList<String>();
    
    
    // añadimos los nombresd al arrayList
    
    nombres.add("Currito");
    nombres.add("Antonio");
    nombres.add("Rafa");
    nombres.add("Canucho");
    nombres.add("David");
    nombres.add("Lourdes");
    
    // mostraqmos los nombres por pantalla
    
    for (String elementos : nombres) {
      System.out.println("Los nombres de mis compañeros de clase son: " + elementos);
    }
    
    
    
 

  }

}
