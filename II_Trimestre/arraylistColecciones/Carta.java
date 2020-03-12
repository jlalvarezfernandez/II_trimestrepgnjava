package arraylistColecciones;

import java.util.Arrays;

/**
 * Realiza un programa que escoja al azar 10 cartas de la baraja española (10 objetos de la clase Carta). 
 * Emplea un objeto de la clase ArrayList para almacenarlas y asegúrate de que no se repite ninguna.

 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

// Creamos la clase carta

public class Carta {

  // Variables estáticas que almacen los valores de las cartas

  String [] cartas = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Sota", "Caballo", "Rey"};
  String [] palos = {"Bastos", "Espadas", "Copas", "Oros"};

  // Atributos

  private String numero;
  private String palo;

  // constructor

  public Carta() {
    this.numero = cartas[(int)(Math.random()*10)];
    this.palo = palos[(int)(Math.random()*4)];
  }
  
  ///// getters y setters////////

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getPalo() {
    return palo;
  }

  public void setPalo(String palo) {
    this.palo = palo;
  }

  @Override
  public String toString() {
    return numero + " de "+ palo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((numero == null) ? 0 : numero.hashCode());
    result = prime * result + ((palo == null) ? 0 : palo.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Carta other = (Carta) obj;
    if (numero == null) {
      if (other.numero != null)
        return false;
    } else if (!numero.equals(other.numero))
      return false;
    if (palo == null) {
      if (other.palo != null)
        return false;
    } else if (!palo.equals(other.palo))
      return false;
    return true;
  }

 
  
  


  
  
  
  
  
 
  
  

}
