package fraccion;

/**
 * 2. Crea una clase Fraccion (Python) de forma que podamos hacer las siguientes operaciones:
 * 
 * 
 *    -Contruir un objeto Fraccion pasándole el numerador y el denominador.
 *    -Obtener la fracción como cadena de caracteres.
 *    -Obtener y modificar numerador y denominador. No se puede dividir por cero.
 *    -Obtener resultado de la fracción (número real).
 *    -Multiplicar la fracción por un número.
 *    -Multiplicar, sumar y restar fracciones.
 *    -Simplificar la fracción.
 *    
 * @author José Luis Álvarez Fernández
 *
 */


/**
 * Creamos la clase Fraccion
 *
 */

public class Fraccion {
  
  // Definimos los atributos
  
  private int numerador;
  private int denominador;
  
  /**
   * Creamos el constructor
   * @param numerador
   * @param denominador
   */
  
  public Fraccion (int numerador, int denominador) {
    this.numerador = numerador;
    this.denominador = denominador;
  }
  
  // Creamos los getters, son los observadores, nos devuelven el valor de los atributos
  
  /**
   * Creamos el geter para el numerador
   * @return
   */
  
  public double getNumerador() {
    return this.numerador;
  }
  
  /**
   * Creamos el getter para el denominador
   * @return
   */
  
  public int getDenominador() {
    return (int) this.denominador;
  }
  
  // Creamos los setters, son los modificadores (nos permiten cambiar los valores)
  
  /**
   * Creamos el setter para el numerador
   * @param numerador
   */
  
  public void setNumerador(int numerador) {
    this.numerador = numerador;
    
  }
  /**
   * Creamos el setter para el denominador
   * @param denominador
   */
  
  public void setDenominador(int denominador) {
    if (denominador != 0) {
      this.denominador = denominador;
      
    } else {
      System.out.println("El denominador no puede ser  0");
    }
    
  }
  
  // Obtener la fracción como cadena de caracteres.
  
  /**
   * Creamos el método toString para devolver una cadena de la fraccion
   */
  
  public String toString() {
    return this.numerador + "/" + this.denominador;
  }
  
  // Obtener resultado de la fracción (número real).
  
  /**
   * Creamos el método para obtener el número real de la fraccion
   * @return
   */
  
  public double resultadoReal() {
    return (double) this.numerador / this.denominador;
  }
 
  
  // Multiplicar la fracción por un número.
  
  /**
   * Método para multiplicar una fraccion por un número
   * @param numero
   * @return
   */
  
  public String multiplicaNumero (int numero) {
    return (this.numerador * numero) + "/"+  (this.denominador * 1);
    
  }
  
  // Multiplicar, sumar y restar fracciones.
  
  /**
   * Método para multiplicar fracciones
   * @param otraFraccion
   */
  
  public void multiplicaFracciones (Fraccion otraFraccion) {
    this.numerador *= otraFraccion.numerador;
    this.denominador *= otraFraccion.denominador;
      
  }
  /**
   * Método para sumar fracciones
   * @param otraFraccion
   */
  
  public void sumaFracciones (Fraccion otraFraccion) {
    this.numerador = (this.numerador * otraFraccion.denominador) + (this.denominador * otraFraccion.numerador);
    this.denominador = (this.denominador * otraFraccion.denominador);
  }
  
  /**
   * Método para restar fracciones
   * @param otraFraccion
   */
  
  public void restaFracciones (Fraccion otraFraccion) {
    this.numerador = (this.numerador * otraFraccion.denominador) - (this.denominador * otraFraccion.numerador);
    this.denominador = (this.denominador * otraFraccion.denominador);
  }
  
  //Simplificar la fracción
  
  /**
   * Método que nos ayudará a hallar el máximo común divisor de la fracción para implementar el método simplifica
   * @return
   */
  
  public double maximoComunDivisor() {
    int dividendo = (int) this.numerador;
    int divisor = (int) this.denominador;
    int resto = dividendo % divisor;
    int mcd = 0;
    
    while (resto != 0) {
      dividendo = divisor;
      divisor = resto;
      resto = dividendo % divisor;
      mcd = divisor;
    }
    return mcd;
  }
  
 /**
  * Método para simplificar la fraccíon dividiendo el numerador y el denominador por el mcd
  */
  void simplifica() {
    int mcd;
    mcd = (int) this.maximoComunDivisor();
    this.numerador /= mcd;
    this.denominador /= mcd;
  }
  
  
  
  

  


  
  
  
  
  
  
  
  

}
