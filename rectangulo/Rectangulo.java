package rectangulo;

/**
 * Creamos la clase cuadrado
 * 
 * @author José Luis Álvarez Fernández
 *
 */

// Creamos la calse rectangulo

public class Rectangulo {
  
  // constantes
  public static int LADOMAXIMO = 10;
  public static int NUMCREADOS = 0;
  
  // definimos los atributos
  
  private int base;
  private int altura;
  
  /**
   * Creamos el constructor
   * @param base
   * @param altura
   */
  
  
  public Rectangulo (int base, int altura) {
    this.base = base;
    this.altura = altura;
    Rectangulo.NUMCREADOS +=1;
    
  }
  
  // Creamos los getters, son los observadores, nos devuelven el valor de los atributos
  /**
   * Creamos el método getter para la base
   * @return
   */
  public int getBase() {
    return this.base;
  }
  /**
   * Creamos el método getter para la altura
   * @return
   */
  
  public int getAltura() {
    return this.altura;
  }
  
  // Creamos los setters, son los modificadores (nos permiten cambiar los valores)
  /**
   * Creamos el método setter para la base
   * @param base
   */
  public void setBase(int value) {
    if (Rectangulo.esLadoCorrecto(value)) {
      this.base = base;
    } else {
      System.out.println("ERROR!!!, base incorrecta");
    }
   
  }
  /**
   * Creamos el método setter para la altura
   * @param altura
   */
  public void setAltura (int value) {
    if (Rectangulo.esLadoCorrecto(value)) {
      this.altura = altura;
    } else {
      System.out.println("ERROR!!!, base incorrecta");
    }
  }
  
  /**
   * Método estatico que cuenta el número de rectangulos creados
   * @return
   */
  
  public static int numRectangulos() {
    return Rectangulo.NUMCREADOS;
  }
  
  /**
   * Método estatico para comprobar que el lado sea correcto
   * @param value
   * @return
   */
  
  public static boolean esLadoCorrecto(int value) {
    return value < 0 && value <=Rectangulo.LADOMAXIMO;
  }
  
  /**
   * Creamos el método toString para obtener la cadena fromateada 
   */
  
  public String toString() {
    return this.base + "," + this.altura;
  }
  
  /**
   * Creamos el método perimetro para calcular el perimetro del rectangulo
   * @return
   */
  
  public int perimetro() {
    return 2 * (this.base + this.altura);
  }
  /**
   * Creamos el método para calcular el area del rectangulo
   * @return
   */
  
  public int area() {
    return (this.base * this.altura);
  }
  /**
   * Método para comparar 2 rectangulos dadas sus areas
   * @param otroRectangulo
   * @return
   */
  
  public int comparaRectangulos(Rectangulo otroRectangulo) {
    return (this.area()- otroRectangulo.area());
  }
  
  /**
   * Metodo para saber si 2 rectangulos son igales dadas su altura y base
   * @param otroRectangulo
   * @return
   */
  
  public boolean esGemelo (Rectangulo otroRectangulo) {
    return this.base == otroRectangulo.base && this.altura == otroRectangulo.altura;
  }
  
  /**
   * Método para mostrar y dibujar el rectangulo
   */
  
  public void mostrar() {
    String str = "";
    for (int i= 0; i <= this.base; i++) {
      for (int j = 0; j <= this.altura; j++) {
        str += "*";
      }
      
    }
   
    
  }
  
 
  
  
  
 
  
  
   



  
  
  
  

}
