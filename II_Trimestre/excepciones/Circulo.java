package excepciones;
import javax.swing.JOptionPane;

/**
 * 2. Crea la clase “Circulo” en Java que responda al siguiente comportamiento:

              Un círculo puede crecer. Aumenta su radio.
              Un círculo puede menguar. Decrementa su radio.
              Un círculo me devuelve su área si se la pido.
              Un círculo me dice su estado, por ejemplo “Soy un círculo de radio 0.5 metros. 
              Ocupo un área de 0.7853981633974483 metros cuadrados” (método toString())
              
              
3. Crea una clase TestCirculo que cree una instancia de “Circulo”, muestre su estado, lo haga crecer 27 veces, averigüe su área, 
   lo haga decrecer 10 veces y muestre su estado final.

4. Modifica la clase Círculo para que cuando el radio se convierta a 0 el círculo reaccione y diga con una caja de texto gráfica 
   “Soy un mísero punto sin área” usando la clase JOptionPane del paquete javax.swing. Podéis ver este vídeo: https://youtu.be/F_48qh3BcDs
   
 * @author AJFRU
 *
 */

public class Circulo {
  
  // creamos los atributos
  
  private double radio;
  
  // creamos el constructor
  
  public Circulo (double radio) throws radioNegativoError {
    setRadio(radio);
  }

  
  
  // getters y setters
  
  public double getRadio() {
    return radio;
  }

  public void setRadio(double radio) throws radioNegativoError {
    if (Circulo.radioCorrecto(radio)) {
      this.radio = radio;
    } else {
      throw new radioNegativoError("EL radio no puede ser negativo");
    }
    
    
  }
  
  // Metodos
  
  /**
   * Método para mostrar el radio del circulo
   */
  
  @Override
  public String toString() {
    return "Soy un circulo de radio " + this.getRadio() + " metros. Ocupo un área de " + this.area() + " metros cuadrados";
  }
  
  /**
   * Método para  aumentar su radio
   * @param tamanio
   * @return
   */
  
  public double crece(double tamanio) {
    if(this.radio < 0) {
      System.out.println("El radio no puede ser negativo");
      System.exit(1);
      
    }else if (this.radio == 0) {
      JOptionPane.showMessageDialog(null, "Soy un mísero punto sin área");
      }
    
    
    return this.radio = radio * tamanio;
    
  }
  
    

  
  /**
   * Método para decrementar su radio.
   * @param tamanio
   * @return
   */
  
  public double mengua(double tamanio) {
    if(this.radio < 0) {
      System.out.println("El radio no puede ser negativo");
      System.exit(1);
      
    }else if (this.radio == 0) {
      JOptionPane.showMessageDialog(null, "Soy un mísero punto sin área");
      }
    
    
    return this.radio = radio - tamanio;
    
  }
  
  /**
   * Método para calcular el área del circulo
   * @return
   */
  
  public double  area() {
    return Math.PI * Math.pow(this.radio, 2);
  }
  
  /**
   * Método para comprobar que el radio introducido sea correcto
   * @return true si es mayor que 0 y false si es menor que 0
   */
  
  public static boolean radioCorrecto(double radio) {
    if (radio < 0) {
      return false;
    }
    return true;
  }

}