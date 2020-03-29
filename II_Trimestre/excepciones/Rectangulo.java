package excepciones;

import excepciones.DimensionRectanguloError;

/**
 *  Esta clase representa objetos de tipo rectangulO:
 *  
 *  Atributos: base y altura
 *  
 *  Acciones: calculo del perimetro
 *            calculo del area
 *            saber si es igual a otro rectangulo
 *            dibujar
 *            comparar
 *            
 *  Necesitaremos métodos para saber el número de rectángulos que hemos creado
 *  necesitamos un metodo para comprobar si la base y altura son correctas ( que no sean mayor de 10)
 *            
 *  Sustituya los assert por excepciones: 
 *     cuando se le asigne al rectángulo un valor que no sea entero en el lado o en el ancho tiene que lanzar la excepción "TypeError".
 *     crea una excepción propia para cuando el rectángulo sobrepasa las dimensiones permitidas: "DimensionRectanguloError".
 *                                              
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */
public class Rectangulo {
  
  // definimos dos variables estáticas para otros calcular otros métodos
  
  public static int LADOMAXIMO = 10;
  public static int NUMRECTANGULOSCREADOS = 0;
  
  // definimos los atributos de la clase rectángulo
  
  private int base;
  private int altura;
  
  // creamos el constructor para la clase rectángulo
  
  public Rectangulo(int base, int altura) throws excepciones.DimensionRectanguloError {
    
    
    // aqui vamos a comprobar que los objetos creados cumplan con que su base o altura sean correctas
    if (Rectangulo.esLadoCorrecto(base) && Rectangulo.esLadoCorrecto(altura)) {
      this.base = base;
      this.altura = altura;
      
    }else {
      // para crear un excepción propiua es necesario lanzar throw new mas el nombre de la excepción y se crea otra clase para esa excepción
      throw new DimensionRectanguloError("No esta dentro de las dimensiones");
      // System.err.println("Error al introducir los datos");
      // System.exit(1);

    }
   
    // para saber el número de rectángulos que hemos creado debemos ahcerlo en el cosntructor, que es donde creamos los objetos
    NUMRECTANGULOSCREADOS += 1;
    
  }
  
  // creamos los metodos getters (observadores) y setters (modificadores) para los atributos de la clase rectángulo
  
  public int getBase() {
    return base;
  }

  public void setBase(int base) throws DimensionRectanguloError  {
    if (Rectangulo.esLadoCorrecto(base)) {
      this.base = base;
    } else {
      throw new DimensionRectanguloError("No esta dentro de las dimensiones");
    }

  }

  public int getAltura() {
    return altura;
  }

  public void setAltura(int altura) throws DimensionRectanguloError {
    if (Rectangulo.esLadoCorrecto(altura)) {
      this.altura = altura;
    } else {
      throw new DimensionRectanguloError("No esta dentro de las dimensiones");
    }
  }
  
  // Método toString para mostrar el objeto de la clase rectángulo como una cadena
  
  @Override
  public String toString() {
    return "[" + base + "," + altura + "]";
  }
  
  // Método para dibujar los rectángulos 
  
  /**
   * Método apra dibujar rectángulos con un for que recorre la altura y otro for dentro del anterior que recorre la base
   * devolvemos los asteriscos por cada iteracion de la altura y base
   * @return dibuja
   */
  
  public String dibujaRectangulo() {
    String dibuja = "";
    for (int i = 0; i < this.altura; i++) {
      
      for (int j = 0; j < this.base; j++) {
        dibuja += "*" ;
      }
      dibuja += "\n" ;
    }
    return dibuja;
  }
  
  // Método para calcular el perímetro
  /**
   * Método para calcular el perímetro de los rectángulos
   * El perímetro se clacula multiplicando por 2 la base + la altura
   * 
   * @return perimetro
   */
  
  public int calculaPerimetro() {
    return 2 * (this.base + this.altura);
  }
  
  // Método para clacular el área
  
  /**
   * Método apra calcular el área de los rectángulos
   * El área se cañculo multiplicando la base * la altura
   * @return
   */
  
  public int calculaArea() {
    return (this.base * this.altura);
  }
  
  // Método para comparar los rectángulos
  /**
   *  Método para comparar rectángulos
   *  Para saber si dos rectángulos son iguales debemos comprobar sus áreas
   * Asi pues, las restaremos:
   * @param otroRectangulo
   * @return
   *        si el numero resultante es 0 significa que son iguale
   *        si el número resultante es mayor que 0 significa que el primer rectámgulo es mayor que el primero
   *        si el número resultante es mayor que 0 significa que el primer rectángulo es menor que el segundo
   */
  
  public int comparaRectangulos(Rectangulo otroRectangulo) {
    return this.calculaArea() - otroRectangulo.calculaArea();
  }
  
  // Método para saber si los rectángulos son gemelos
  
  /**
   * Método para saber si dos rectángulos son gemelos
   * Para saber si lo son tenemos que comparar la base y altura de cada uno
   * @param otroRectangulo
   * @return true si son iguales o false si no lo son
   */
  
  public boolean esGemelo(Rectangulo otroRectangulo) {
    if ((this.base == otroRectangulo.base && this.altura == otroRectangulo.altura)) {
    return true;
  }
    return false;
  }
  
  // Método estático para saber si el lado de los rectangulos es correcto 
  /**
   * Método estático para saber si la base o altura del rectangulo es correcta
   * @param valor
   * @return será verdadera si es mayor que 0 y mnor o igual a 10
   */
  
  public static boolean esLadoCorrecto(int valor) {
    return valor > 0 && valor <= Rectangulo.LADOMAXIMO;
    
  }

}
