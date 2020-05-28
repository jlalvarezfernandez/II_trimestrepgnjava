package gentesimal;



/**
 * Necesito una clase Articulo que representa a los artículos del almacén: 
 * 
 *       - Su estado será: 
 *       
 *              código
 *              descripción
 *              precio de compra
 *              precio de venta
 *              número de unidades (nunca negativas)
 *
 *       -Como comportamiento:
 *       
 *              Considero que el código va a generarse de forma automática en el constructor, 
 *              así no puede haber dos artículos con el mismo código. Esto implica que no puede modificarse el código de un artículo. 
 *              Sí el resto de las propiedades. 
 *              Podremos mostrar el artículo, por lo que necesito una representacion del artículo en forma de cadena (toString)
 * 
 * @author JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
 *
 */

public class Articulo {
  
  // Creamos los atributos de la clase Artículo
  
  private int codigo;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int numUnidades;
  private static int siguienteCodigo = 1;
  
  // Creamos el constructor de la clase Artículo
  
  public Articulo(String descripcion, double precioCompra, double precioVenta, int numUnidades) throws  PrecioNegativoErrorExcepcion, UnidadesNegativasErrorExcepcion {
      
      
      setDescripcion(descripcion);
      setPrecioCompra(precioCompra);
      setPrecioVenta(precioVenta);
      setNumUnidades(numUnidades);
      this.codigo = generaCodigo();
    
  }
  
  // Creamos otro constructor para identificar el artículo con su código pasado como parametro
  /**
   *  Creamos otro constructor para identificar el artículo con su código pasado como parametro
   * @param codigo
   */
  
  public Articulo(int codigo) {
    this.codigo = codigo;
  }
  
  //////////// Creamos los Getters (observadores) y los Setters (modificadores) de la  clase Artículo \\\\\\\\\\\\\\\

  
  
 
 
  // Setter para la descripción
  /**
   * Setter para la descripción
   * @param descripcion
   */
  void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
 
  // Setter para el precio de compra y evitar que sea negatívo
  /**
   * Setter para el precio de compra y evitar que sea negativo
   * @param precioCompra
   * @throws PrecioNegativoErrorExcepcion 
   */
  void setPrecioCompra(double precioCompra) throws PrecioNegativoErrorExcepcion {
      if (precioCompra < 0) 
        throw new PrecioNegativoErrorExcepcion("El precio de compra no puede ser negativo");
        this.precioCompra = precioCompra;
  }
  

  
  // Setter para el precio de venta
  /**
   * Setter para el precio de venta
   * @param precioVenta
   * @throws PrecioNegativoErrorExcepcion 
   */
  void setPrecioVenta(double precioVenta) throws PrecioNegativoErrorExcepcion {
    if (precioVenta < 0) 
      throw new PrecioNegativoErrorExcepcion("El precio de venta no puede ser negativo");
    this.precioVenta = precioVenta;
  }
  
  // Getter para el número de unidades
  /**
   * Getter para el número de unidades que tiene nuestro almacén
   * @return numUnidades
   */
  private int getNumUnidades() {
    return numUnidades;
  }
  
  // Setter para el número de unidades
  /**
   * Setter para el número de unidades del almacén evitando que sean negatívas
   * @param numUnidades
   * @throws UnidadesNegativasErrorExcepcion 
   */
  void setNumUnidades(int numUnidades) throws UnidadesNegativasErrorExcepcion {
    if (numUnidades < 0) 
      throw new UnidadesNegativasErrorExcepcion("Las unidades no pueden ser negativas");
    this.numUnidades = numUnidades; 
}
  
  
  // Método para incrementar el codigo en uno cada vez que creemos un artículo nuevo
  /**
   * Método para incrementar el codigo en uno cada vez que creemos un artículo nuevo
   * @return siguienteCodigo
   */
  private int generaCodigo() {
    return siguienteCodigo++;
  }

  // Creamos el método toString pra mostrar los artículos
  /**
   * Creamos el método toString pra mostrar los artículos
   */
  @Override
  public String toString() {
    return "CÓDIGO DEL ARTÍCULO: " + codigo + "\n"+
           "DESCRIPCIÓN: " + descripcion + "\n"+
           "PRECIO DE COMPRA: " + precioCompra + "\n"+
           "PRECIO DE VENTA: " + precioVenta + "\n"+
           "NÚMERO DE UNIDADES: " + numUnidades + "\n";
  }
  
  /**
   * 
   */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  /**
   * 
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  // Método para dar entrada a una cantidad de unidades de un artículo del almacén
  /**
   * Método para dar entrada a una cantidad de unidades de un artículo del almacén y controlar que no sean negativas
   * @param cantidad
   * @throws UnidadesNegativasErrorExcepcion 
   */

  void entradaMercancia(int cantidad) throws UnidadesNegativasErrorExcepcion {
    if (cantidad < 0) 
      throw new UnidadesNegativasErrorExcepcion("Las unidades no pueden ser negativas");
    setNumUnidades(getNumUnidades() + cantidad); 
  }
  
  // Método para dar salida  a una cantidad de unidades de un artículo del almacén
  /**
   * Método para dar salida  a una cantidad de unidades de un artículo del almacén
   * @param cantidad
   * @throws UnidadesNegativasErrorExcepcion 
   */

  void salidaMercancia(int cantidad) throws UnidadesNegativasErrorExcepcion {
    if (cantidad < 0) 
      throw new UnidadesNegativasErrorExcepcion("Las unidades no pueden ser negativas");
    setNumUnidades(getNumUnidades() - cantidad);
  }

}
